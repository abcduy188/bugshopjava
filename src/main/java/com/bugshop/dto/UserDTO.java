package com.bugshop.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO extends AbstractDTO<UserDTO>{

	private String email;
	private String password;
	private String name;
	private String roleString;
	private List<String> rolelist = new ArrayList<>();
	
	public List<String> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<String> rolelist) {
		this.rolelist = rolelist;
	}
	public String getRoleString() {
		return roleString;
	}
	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}
	private Set<String> roles = new HashSet<>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
