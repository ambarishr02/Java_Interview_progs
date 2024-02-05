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
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataProcessor {

    public static void main(String[] args) {
        String filePath = "path_to_your_data.csv";
        int maxRecordsPerSlice = 500; // Set your dynamic chunk size

        sendSlicesToClient(filePath, maxRecordsPerSlice);
    }

    public static void sendSlicesToClient(String filePath, int maxRecordsPerSlice) {
        try (ProductIterator dataIterator = new ProductIterator(filePath, maxRecordsPerSlice)) {
            List<String> metadataList = new ArrayList<>();
            int sliceNumber = 1;

            while (dataIterator.hasNext()) {
                Product[] productsSlice = dataIterator.next();
                metadataList.add(storeSliceInTempFile(productsSlice, sliceNumber));
                sliceNumber++;
            }

            // Create metadata for the entire dataset
            String metadata = createMetadata(metadataList);

            // Send metadata to the client
         //TODO   sendBytesToClient(metadata.getBytes(StandardCharsets.UTF_8));

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

    public static String storeSliceInTempFile(Product[] productsSlice, int sliceNumber) throws IOException {
        // Create a temporary file for the slice
        File tempSliceFile = File.createTempFile("slice_" + sliceNumber + "_", ".tmp");

        // Write products to the temporary file
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tempSliceFile))) {
            objectOutputStream.writeObject(productsSlice);
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

    static class Product {
        private Integer productID;
        private String skunumber;
        private String name;
        private String productType;
        private Date introDate;

        public Product(Integer productID, String skunumber, String name, String productType, Date introDate) {
            this.productID = productID;
            this.skunumber = skunumber;
            this.name = name;
            this.productType = productType;
            this.introDate = introDate;
        }

        // Getters and setters

        @Override
        public String toString() {
            // Convert the product to a CSV format for sending to the client
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(introDate);
            return productID + "," + skunumber + "," + name + "," + productType + "," + formattedDate;
        }
    }

    static class ProductIterator implements AutoCloseable, Iterator<Product[]> {
        private final BufferedReader reader;
        private final int maxProductsPerSlice;

        public ProductIterator(String filePath, int maxProductsPerSlice) throws FileNotFoundException {
            this.reader = new BufferedReader(new FileReader(filePath));
            this.maxProductsPerSlice = maxProductsPerSlice;
        }

        @Override
        public boolean hasNext() {
            // Implement logic to check if there is more data to read
            // Return true if there is more data, false otherwise
            // Consider reading a line and checking if it's not null
            return true;  // Placeholder, update with actual logic
        }

        @Override
        public Product[] next() {
            // Implement logic to read the next chunk of data from the file
            // Return the chunk as an array of Product
            try {
                return readProductsSliceFromFile();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                return null;
            }
        }

        private Product[] readProductsSliceFromFile() throws IOException, ParseException {
            // Read the next slice of products from the file
            List<Product> productsSlice = new ArrayList<>();
            for (int i = 0; i < maxProductsPerSlice; i++) {
                String line = reader.readLine();
                if (line == null) {
                    break;  // Reached the end of the file
                }

                // Parse the CSV line and create a Product
                String[] parts = line.split(",");
                Integer productID = Integer.parseInt(parts[0]);
                String skunumber = parts[1];
                String name = parts[2];
                String productType = parts[3];
                Date introDate = new SimpleDateFormat("yyyy-MM-dd").parse(parts[4]);

                productsSlice.add(new Product(productID, skunumber, name, productType, introDate));
            }

            return productsSlice.isEmpty() ? null : productsSlice.toArray(new Product[0]);
        }

        @Override
        public void close() throws IOException {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
