package semi.jh.member.model.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import semi.jh.food.model.dto.ProcessecFoodDto;

public class MemberDto {
//	MEMBER_NUM NOT NULL NUMBER       
//	ID         NOT NULL VARCHAR2(25) 
//	PWD        NOT NULL VARCHAR2(25) 
//	NAME       NOT NULL VARCHAR2(30) 
//	BRITHDAY   NOT NULL NUMBER       
//	EMAIL               VARCHAR2(40) 
//	PHONE      NOT NULL NUMBER       
//	GENDER     NOT NULL NUMBER       
//	REG_DATE   NOT NULL DATE         
	private int memberNum;
	private String id;
	private String pwd;
	private String name;
	private String brithday;
	private String email;
	private String phone;
	private int gender;
	private LocalDateTime regDate;
	
	public MemberDto() {
	}
	
	
	
	public MemberDto(String id, String pwd, String name, String brithday, String email, String phone, int gender,
			LocalDateTime regDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.brithday = brithday;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.regDate = regDate;
	}



	public MemberDto(int memberNum, String id, String pwd, String name, String brithday, String email, String phone,
			int gender, LocalDateTime regDate) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.brithday = brithday;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "member [memberNum=" + memberNum + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", brithday="
				+ brithday + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", regDate=" + regDate
				+ "]";
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
}
