package com.summer.model;

public class Department {

	private int id;
	private String name;
	private int leader_id;
	
	
	public Department(int id, String name, int leader_id) {
		super();
		this.id = id;
		this.name = name;
		this.leader_id = leader_id;
	}

	public Department() {
		super();
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
	public int getLeader_id() {
		return leader_id;
	}
	public void setLeader_id(int leader_id) {
		this.leader_id = leader_id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", leader_id="
				+ leader_id + "]";
	}



}
