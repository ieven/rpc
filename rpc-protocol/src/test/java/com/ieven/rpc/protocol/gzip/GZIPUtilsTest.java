package com.ieven.rpc.protocol.gzip;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;

public class GZIPUtilsTest {
	
	@Test
	public void test(){
		String str = "%5B%7B%22lastUpdateTime%22%3A%222011-10-28+9%3A39%3A41%22%2C%22smsList%22%3A%5B%7B%22liveState%22%3A%221";
		System.out.println("原长度：" + str.length());
		System.out.println("压缩后字符串：" + GZIPUtils.compress(str).toString().length());
		System.out.println("解压缩后字符串：" + StringUtils.newStringUtf8(GZIPUtils.uncompress(GZIPUtils.compress(str))));
		System.out.println("解压缩后字符串：" + GZIPUtils.uncompressToString(GZIPUtils.compress(str)));
	}
}
