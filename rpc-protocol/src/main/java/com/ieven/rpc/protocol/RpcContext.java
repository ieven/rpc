package com.ieven.rpc.protocol;

/**
 * 上下文
 * 
 * @author lichong
 *
 */
public class RpcContext {
	
	/**
	 * 字符串形式的数据内容
	 */
	private String contentString;
	
	/**
	 * 二进制数据形式的数据内容
	 */
	private byte[] contentByte;
	
	/**
	 * 待存入硬盘的字符串
	 */
	private String diskString;
	
	/**
	 * 待存入硬盘的二进制数组
	 */
	private byte[] diskByte;
	
	/**
	 * 开始读取时间
	 */
	private long readBeginTime = 0;
	
	/**
	 * 读取结束时间
	 */
	private long readEndTime = 0;
	
	/**
	 * 序列化开始时间
	 */
	private long serializeBeginTime = 0;
	
	/**
	 * 序列化结束时间
	 */
	private long serializeEndTime = 0;
	
	/**
	 * 反序列化开始时间
	 */
	private long deserializeBeginTime = 0;
	
	/**
	 * 反序列化结束时间
	 */
	private long deserializeEndTime = 0;
	
	/**
	 * 存储开始时间
	 */
	private long storeBeginTime = 0;
	
	/**
	 * 存储结束时间
	 */
	private long storeEndTime = 0;
	
	/**
	 * 序列化之后的对象
	 */
	private Object serializeObject;
	
	/**
	 * 反序列化之后的对象
	 */
	private Object deserializeObject;

	public Object getSerializeObject() {
		return serializeObject;
	}

	public void setSerializeObject(Object serializeObject) {
		this.serializeObject = serializeObject;
	}

	public Object getDeserializeObject() {
		return deserializeObject;
	}

	public void setDeserializeObject(Object deserializeObject) {
		this.deserializeObject = deserializeObject;
	}

	public long getReadBeginTime() {
		return readBeginTime;
	}

	public void setReadBeginTime(long readBeginTime) {
		this.readBeginTime = readBeginTime;
	}

	public long getReadEndTime() {
		return readEndTime;
	}

	public void setReadEndTime(long readEndTime) {
		this.readEndTime = readEndTime;
	}

	public long getSerializeBeginTime() {
		return serializeBeginTime;
	}

	public void setSerializeBeginTime(long serializeBeginTime) {
		this.serializeBeginTime = serializeBeginTime;
	}

	public long getSerializeEndTime() {
		return serializeEndTime;
	}

	public void setSerializeEndTime(long serializeEndTime) {
		this.serializeEndTime = serializeEndTime;
	}

	public long getDeserializeBeginTime() {
		return deserializeBeginTime;
	}

	public void setDeserializeBeginTime(long deserializeBeginTime) {
		this.deserializeBeginTime = deserializeBeginTime;
	}

	public long getDeserializeEndTime() {
		return deserializeEndTime;
	}

	public void setDeserializeEndTime(long deserializeEndTime) {
		this.deserializeEndTime = deserializeEndTime;
	}

	public long getStoreBeginTime() {
		return storeBeginTime;
	}

	public void setStoreBeginTime(long storeBeginTime) {
		this.storeBeginTime = storeBeginTime;
	}

	public long getStoreEndTime() {
		return storeEndTime;
	}

	public void setStoreEndTime(long storeEndTime) {
		this.storeEndTime = storeEndTime;
	}

	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public byte[] getContentByte() {
		return contentByte;
	}

	public void setContentByte(byte[] contentByte) {
		this.contentByte = contentByte;
	}
	
	public String getDiskString() {
		return diskString;
	}

	public void setDiskString(String diskString) {
		this.diskString = diskString;
	}

	public byte[] getDiskByte() {
		return diskByte;
	}

	public void setDiskByte(byte[] diskByte) {
		this.diskByte = diskByte;
	}

}
