package com.ieven.rpc.protocol.jsondata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.protobuf.util.JsonFormat;
import com.ieven.rpc.protocol.gzip.GZIPUtils;
import com.ieven.rpc.protocol.po.CarProperty;
import com.ieven.rpc.protocol.po.CarProperty.Car;

/**
 * 将json数据转换为proto
 * @author lichong
 *
 */
public class JsonToProtoGzip {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/测试例子/jsondata_format.txt"));
		FileOutputStream fos = new FileOutputStream("D:/测试例子/proto_jsondata_gzip.txt");
		String temp;
		CarProperty.Car.Builder builder = Car.newBuilder();
		int i=0;
		while((temp = reader.readLine())!=null){
			try {
				JsonFormat.parser().ignoringUnknownFields().merge(temp, builder);
				Car car = builder.build();
				fos.write(GZIPUtils.compress(car.toByteArray()));
				builder.clear();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				System.out.println(temp);
				builder.clear();
				System.out.println(i++);
			}
		}
		fos.flush();
	}
}
