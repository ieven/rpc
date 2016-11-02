package com.ieven.rpc.protocol.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.ieven.rpc.protocol.build.ObjectSize;

public class MInputStreamTest {
	
	private static final int SIZE = ObjectSize.size;
	
	@Test
	public void test(){
		try {
			byte[] b = MInputStream.read(new FileInputStream("D:/proto_out---"+SIZE+".proto"));
			FileOutputStream fileOut = new FileOutputStream("D:/proto_out.proto");
			fileOut.write(b);
			fileOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
