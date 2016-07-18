package com.summer.model;



public class Employee {

	private int id;
	
	private String name;
	
	private String password;

	private int dep_id;
	
	private String position;
	
	private int salary;
	
	private Boolean sex;
	
	private Boolean if_manager;


	public Employee() {}
	

	public Employee(int id, String name, String password, int dep_id,
			String position, int salary, Boolean sex, Boolean if_manager) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.dep_id = dep_id;
		this.position = position;
		this.salary = salary;
		this.sex = sex;
		this.if_manager = if_manager;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDep_id() {
		return dep_id;
	}


	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Boolean getIf_manager() {
		return if_manager;
	}

	public void setIf_manager(Boolean if_manager) {
		this.if_manager = if_manager;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + ", dep_id=" + dep_id + ", position=" + position
				+ ", salary=" + salary + ", sex=" + sex + ", if_manager="
				+ if_manager + "]";
	}

	
}
