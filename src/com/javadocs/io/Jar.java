package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

public class Jar {

	public static void main(String args[]) {
		Jar jar = new Jar();
		try {
			jar.putJarEntry();
			jar.getAllJarEntries();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void putJarEntry() throws IOException {
		JarEntry jarEntry = new JarEntry("Words-Do-Hurt.jpg");
		File source = new File("E:/Words-Do-Hurt.jpg");
		File destination = new File("E:/MyJar.jar");
		
		destination.createNewFile();
		FileInputStream fis = new FileInputStream(source);
		JarOutputStream jos = new JarOutputStream(new FileOutputStream(destination));
		jos.putNextEntry(jarEntry);
		
		int read = fis.read();
		while(read != -1) {
			jos.write(read);
			read = fis.read();
		}
		fis.close();
		jos.close();
	}
	
	public void getAllJarEntries() throws IOException {
		JarFile jar = new JarFile("E:/org.eclipse.mylyn.commons.xmlrpc_3.14.2.v20150217-2244.jar");
		Enumeration<? extends JarEntry> enumeration = jar.entries();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
