package com.ieven.rpc.protocol.build;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ieven.rpc.protocol.gzip.GZIPUtils;
import com.ieven.rpc.protocol.io.MInputStream;
import com.ieven.rpc.protocol.po.Student;
import com.ieven.rpc.protocol.po.Teacher;

public class JsonGzipFileBuild {

	private static int SIZE = ObjectSize.size;

	public static void main(String[] args) throws FileNotFoundException {
		write();
//		read();
	}

	public static void write(){
		List<Student> stuList = new ArrayList<Student>();
		for(int i=0;i<SIZE;i++){
			Student stu = new Student();
			stu.setAge(25);
			stu.setId(22);
			stu.setName("shun");
			stuList.add(stu);
		}

		Teacher teacher = new Teacher();
		teacher.setId(1);
		teacher.setName("testTea");
		teacher.setList(stuList);

		String result = new Gson().toJson(teacher);
		try {
			FileOutputStream fos = new FileOutputStream("D:/json_out_gzip---"+SIZE+".json");
			fos.write(GZIPUtils.compress(result));
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read() throws FileNotFoundException{
		String json = GZIPUtils.uncompressToString(MInputStream.read(new FileInputStream("D:/json_out_gzip---"+SIZE+".json")));
		System.out.println(json);
		Teacher teacher = new Gson().fromJson(json, Teacher.class);
		System.out.println("Teacher ID:" + teacher.getId() + ",Name:" + teacher.getName());
		for (Student stu : teacher.getList()) {
			System.out.println("Student ID:" + stu.getId() + ",Name:" + stu.getName() + ",Age:" + stu.getAge());
		}
	}
}
