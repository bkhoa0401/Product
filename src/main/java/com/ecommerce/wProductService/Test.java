package com.ecommerce.wProductService;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File folder = new File("/home/bkhoa0401/Documents/Product/img");
		File[] fileList = folder.listFiles();
		
		for (int i = 0; i < fileList.length; i++) {
			File oldFile = fileList[i];
			File newFile = new File("/home/bkhoa0401/Documents/Product/img/" + oldFile.getName().trim());
			oldFile.renameTo(newFile);
		}
		
		System.out.println("done");
	}
}
