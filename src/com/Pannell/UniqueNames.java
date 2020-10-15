package com.Pannell;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram {

	private ArrayList<String> arrList = new ArrayList<String>();
	
	public void run() {
		demonstration();
	}
	
	public void demonstration() {
		addNamesToList();
		displayList();
	}
	
	public void addNamesToList() {
		while(true) {
			String name = getNameFromUser();
			
			if(name.isEmpty() || name == null) {
				break;
			}
			
			if(!doesListContainName(name)) {
				arrList.add(name);
			}
		}
	}
	
	public boolean doesListContainName(String string) {
		if(arrList.contains(string) ) {
			return true;
		}
		return false;
	}
	
	public void displayList() {
		println("Unique Names:");
		for(int i = 0; i < arrList.size(); i++) {
			println(arrList.get(i));
		}
	}
	
	public String getNameFromUser() {
		String input = readLine("Enter a name: ");
		
		return input;
	}
	
}
