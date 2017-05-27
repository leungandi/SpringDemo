package com.szl.springioc.model;

public class User {
	
	private String name;
	private int age;
	private String email;

	/**
	 * 无参构造(当我们生成有参构造时，默认的无参构造要自行添加)
	 */
	public User() {
		super();
	}
	
	/**
	 * 有参构造
	 * @param name
	 * @param age
	 * @param email
	 */
	public User(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}


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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
	}


}
