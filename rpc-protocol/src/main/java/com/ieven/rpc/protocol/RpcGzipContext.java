package com.ieven.rpc.protocol;

/**
 * 使用了gzip压缩的上下文
 * 
 * @author lichong
 *
 */
public class RpcGzipContext extends RpcContext {
	
	/**
	 * gzip压缩开始时间
	 */
	private long gzipCompressBeginTime;
	
	/**
	 * gzip解压缩开始时间
	 */
	private long gzipUncompressBeginTime;
	
	/**
	 * gzip压缩结束时间
	 */
	private long gzipCompressEndTime;
	
	/**
	 * gzip解压缩结束时间
	 */
	private long gzipUncompressEndTime;

	public long getGzipCompressBeginTime() {
		return gzipCompressBeginTime;
	}

	public void setGzipCompressBeginTime(long gzipCompressBeginTime) {
		this.gzipCompressBeginTime = gzipCompressBeginTime;
	}

	public long getGzipUncompressBeginTime() {
		return gzipUncompressBeginTime;
	}

	public void setGzipUncompressBeginTime(long gzipUncompressBeginTime) {
		this.gzipUncompressBeginTime = gzipUncompressBeginTime;
	}

	public long getGzipCompressEndTime() {
		return gzipCompressEndTime;
	}

	public void setGzipCompressEndTime(long gzipCompressEndTime) {
		this.gzipCompressEndTime = gzipCompressEndTime;
	}

	public long getGzipUncompressEndTime() {
		return gzipUncompressEndTime;
	}

	public void setGzipUncompressEndTime(long gzipUncompressEndTime) {
		this.gzipUncompressEndTime = gzipUncompressEndTime;
	}
}
