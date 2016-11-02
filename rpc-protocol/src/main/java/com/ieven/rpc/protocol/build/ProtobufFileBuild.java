package com.ieven.rpc.protocol.build;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ieven.rpc.protocol.gzip.GZIPUtils;
import com.ieven.rpc.protocol.io.MInputStream;
import com.ieven.rpc.protocol.po.StudentProto.Student;
import com.ieven.rpc.protocol.po.TeacherProto.Teacher;

public class ProtobufFileBuild {

	private static int SIZE = ObjectSize.size;

	public static void main(String[] args) throws IOException {
		read();
		// write();
	}

	public static void read() throws FileNotFoundException, IOException {
		Teacher teacher = Teacher
				.parseFrom(MInputStream.read(new FileInputStream("D:/proto_out---" + SIZE + ".proto")));
		System.out.println("Teacher ID:" + teacher.getId() + ",Name:" + teacher.getName());
		for (Student stu : teacher.getStudentListList()) {
			System.out.println("Student ID:" + stu.getId() + ",Name:" + stu.getName() + ",Age:" + stu.getAge());
		}
	}

	public static void write() throws IOException {

		// 构造List
		List<Student> stuBuilderList = new ArrayList<Student>();

		for (int i = 0; i < SIZE; i++) {
			Student.Builder stuBuilder = Student.newBuilder();
			stuBuilder.setAge(25);
			stuBuilder.setId(11);
			stuBuilder.setName("shun");
			stuBuilderList.add(stuBuilder.build());
		}

		Teacher.Builder teaBuilder = Teacher.newBuilder();
		teaBuilder.setId(1);
		teaBuilder.setName("testTea");
		teaBuilder.addAllStudentList(stuBuilderList);

		// 把gpb写入到文件
		FileOutputStream fos = new FileOutputStream("D:/proto_out---" + SIZE + ".proto");
		teaBuilder.build().writeTo(fos);
		fos.close();
	}
}
