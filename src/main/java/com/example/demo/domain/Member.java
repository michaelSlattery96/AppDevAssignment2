package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberId;
	
	@Column(nullable=false, unique = true)
	@Email
	private String memberEmail;
	
	@Column(nullable=false)
	private String memberName;
	
	@Column(nullable=false)
	@Size(min=8)
	private String memberPassword;

	@OneToOne
	@JoinColumn(name = "roleEmail", nullable = false)
	private Role memberRole;
	
	@Column(nullable=false)
	private Boolean memberEnabled;

	public Member(String memberEmail, String memberName, String memberPassword, Role memberRole, boolean memberEnabled) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberRole = memberRole;
		this.memberEnabled = memberEnabled;
	}
	
	public Member() {
		
	}

	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	
	public Role getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(Role memberRole) {
		this.memberRole = memberRole;
	}
	
	public Boolean getMemberEnabled() {
		return memberEnabled;
	}

	public void setMemberEnabled(Boolean memberEnabled) {
		this.memberEnabled = memberEnabled;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberEmail=" + memberEmail + ", memberName=" + memberName + ", memberPassword="
				+ memberPassword + "]";
	}
}
