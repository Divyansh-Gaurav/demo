package com.example.demo.regex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegExps {
	public static void main(String[] args) throws IOException {

		final String SUBNET_REGEX = "(?<Key>Subnet Mask)(.*:)\\s(?<Value>[0-9.]*)";
		final String IPv4_REGEX="(?<Key>IPv4 Address)(.*:)\\s(?<Value>[0-9.]+)";
		final String MEDIA_STATE="(?<Key>Media State)(.*:)\\s(?<Value>.*)";
		final String TCP="(?<Key>TCP)(\\s*)([0-9.:]*)(\\s*)(?<Value>.*)";
		final String FILE_PATH="D:/python/pyfile1.txt";

		File file = new File(FILE_PATH);
        FileInputStream fin = null;
		try {
			fin = new FileInputStream(file);

			byte fileContent[] = new byte[(int) file.length()];

			fin.read(fileContent);
			String data = new String(fileContent);
			getRegExOutput(SUBNET_REGEX, data);
			getRegExOutput(IPv4_REGEX, data);
			getRegExOutput(MEDIA_STATE, data);
			getRegExOutput(TCP, data);
		} catch (FileNotFoundException e) {
			System.out.println("File not found" + e);
		}
    catch (IOException ioe) {
        System.out.println("Exception while reading file " + ioe);
    }
    finally {
        // close the streams using close method
        try {
            if (fin != null) {
                fin.close();
            }
        }
        catch (IOException ioe) {
            System.out.println("Error while closing stream: " + ioe);
        }
    }
}

private static void getRegExOutput(String exp, String data) {
	Pattern pattern1 = Pattern.compile(exp);
	Matcher matcher1 = pattern1.matcher(data);
	while (matcher1.find()) {
		System.out.println("regex response for " + matcher1.group("Key") + "-" + matcher1.group("Value") + "\n");
	}
}
}
