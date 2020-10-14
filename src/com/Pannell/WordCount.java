package com.Pannell;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
import acmx.export.java.io.FileReader;

public class WordCount extends ConsoleProgram {

	private String theFileName;

	public void run() {
		demonstration();
	}

	public void demonstration() {
		// create a BufferedReader object to read from a user specified file
		BufferedReader inFile = getBufferedReader();
		
		println(getFileContents(inFile));
	}

	public BufferedReader getBufferedReader() {
		BufferedReader rd = null;

		while (rd == null) {
			try {
				String input = readLine("Please enter the file name: ");
				rd = new BufferedReader(new FileReader(input));
				theFileName = input;
			} catch (IOException e) {
				println("Nice try punk, that file doesn't exist.");
			}
		}

		return rd;
	}

	public String getFileContents(BufferedReader br) {
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;

		try {
			while (true) {
				String line = br.readLine();

				if (line == null) {
					break;
				}

				lineCount++;
				wordCount = wordCount + getWordCount(line);
				charCount = charCount + getCharCount(line);

			}
		} catch (IOException e) {
			println("Connection to file was lost");
		}

		return generateTheStringForOutput(lineCount, wordCount, charCount);
	}

	public String generateTheStringForOutput(int lineCount, int wordCount, int charCount) {
		StringBuilder str = new StringBuilder();

		str.append("File name = " + theFileName + "\n");
		str.append("The line count = " + lineCount + "\n");
		str.append("The word count = " + wordCount + "\n");
		str.append("The charCount = " + charCount + "\n");

		return str.toString();
	}

	public int getWordCount(String string) {

		if (string == null || string.isEmpty()) {
			return 0;
		}
		
		StringTokenizer stringTokenizer = new StringTokenizer(string);

		return stringTokenizer.countTokens();
	}

	public int getCharCount(String string) {
		if (string == null || string.isEmpty()) {
			return 0;
		}

		return string.length();
	}

}
