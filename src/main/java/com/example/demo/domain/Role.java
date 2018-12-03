package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	private String type;

	@Column(nullable=false)
	private String memberEmail;

	public Role(String memberEmail, String type) {
		super();
		this.memberEmail = memberEmail;
		this.type = type;
	}
	
	public Role() {
		
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Role [type=" + type + ", memberEmail=" + memberEmail + "]";
	}
}
