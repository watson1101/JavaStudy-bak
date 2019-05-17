package com.hong.model;

public class Student {
	private String name;
	private int age;
	private Long money;
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 有参构造方法
	 * @param name
	 * @param age
	 * @param money
	 * @param sex
	 */
	public Student(String name, int age, Long money, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
		this.sex = sex;
	}

	/**
	 * 无参构造方法
	 */
	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", money=" + money + ", sex=" + sex + "]";
	}

}
