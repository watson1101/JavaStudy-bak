package com.hong.lambda.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.hong.lambda.model.Student;

public class LambdaTest {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("张三", 18, 5500L, "male"));
		list.add(new Student("李四", 19, 6500L, "male"));
		list.add(new Student("王五", 20, 1500L, "male"));
		list.add(new Student("小红", 28, 7500L, "female"));
		list.add(new Student("小兰", 25, 13500L, "female"));

		Map<String, Student> map = new HashMap<>();
		map.put("01", new Student("小青", 25, 3500L, "female"));
		map.put("02", new Student("小黑", 29, 13500L, "male"));
		map.put("03", new Student("小黄", 15, 500L, "male"));
		map.put("04", new Student("小紫", 18, 99500L, "female"));

		new LambdaTest().testArrayList(list);
		new LambdaTest().testHashMap(map);

	}

	private void testArrayList(List<Student> list) {
		// 列出所有的学生的name
		List<String> nameList = list.stream().map(v -> v.getName()).collect(Collectors.toList());
		System.out.println("列出所有的student的name: " + nameList);

		// 列出所有sex = female 的name
		List<String> girlNames = list.stream().filter(stu -> "female".equals(stu.getSex())).map(v -> v.getName())
				.collect(Collectors.toList());
		System.out.println("列出所有女生的name: " + girlNames);
		// 列出存款>6000的人
		List<Student> richStudents = list.stream().filter(stu -> stu.getMoney() > 6000L).map(v -> {
			return v;
		}).collect(Collectors.toList());
		System.out.println("列出所有存款大于6000的学生: " + richStudents);
	}

	private void testHashMap(Map<String, Student> map) {

	}
}
