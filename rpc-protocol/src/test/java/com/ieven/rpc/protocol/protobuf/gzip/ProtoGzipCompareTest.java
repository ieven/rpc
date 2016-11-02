package com.ieven.rpc.protocol.protobuf.gzip;

import org.junit.Test;

public class ProtoGzipCompareTest {

	private ProtoGzipCompare protoBaseCompare = new ProtoGzipCompare("D:/protocol/proto/proto_in_gzip.proto",
			"D:/protocol/proto/proto_out_gzip.proto");

	@Test
	public void test() {
		protoBaseCompare.reportResult();
	}
}
