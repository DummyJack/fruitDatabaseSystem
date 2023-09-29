package com.java1234.model;

/**
 * 供應商實體
 * @author Jack
 *
 */

public class Supplier {
	
	private String supplier_id;
	private String supplier_name;
	private String supplier_phone;
	private String supplier_email;
	private String supplier_address;
	private String responsible_person;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Supplier(String supplier_name, String supplier_phone, String supplier_email, String supplier_address,
			String responsible_person) {
		super();
		this.supplier_name = supplier_name;
		this.supplier_phone = supplier_phone;
		this.supplier_email = supplier_email;
		this.supplier_address = supplier_address;
		this.responsible_person = responsible_person;
	}
	
	public Supplier(String supplier_id, String supplier_name, String supplier_phone, String supplier_email,
			String supplier_address, String responsible_person) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.supplier_phone = supplier_phone;
		this.supplier_email = supplier_email;
		this.supplier_address = supplier_address;
		this.responsible_person = responsible_person;
	}


	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String string) {
		this.supplier_id = string;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_phone() {
		return supplier_phone;
	}
	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
	public String getSupplier_email() {
		return supplier_email;
	}
	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public String getResponsible_person() {
		return responsible_person;
	}
	public void setResponsible_person(String responsible_person) {
		this.responsible_person = responsible_person;
	}
	
}
