package com.lambda.www.day2;

public class User{
	private int age;
	private String name;
	private boolean isGirl;
	public User(int age,String name,boolean isGirl) {
		this.age = age;
		this.isGirl = isGirl;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGirl() {
		return isGirl;
	}
	public void setGirl(boolean isGirl) {
		this.isGirl = isGirl;
	}
	
}