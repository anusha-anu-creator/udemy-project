package com.test.academy.beans;

public class Test {
	public String name;
	public Test(String name, String gender) {
		// TODO Auto-generated constructor stub
		if(gender == "male") {
			this.name = "Mr." + name;
		} else {
			this.name = "Miss." + name;
		}
	}
}
