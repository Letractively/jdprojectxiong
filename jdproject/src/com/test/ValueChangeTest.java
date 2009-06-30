package com.test;

import javax.faces.event.ActionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValueChangeTest {
	private String name = "张三";
	private String age = "23";
	private Log log = LogFactory.getLog(ValueChangeTest.class);
	public String getName() {
	   return name;
	}
	public void setName(String name) {
	   this.name = name;
	}
	public String getAge() {
	   return age;
	}
	public void setAge(String age) {
	   this.age = age;
	}
	public void valueChange() {
	System.out.println(this.getName());
	System.out.println(this.getAge());
	   setName("李四");
	   log.info("value change invoke!");
	   System.out.println(this.getName()+ "value change invoke!");
	}

	public void ActionListenerTest(ActionEvent e){
	   log.info("action event invoke!");
	   System.out.println("action event invoke!");
	}
	public void valueAction(ActionEvent e) {
	   log.info("age: "+ getAge());
	   System.out.println("age: "+ getAge());
	   log.info("name: "+ getName());
	   System.out.println("name: "+ getName());
	}
	}

