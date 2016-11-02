package com.ieven.rpc.protocol.protobuf.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.protobuf.InvalidProtocolBufferException;
import com.ieven.rpc.protocol.AbstractGZIPFilesystemCompare;
import com.ieven.rpc.protocol.po.TeacherProto.Teacher;

public class ProtoGzipCompare extends AbstractGZIPFilesystemCompare{

	public ProtoGzipCompare(String filePathIn, String filePathOut) {
		super(filePathIn, filePathOut);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void serializeIntoContext() {
		// TODO Auto-generated method stub
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			((Teacher)getContext().getDeserializeObject()).writeTo(output);
			getContext().setDiskByte(output.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void deserializeIntoContext() {
		// TODO Auto-generated method stub
		try {
			Teacher teacher = Teacher.parseFrom(getContext().getContentByte());
			getContext().setDeserializeObject(teacher);
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
