package application.Helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Methods to read a File in different ways
 * 
 * @author Christian
 */
public class FileSystem {

	/**
	 * 
	 * @param path Path to File
	 * @return File Content as String Array
	 * @throws IOException
	 */
	public String[] getFileAsArray(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		int size = this.getFileSize(path);
		String[] array = new String[size];
		for (int j = 0; j <= size; j++) {
			array[j] = br.readLine();
		}
		br.close();
		return array;
	}

	public JSONObject getFileAsJSON(String path) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(path));
		return (JSONObject) obj;
	}

	public void writeFile(String path, String line) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			File datei = new File(path);
			if (!datei.exists()) {
				datei.createNewFile();
				bw.write(line);
			} else {
				bw.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param path String of Path of File to get the Size from
	 * @return int of Size
	 * @throws IOException
	 */
	private int getFileSize(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		int i = 0;
		while (line != null) {
			line = br.readLine();
			i++;
		}
		br.close();
		return i;
	}
}
