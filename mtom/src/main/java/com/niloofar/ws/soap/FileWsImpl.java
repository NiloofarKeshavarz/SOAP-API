package com.niloofar.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {
	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	String path = "C://Users//Nelly//MTOM-path//uploaded//test.jpg";

	@Override
	public void upload(DataHandler attachement) {
		try {
			inputStream = attachement.getInputStream();
			outputStream = new FileOutputStream(new File(path));
			byte[] b = new byte[100000];
			int byteRead = 0;
			while((byteRead = inputStream.read(b)) != -1) {
				outputStream.write(b, 0 , byteRead);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public DataHandler download() {
		// TODO Auto-generated method stub
		return new DataHandler(new FileDataSource (new File("C:\\Users\\Nelly\\MTOM-path\\test.jpg")));
	}

}
