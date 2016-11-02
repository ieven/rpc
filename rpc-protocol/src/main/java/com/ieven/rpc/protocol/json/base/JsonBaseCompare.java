package com.ieven.rpc.protocol.json.base;

import com.google.gson.Gson;
import com.ieven.rpc.protocol.AbstractFilesystemCompare;
import com.ieven.rpc.protocol.po.Teacher;

/**
 * 基础json
 * 
 * @author lichong
 *
 */
public class JsonBaseCompare extends AbstractFilesystemCompare {

	public JsonBaseCompare(String filePathIn, String filePathOut) {
		super(filePathIn, filePathOut);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void serializeIntoContext() {
		// TODO Auto-generated method stub
		String result = new Gson().toJson(getContext().getDeserializeObject());
		getContext().setDiskString(result);
	}

	@Override
	protected void deserializeIntoContext() {
		// TODO Auto-generated method stub
		Teacher teacher = new Gson().fromJson(getContext().getContentString(), Teacher.class);
		getContext().setDeserializeObject(teacher);
	}

}
