package kr.hs.gdsw.network.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f1 = new File("C:\\Users\\DGSW\\testimage.png");
		FileInputStream fis = new FileInputStream(f1);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\DGSW\\testimage-1.png");
		
		int readsize;
		byte[] bytes = new byte[1024];
		
		while((readsize = fis.read(bytes)) != -1) {
			fos.write(bytes, 0, readsize);
		}
	}

}
