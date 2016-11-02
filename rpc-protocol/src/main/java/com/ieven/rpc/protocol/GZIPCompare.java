package com.ieven.rpc.protocol;

/**
 * gzip比较
 * @author lichong
 *
 */
public interface GZIPCompare {
	
	/**
	 * 使用gzip压缩
	 */
	public void gzipCompress();
	
	/**
	 * 使用gzip解压缩
	 */
	public void gzipUncompress();
}
