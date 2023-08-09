package semi.jh.member.model.dto;

import java.util.List;

import semi.jh.food.model.dto.ProcessecFoodDto;

public class member {
//	MEMBER_NUM NOT NULL NUMBER       
//	ID         NOT NULL VARCHAR2(25) 
//	PWD        NOT NULL VARCHAR2(25) 
//	NAME       NOT NULL VARCHAR2(30) 
//	BRITHDAY   NOT NULL NUMBER       
//	EMAIL               VARCHAR2(40) 
//	PHONE      NOT NULL NUMBER       
//	GENDER     NOT NULL NUMBER       
//	REG_DATE   NOT NULL DATE         
//	DEL_DATE            DATE     
	private Integer memberNum;
	private String id;
	private String pwd;
	private String name;
	private Integer brithday;
	private String email;
	private Integer phone;
	private Integer gender;
	private String regDate;
	private String delDate;
	private List<ProcessecFoodDto> pFList;
	
	public member() {
	}
	
	public member(Integer memberNum, String id, String pwd, String name, Integer brithday, String email, Integer phone,
			Integer gender, String regDate, String delDate, List<ProcessecFoodDto> pFList) {
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
		this.delDate = delDate;
		this.pFList = pFList;
	}
	@Override
	public String toString() {
		return "member [memberNum=" + memberNum + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", brithday="
				+ brithday + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", regDate=" + regDate
				+ ", delDate=" + delDate + ", pFList=" + pFList + "]";
	}
	public Integer getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Integer memberNum) {
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
	public Integer getBrithday() {
		return brithday;
	}
	public void setBrithday(Integer brithday) {
		this.brithday = brithday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDelDate() {
		return delDate;
	}
	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}
	public List<ProcessecFoodDto> getpFList() {
		return pFList;
	}
	public void setpFList(List<ProcessecFoodDto> pFList) {
		this.pFList = pFList;
	}
	
	
}
