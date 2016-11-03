package com.ieven.rpc.protocol.jsondata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将从mysql中导出的jsondata格式化
 * 
 * @author lichong
 *
 */
public class JsondataFormat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("D:/测试例子/jsondata.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/测试例子/jsondata_format.txt"));
		int i = 0;
		String temp;
		while ((temp = reader.readLine()) != null) {
			temp = temp.replace("\"\"", "\"");
			temp = temp.substring(1);
			temp = temp.substring(0, temp.length()-1);
			if(temp.equals("{\"name\":\"test\"}")){
				System.out.println("22");
				continue;
			}
			writer.write(temp+"\n");
			writer.flush();
			System.out.println("----"+i++);
		}
	}

}
