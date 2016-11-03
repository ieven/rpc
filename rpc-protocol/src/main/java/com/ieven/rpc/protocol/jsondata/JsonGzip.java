package com.ieven.rpc.protocol.jsondata;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.ieven.rpc.protocol.gzip.GZIPUtils;

public class JsonGzip {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/测试例子/jsondata_format.txt"));
		FileOutputStream fos = new FileOutputStream("D:/测试例子/jsondata_gzip.txt");
		String temp;
		int i=0;
		while((temp = reader.readLine())!=null){
			try {
				fos.write(GZIPUtils.compress(temp));
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				System.out.println(temp);
				System.out.println(i++);
			}
		}
		fos.flush();
	}
}
