package FileHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String line;

		try {
			FileInputStream fin = new FileInputStream("C:\\Users\\ambar\\Documents\\eclipse-workspace\\eclipse-workspace\\Test1.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);

			}
			fin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ambar\\Documents\\eclipse-workspace\\eclipse-workspace\\Test1.txt"))) {

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		}
	}

}
