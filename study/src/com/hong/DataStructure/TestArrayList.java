package com.hong.DataStructure;

import java.util.ArrayList;
import java.util.List;

import com.hong.lambda.model.Student;

public class TestArrayList {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		int age = 18;
		Student s1 = new Student();
		s1.setName("aaaa");
		Student s2 = new Student();
		s2.setName("bbbb");
		Student s3 = new Student();
		s3.setName("ccc");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for (Student st : list) {
			st.setAge(age);
			age++;
		}
		System.out.println(list);

	}

}
