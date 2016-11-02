package com.ieven.rpc.protocol;

/**
 * 定义不同比较维度
 * 
 * @author lichong
 *
 */
public interface RpcCompare {
	
	/**
	 * 序列化
	 */
	public void serialize();
	
	/**
	 * 反序列化
	 */
	public void deserialize();
	
	/**
	 * 从硬盘读取
	 */
	public void readFormDisk();
	
	/**
	 * 存储到硬盘
	 */
	public void storeToDisk();
	
	/**
	 * 汇报本次结果
	 */
	public void reportResult();
}
