package com.ieven.rpc.protocol.json.gzip;

import org.junit.Test;

public class JsonGzipCompareTest {
	private JsonGzipCompare json = new JsonGzipCompare("D:/protocol/json/json_in_gzip.json",
			"D:/protocol/json/json_out_gzip.json");

	@Test
	public void test() {
		json.reportResult();
	}
}
