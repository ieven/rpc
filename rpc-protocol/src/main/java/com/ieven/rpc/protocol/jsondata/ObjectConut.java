package com.ieven.rpc.protocol.jsondata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统计最近5000条内jsondata数据一级元素个数
 * 
 * @author lichong
 *
 */
public class ObjectConut {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("D:/测试例子/jsondata_format.txt"));
		Map<String, Set<String>> elementMap = new HashMap<>();
		ObjectMapper MAPPER = new ObjectMapper();
		String temp;
		while((temp = reader.readLine())!=null){
			try {
				JsonNode jsonNode = MAPPER.readTree(temp);
				Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
				while(iterator.hasNext()){
					Map.Entry<String, JsonNode> entry = iterator.next();
					if(elementMap.containsKey(entry.getKey())){
						elementMap.get(entry.getKey()).add(entry.getValue().getNodeType()+"");
					}
					else
					{
						Set<String> inner = new HashSet<>();
						inner.add(entry.getValue().getNodeType()+"");
						elementMap.put(entry.getKey(), inner);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(temp);
			}
			
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/测试例子/jsondata_element.txt"));
		int i = 16;
		for(Map.Entry<String, Set<String>> entry: elementMap.entrySet()){
			for(String str:entry.getValue()){
				System.out.println(entry.getKey()+"------"+str);
				writer.write("string "+entry.getKey()+" = "+i+"-----"+str+"\n");
				writer.flush();
			}
			i++;
		}
	}
	
}
