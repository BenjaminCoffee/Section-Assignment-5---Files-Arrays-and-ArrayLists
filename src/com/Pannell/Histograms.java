package com.Pannell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.naming.StringRefAddr;

import acm.program.ConsoleProgram;
import acmx.export.java.io.FileReader;

public class Histograms extends ConsoleProgram {

	private String theInFileName;
	private String outputFile = "copy.txt";
	private String[] outPut = new String[11];

	public void run() {
		demonstration();
	}

	public void demonstration() {
		initializeOutPutArray();
		BufferedReader rd = getBufferedReader();
		writeStarsToArray(rd);
		PrintWriter pr = getPrintWriter();
		printArrayToFile(pr);
	}
	
	public void printArrayToFile(PrintWriter pr) {
		for(int i = 0; i < outPut.length; i++) {
			pr.println(outPut[i]);
		}
		
		pr.close();
	}

	public void writeStarsToArray(BufferedReader rd) {

		try {

			while (true) {

				String line = rd.readLine();
				if (line != null) {
					line = line.trim();
				}
				if (line == null || line.isEmpty()) {
					break;
				}
				int score = Integer.valueOf(line);

				addStarsToOutPutArray(score);
			}

			rd.close();

		} catch (IOException e) {
			println("Something bad happened");
		}

	}

	public BufferedReader getBufferedReader() {
		BufferedReader rd = null;

		while (rd == null) {
			try {
				String input = "MidtermScores.txt";//readLine("Please enter the file name: ");
				rd = new BufferedReader(new FileReader(input));
				theInFileName = input;
			} catch (IOException e) {
				println("Nice try punk, that file doesn't exist.");
			}
		}

		return rd;
	}

	public PrintWriter getPrintWriter() {
		PrintWriter pr = null;

		try {
			pr = new PrintWriter(outputFile);
		} catch (IOException e) {
			println("Could not connect to " + outputFile);
		}
		return pr;
	}

	public void initializeOutPutArray() {

		outPut[0] = "00-09: ";
		outPut[1] = "10-19: ";
		outPut[2] = "20-29: ";
		outPut[3] = "30-39: ";
		outPut[4] = "40-49: ";
		outPut[5] = "50-59: ";
		outPut[6] = "60-69: ";
		outPut[7] = "70-79: ";
		outPut[8] = "80-89: ";
		outPut[9] = "90-99: ";
		outPut[10] = "100: ";

	}

	public void addStarsToOutPutArray(int score) {
		
		score = (score /10 * 10);
		for (int i = 1; i < outPut.length; i++) {

			if (score >= 0 && score <= 9) {
				outPut[0] = outPut[0] + "*";
				break;
			}

			if (score == 100) {
				outPut[10] = outPut[10] + "*";
				break;
			}

			String value = (String.valueOf(outPut[i].charAt(0)) + String.valueOf(outPut[i].charAt(1)));

			int intValue = Integer.valueOf(value);

			if (score >= intValue && score <= intValue) {
				outPut[i] = outPut[i] + "*";
				break;
			}
		}
	}
}
