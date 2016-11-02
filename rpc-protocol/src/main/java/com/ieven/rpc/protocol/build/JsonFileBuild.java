package com.ieven.rpc.protocol.build;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.ieven.rpc.protocol.po.Student;
import com.ieven.rpc.protocol.po.Teacher;

public class JsonFileBuild {

	private static int SIZE = ObjectSize.size;

	public static void main(String[] args) throws IOException {

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
		FileWriter fw = new FileWriter("D:/json_out---"+SIZE+".json");
		fw.write(result);
		fw.close();
	}

}
