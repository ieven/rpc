package com.ieven.rpc.protocol;

import com.ieven.rpc.protocol.gzip.GZIPUtils;

/**
 * 使用gzip压缩并且数据源为file的比较
 * 
 * @author lichong
 *
 */
public abstract class AbstractGZIPFilesystemCompare extends AbstractFilesystemCompare implements GZIPCompare {

	public AbstractGZIPFilesystemCompare(String filePathIn, String filePathOut) {
		super(filePathIn, filePathOut,new RpcGzipContext());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gzipCompress() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("gzip压缩开始时间为：" + begin);
		((RpcGzipContext)getContext()).setGzipCompressBeginTime(begin);
		if(getContext().getDiskByte()!=null&&getContext().getDiskByte().length!=0){
			getContext().setDiskByte(GZIPUtils.compress(getContext().getDiskByte()));
		}else if(getContext().getDiskString()!=null){
			getContext().setDiskByte(GZIPUtils.compress(getContext().getDiskString()));
			getContext().setDiskString(null);
		}
		long end = System.currentTimeMillis();
		getLogger().info("gzip压缩结束时间为：" + end);
		((RpcGzipContext)getContext()).setGzipCompressEndTime(end);
	}

	@Override
	public void gzipUncompress() {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		getLogger().info("gzip解压缩开始时间为：" + begin);
		((RpcGzipContext)getContext()).setGzipUncompressBeginTime(begin);
		if(getContext().getContentByte()!=null&&getContext().getContentByte().length!=0){
			byte[] temp = getContext().getContentByte();
			getContext().setContentByte((GZIPUtils.uncompress(temp)));
			getContext().setContentString((GZIPUtils.uncompressToString(temp)));
		}
		long end = System.currentTimeMillis();
		getLogger().info("gzip解压缩结束时间为：" + end);
		((RpcGzipContext)getContext()).setGzipUncompressEndTime(end);
	}

	@Override
	protected void runningSequential() {
		readFormDisk();
		gzipUncompress();
		deserialize();
		serialize();
		gzipCompress();
		storeToDisk();
	}
	
	@Override
	protected void report() {
		getLogger().info("运行结果：");
		if(getContext().getReadBeginTime()!=0&&getContext().getReadEndTime()!=0){
			getLogger().info("读取花费时间:"+(getContext().getReadEndTime()-getContext().getReadBeginTime()));
		}
		if(((RpcGzipContext)getContext()).getGzipUncompressBeginTime()!=0&&((RpcGzipContext)getContext()).getGzipUncompressEndTime()!=0){
			getLogger().info("gzip解压缩花费时间:"+(((RpcGzipContext)getContext()).getGzipUncompressEndTime()-((RpcGzipContext)getContext()).getGzipUncompressBeginTime()));
		}
		if(getContext().getDeserializeBeginTime()!=0&&getContext().getDeserializeEndTime()!=0){
			getLogger().info("反序列化花费时间:"+(getContext().getDeserializeEndTime()-getContext().getDeserializeBeginTime()));
		}
		if(getContext().getSerializeBeginTime()!=0&&getContext().getSerializeEndTime()!=0){
			getLogger().info("序列化花费的时间："+(getContext().getSerializeEndTime()-getContext().getSerializeBeginTime()));
		}
		if(((RpcGzipContext)getContext()).getGzipCompressBeginTime()!=0&&((RpcGzipContext)getContext()).getGzipCompressEndTime()!=0){
			getLogger().info("gzip压缩花费时间:"+(((RpcGzipContext)getContext()).getGzipCompressEndTime()-((RpcGzipContext)getContext()).getGzipCompressBeginTime()));
		}
		if(getContext().getStoreBeginTime()!=0&&getContext().getStoreEndTime()!=0){
			getLogger().info("存储花费的时间:"+(getContext().getStoreEndTime()-getContext().getStoreBeginTime()));
		}
	}
}
