package POC;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProcessor {

    public static void main(String[] args) {
        String filePath = "path_to_your_data.csv";
        int maxRecordsPerSlice = 500; // Set your dynamic chunk size

        sendSlicesToClient(filePath, maxRecordsPerSlice);
    }

    public static void sendSlicesToClient(String filePath, int maxRecordsPerSlice) {
        try (CustomerRecordIterator dataIterator = new CustomerRecordIterator(filePath, maxRecordsPerSlice)) {
            List<String> metadataList = new ArrayList<>();
            int sliceNumber = 1;

            while (dataIterator.hasNext()) {
                CustomerRecord[] recordsSlice = dataIterator.next();
                metadataList.add(storeSliceInTempFile(recordsSlice, sliceNumber));
                sliceNumber++;
            }

            // Create metadata for the entire dataset
            String metadata = createMetadata(metadataList);

            // Send metadata to the client
            sendBytesToClient(metadata.getBytes(StandardCharsets.UTF_8));

            // Send each temporary slice file to the client
            for (String tempSliceFilePath : metadataList) {
                sendSliceToClient(tempSliceFilePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendSliceToClient(String filePath) {
        try {
            // Read the slice data from the temporary file
            byte[] sliceData = readFileBytes(filePath);

            // Compute MD5 checksum of the slice data
            String checksum = computeMD5Checksum(sliceData);

            // Send slice data and checksum to the client
            sendBytesToClient(sliceData, filePath, checksum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String storeSliceInTempFile(CustomerRecord[] recordsSlice, int sliceNumber) throws IOException {
        // Create a temporary file for the slice
        File tempSliceFile = File.createTempFile("slice_" + sliceNumber + "_", ".tmp");

        // Write records to the temporary file
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempSliceFile))) {
            objectOutputStream.writeObject(recordsSlice);
        }

        return tempSliceFile.getAbsolutePath();
    }

    public static String createMetadata(List<String> tempSliceFilePaths) {
        // Create metadata string
        StringBuilder metadataBuilder = new StringBuilder();
        for (String tempSliceFilePath : tempSliceFilePaths) {
            metadataBuilder.append(tempSliceFilePath).append(",");
        }
        return metadataBuilder.toString();
    }

    public static void sendBytesToClient(byte[] data, String filePath, String checksum) {
        // Implement sending bytes to the client (e.g., through HTTP response, WebSocket)
        // Send metadata, the temporary slice file, and checksum to the client
        // Adjust based on your client communication requirements

        boolean sentSuccessfully = false;

        // Your code to send data to the client

        // Wait for acknowledgment from the client and validate checksum
        sentSuccessfully = waitForAcknowledgment(filePath, checksum);

        if (sentSuccessfully) {
            System.out.println("File sent successfully: " + filePath);
        } else {
            System.out.println("Failed to send file: " + filePath);
        }
    }

    public static boolean waitForAcknowledgment(String filePath, String expectedChecksum) {
        // Simulate waiting for acknowledgment (replace with your actual implementation)
        // For simplicity, this method always returns true.
        // You may want to implement more robust acknowledgment handling.

        try {
            Thread.sleep(1000); // Sleep for 1 second (replace with your actual timeout)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // For simplicity, assume acknowledgment is received successfully and checksum matches
        return true;
    }

    public static String computeMD5Checksum(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data);
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public static byte[] readFileBytes(String filePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

    static class CustomerRecord {
        private String customerId;
        private String name;
        private String address;
        private String account;
        private double balance;
        private String rating;

        public CustomerRecord(String customerId, String name, String address, String account, double balance, String rating) {
            this.customerId = customerId;
            this.name = name;
            this.address = address;
            this.account = account;
            this.balance = balance;
            this.rating = rating;
        }

        // Getters and setters

        @Override
        public String toString() {
            // Convert the record to a CSV format for sending to the client
            return customerId + "," + name + "," + address + "," + account + "," + balance + "," + rating;
        }
    }

    static class CustomerRecordIterator implements AutoCloseable, Iterator<CustomerRecord[]> {
        private final BufferedReader reader;
        private final int maxRecordsPerSlice;

        public CustomerRecordIterator(String filePath, int maxRecordsPerSlice) throws FileNotFoundException {
            this.reader = new BufferedReader(new FileReader(filePath));
            this.maxRecordsPerSlice = maxRecordsPerSlice;
        }

        @Override
        public boolean hasNext() {
            // Implement logic to check if there is more data to read
            // Return true if there is more data, false otherwise
            // Consider reading a line and checking if it's not null
            return true;  // Placeholder, update with actual logic
        }

        @Override
        public CustomerRecord[] next() {
            // Implement logic to read the next chunk of data from the file
            // Return the chunk as an array of CustomerRecord
            try {
                return readRecordsSliceFromFile();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        private CustomerRecord[] readRecordsSliceFromFile() throws IOException, ClassNotFoundException {
            // Read the next slice of records from the file
            List<CustomerRecord> recordsSlice = new ArrayList<>();
            for (int i = 0; i < maxRecordsPerSlice; i++) {
                String line = reader.readLine();
                if (line == null) {
                    break;  // Reached the end of the file
                }

                // Parse the CSV line and create a CustomerRecord
                String[] parts = line.split(",");
                String customerId = parts[0];
                String name = parts[1];
                String address = parts[2];
                String account = parts[3];
                double balance = Double.parseDouble(parts[4]);
                recordsSlice.add(new CustomerRecord(customerId, name, address, account, balance, null));
            }

            return recordsSlice.isEmpty() ? null : recordsSlice.toArray(new CustomerRecord[0]);
        }

        @Override
        public void close() throws IOException {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
               

