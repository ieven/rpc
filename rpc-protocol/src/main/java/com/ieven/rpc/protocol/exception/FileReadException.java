package com.ieven.rpc.protocol.exception;

import com.ieven.ext.util.excepiton.NestedCheckException;
import com.ieven.ext.util.excepiton.NestedRuntimeException;

public class FileReadException extends NestedRuntimeException{

	public FileReadException(String msg, Throwable e) {
		super(msg, e);
		// TODO Auto-generated constructor stub
	}

	public FileReadException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
