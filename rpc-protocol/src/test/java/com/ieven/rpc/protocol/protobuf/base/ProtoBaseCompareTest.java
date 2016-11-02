package com.ieven.rpc.protocol.protobuf.base;

import org.junit.Test;

public class ProtoBaseCompareTest {
	
	private ProtoBaseCompare protoBaseCompare = new ProtoBaseCompare("D:/protocol/proto/proto_in.proto", "D:/protocol/proto/proto_out.proto");
	
	@Test
	public void test(){
		protoBaseCompare.reportResult();
	}
	
}
