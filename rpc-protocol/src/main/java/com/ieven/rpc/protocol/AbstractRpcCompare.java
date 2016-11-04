package com.ieven.rpc.protocol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractRpcCompare implements RpcCompare {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public Logger getLogger() {
		return logger;
	}

	private RpcContext context;
	
	public AbstractRpcCompare(){
		this.context = new RpcContext();
	}

	public AbstractRpcCompare(RpcContext context){
		this.context = context;
	}
	
	public RpcContext getContext() {
		return context;
	}

	public void setContext(RpcContext context) {
		this.context = context;
	}

	@Override
	public void readFormDisk() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("读取开始时间为：" + begin);
		this.context.setReadBeginTime(begin);
		readIntoContext();
		long end = System.currentTimeMillis();
		getLogger().info("读取结束时间为：" + end);
		this.context.setReadEndTime(end);
	}

	/**
	 * 将指定文件内容读取进上下文
	 * 
	 */
	protected abstract void readIntoContext();

	@Override
	public void storeToDisk() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("存储开始时间为：" + begin);
		this.context.setStoreBeginTime(begin);
		storeFromContext();
		long end = System.currentTimeMillis();
		getLogger().info("存储结束时间为：" + end);
		this.context.setStoreEndTime(end);
	}

	/**
	 * 将特定内容从上下文写入硬盘
	 * 
	 */
	protected abstract void storeFromContext();

	@Override
	public void serialize() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("序列化开始时间为：" + begin);
		this.context.setSerializeBeginTime(begin);
		serializeIntoContext();
		long end = System.currentTimeMillis();
		getLogger().info("序列化结束时间为：" + end);
		this.context.setSerializeEndTime(end);
	}

	/**
	 * 将指定对象序列化并放入上下文
	 */
	protected abstract void serializeIntoContext();

	@Override
	public void deserialize() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("反序列化开始时间为：" + begin);
		this.context.setDeserializeBeginTime(begin);
		deserializeIntoContext();
		long end = System.currentTimeMillis();
		getLogger().info("反序列化结束时间为：" + end);
		this.context.setDeserializeEndTime(end);
	}

	/**
	 * 将指定对象反序列化并放入上下文
	 */
	protected abstract void deserializeIntoContext();
	
	@Override
	public void reportResult() {
		// TODO Auto-generated method stub
		runningSequential();
		report();
	}
	
	/**
	 * 运行顺序
	 */
	protected void runningSequential() {
		readFormDisk();
		deserialize();
		serialize();
		storeToDisk();
	}
	
	/**
	 * 汇报本次执行结果
	 */
	protected void report() {
		getLogger().info("运行结果：");
		if(getContext().getReadBeginTime()!=0&&getContext().getReadEndTime()!=0){
			getLogger().info("读取花费时间:"+(getContext().getReadEndTime()-getContext().getReadBeginTime()));
		}
		if(getContext().getDeserializeBeginTime()!=0&&getContext().getDeserializeEndTime()!=0){
			getLogger().info("反序列化花费时间:"+(getContext().getDeserializeEndTime()-getContext().getDeserializeBeginTime()));
		}
		if(getContext().getSerializeBeginTime()!=0&&getContext().getSerializeEndTime()!=0){
			getLogger().info("序列化花费的时间："+(getContext().getSerializeEndTime()-getContext().getSerializeBeginTime()));
		}
		if(getContext().getStoreBeginTime()!=0&&getContext().getStoreEndTime()!=0){
			getLogger().info("存储花费的时间:"+(getContext().getStoreEndTime()-getContext().getStoreBeginTime()));
		}
	}
}
