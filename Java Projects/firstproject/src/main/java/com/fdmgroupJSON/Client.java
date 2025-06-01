package com.fdmgroupJSON;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
	
	public static void main(String[] args) {
		
	
	
	//CreatingTheFile
		File file= new File ("C:/Users/Fatim/eclipse-workspace/firstproject/src/main/resources/books.json");
		
		
	//Method
		Book[] books = readFromJSONFile(file);
		PrintBooks(Arrays.asList(books));
		
	//serialIzation
		
		
	
		
	


}

	// Deserialization
	private static Book[] readFromJSONFile(File file) {
		ObjectMapper objectMapper= new ObjectMapper();
		Book[] readFromJSONFile= objectMapper.readValue(file,books);
		return null;
	}

	private static void PrintBooks(List<Book> books) {
		eachbook.
		
	}
}