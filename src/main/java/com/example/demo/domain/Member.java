package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberId;
	
	@Column(nullable=false)
	private String memberEmail;
	
	@Column(nullable=false)
	private String memberName;
	
	@Column(nullable=false)
	private String memberPassword;

	public Member(String memberEmail, String memberName, String memberPassword) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
	}
	
	public Member() {
		
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberEmail=" + memberEmail + ", memberName=" + memberName + ", memberPassword="
				+ memberPassword + "]";
	}
}
