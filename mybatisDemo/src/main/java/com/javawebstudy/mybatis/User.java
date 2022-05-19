package com.javawebstudy.mybatis;

/**
 * @author Jiahao Wang
 * @Description
 * @create 2022-05-19 00:07
 */
public class User {
	private int id;
	private String username;
	private String password;
	private String gender;
	private String addr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", gender='" + gender + '\'' +
				", addr='" + addr + '\'' +
				'}';
	}
}
