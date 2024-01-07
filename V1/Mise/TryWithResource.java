package Mise;

import java.io.*;

public class TryWithResource {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String line;

		try {
			FileInputStream fin = new FileInputStream("/Users/aramachandr/eclipse-workspace/Test1.txt");
			int i = 0;
			while ((i = fin.read()) != -1) {
				System.out.print((char) i);

			}
			fin.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		try (BufferedReader br = new BufferedReader(new FileReader("/Users/aramachandr/eclipse-workspace/Test1.txt"))) {

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		}
	}

}
