package com.ieven.rpc.protocol;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ieven.ext.util.io.FileSystemResource;
import com.ieven.ext.util.io.Resource;
import com.ieven.rpc.protocol.exception.FileReadException;
import com.ieven.rpc.protocol.io.MInputStream;

/**
 * 文件系统待比较者
 * @author lichong
 *
 */
public abstract class AbstractFilesystemCompare extends AbstractRpcCompare{

	/**
	 * 被读文件地址
	 */
	protected String filePathIn;
	
	/**
	 * 待写文件地址
	 */
	protected String filePathOut;
	
	public AbstractFilesystemCompare(String filePathIn,String filePathOut) {
		// TODO Auto-generated constructor stub
		this.filePathIn = filePathIn;
		this.filePathOut = filePathOut;
	}
	
	public AbstractFilesystemCompare(String filePathIn,String filePathOut,RpcContext context) {
		// TODO Auto-generated constructor stub
		super(context);
		this.filePathIn = filePathIn;
		this.filePathOut = filePathOut;
	}
	
	@Override
	protected void readIntoContext() {
		// TODO Auto-generated method stub
		try {
			Resource resource = new FileSystemResource(filePathIn);
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String str;
			str = reader.readLine();
			while (str != null) {
				builder.append(str);
				getLogger().debug("读取到的内容为:"+str);
				str = reader.readLine();
			}
			getContext().setContentString(builder.toString());
			getContext().setContentByte(MInputStream.read(resource.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				throw new FileReadException("读取文件出问题了", e);
			} catch (FileReadException e1) {
				// TODO Auto-generated catch block
				//ignore
			}
		}
		
	}

	@Override
	protected void storeFromContext() {
		// TODO Auto-generated method stub
		try {
			if(getContext().getDiskString()!=null){
				FileWriter fw = new FileWriter(filePathOut);
				fw.write(getContext().getDiskString());
				//防止数据丢失，将缓存区刷新
				fw.flush();
			}
			else if(getContext().getDiskByte()!=null&&getContext().getDiskByte().length!=0){
				FileOutputStream fileOut = new FileOutputStream(filePathOut);
				fileOut.write(getContext().getDiskByte());
				//防止数据丢失，将缓存区刷新
				fileOut.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				throw new FileReadException("写文件出问题了", e);
			} catch (FileReadException e1) {
				// TODO Auto-generated catch block
				//ignore
			}
		}
	}

}
