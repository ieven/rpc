package com.ieven.rpc.protocol.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义一个能够直接读取出byte[]的input流，性能堪忧
 * @author lichong
 *
 */
public class MInputStream {
	
	private static int size = 2048;
	
	/**
	 * 从inputstream中读取数据到byte[]中
	 * @param inputStream
	 * @return
	 */
	public static byte[] read(InputStream inputStream){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[size];
		int n;
		try {
			while ((n = inputStream.read(buffer)) >= 0) {
				out.write(buffer, 0, n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toByteArray();
	}
}
