package com.ieven.rpc.protocol.json.base;

import org.junit.Test;

public class JsonBaseCompareTest {
	
	private JsonBaseCompare json = new JsonBaseCompare("D:/protocol/json/json_in.json", "D:/protocol/json/json_out.json");
	
	@Test
	public void test(){
		json.reportResult();
	}
	
}
