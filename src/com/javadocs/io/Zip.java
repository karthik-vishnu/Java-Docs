package com.javadocs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

	public static void main(String args[]) {

		Zip zip = new Zip();
		zip.createZipFile();
		zip.readWriteGZIP();
	}
	
	public void createZipFile() {
		
		File file = new File("E:/Mufti-Blue--Green-Checked-Casual-Shirt_4_9488893fea12b7d3255d7825acaac490.jpg");
		File zip = new File("E:/myZip.rar");
		
		try {
			zip.createNewFile();
			ZipEntry zipEntry = new ZipEntry("E:/Mufti.jpg");
				
			System.out.println(zipEntry.getName());
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip));
			zos.putNextEntry(zipEntry);
			
			FileInputStream fis = new FileInputStream(file);
			
			int read = fis.read();
			
			while(read != -1) {
				zos.write(read);
				read = fis.read();
			}
			fis.close();
			zos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readWriteGZIP() {
		File file = new File("E:/phayes-geoPHP-1.2-20-g6855624.tar.gz");
		File destination = new File("E:/Myzip.tar.gz");
		try {
			destination.createNewFile();
			GZIPInputStream zipInputStream = new GZIPInputStream(new FileInputStream(file));
			GZIPOutputStream zipOutputStream = new GZIPOutputStream(new FileOutputStream(destination));
			int read = zipInputStream.read();
			while(read != -1) {
				zipOutputStream.write(read);
				read = zipInputStream.read();
			}
			
			zipInputStream.close();
			zipOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
