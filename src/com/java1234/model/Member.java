package com.java1234.model;

/**
 * 會員實體
 * @author Jack
 *
 */

import java.io.InputStream;

public class Member {
	
	private String member_id;
	private String member_name;
	private String phone;
	private String smartphone;
	private String email;
	private String joinLine;
	private String address;
	private int age;
	private InputStream photo;
	private float discount;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String member_id, String member_name, String phone, String smartphone, String email, String joinLine,
			String address, int age, InputStream photo, float discount) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.phone = phone;
		this.smartphone = smartphone;
		this.email = email;
		this.joinLine = joinLine;
		this.address = address;
		this.age = age;
		this.photo = photo;
		this.discount = discount;
	}
	
	public Member(String member_id, String member_name, String phone, String smartphone, String email, String address,
			int age, InputStream photo) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.phone = phone;
		this.smartphone = smartphone;
		this.email = email;
		this.address = address;
		this.age = age;
		this.photo = photo;
	}

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSmartphone() {
		return smartphone;
	}
	public void setSmartphone(String smartphone) {
		this.smartphone = smartphone;
	}
	public String getEmail() {
		return email;
		
	}
	public void setEmail(String email) {	
		this.email = email;
	}
	public String getJoinLine() {
		return joinLine;
	}
	public void setJoinLine(String joinLine) {
		this.joinLine = joinLine;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
}

// Java寫email限制
//String regex = "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
//Pattern p = Pattern.compile(regex);
//try {
//	if(p.matcher(email).find() == true) {
//		return email;
//	}
// } catch(Exception e) {
//	 e.printStackTrace();
// }
//return "";
