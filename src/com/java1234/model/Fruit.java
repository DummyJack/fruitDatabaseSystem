package com.java1234.model;

/**
 * 水果實體
 * @author Jack
 *
 */

public class Fruit {

	private String fruit_id;
	private String fruit_name;
	private String fruit_supplier_name;
	private int quantity;
	private String unit;
	private float prime_cost;
	private float current_price;
	private String location;
	private String date_of_input;
	private String start_promotion_date;
	private String disposal_date;
	
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fruit(String fruit_id, String fruit_name, String fruit_supplier_name, int quantity, String unit, float prime_cost,
			float current_price, String location, String data_of_input, String start_promotion_date,
			String disposal_date) {
		super();
		this.fruit_id = fruit_id;
		this.fruit_name = fruit_name;
		this.fruit_supplier_name = fruit_supplier_name;
		this.quantity = quantity;
		this.unit = unit;
		this.prime_cost = prime_cost;
		this.current_price = current_price;
		this.location = location;
		this.date_of_input = data_of_input;
		this.start_promotion_date = start_promotion_date;
		this.disposal_date = disposal_date;
	}
	
	public Fruit(String fruit_id, String fruit_name, String fruit_supplier_name, int quantity, float prime_cost,
			String location) {
		super();
		this.fruit_id = fruit_id;
		this.fruit_name = fruit_name;
		this.fruit_supplier_name = fruit_supplier_name;
		this.quantity = quantity;
		this.prime_cost = prime_cost;
		this.location = location;
	}

	public String getFruit_id() {
		return fruit_id;
	}
	public void setFruit_id(String fruit_id) {
		this.fruit_id = fruit_id;
	}
	public String getFruit_name() {
		return fruit_name;
	}
	public void setFruit_name(String fruit_name) {
		this.fruit_name = fruit_name;
	}
	public String getFruit_supplier_name() {
		return fruit_supplier_name;
	}
	public void setFruit_supplier_name(String fruit_supplier_name) {
		this.fruit_supplier_name = fruit_supplier_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrime_cost() {
		return prime_cost;
	}
	public void setPrime_cost(float prime_cost) {
		this.prime_cost = prime_cost;
	}
	public float getCurrent_price() {
		current_price = this.prime_cost * this.quantity;
		return current_price;
	}
	public void setCurrent_price(float current_price) {
		this.current_price = current_price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDate_of_input() {
		return date_of_input;
	}
	public void setDate_of_input(String date_of_input) {
		this.date_of_input = date_of_input;
	}
	public String getStart_promotion_date() {
		return start_promotion_date;
	}
	public void setStart_promotion_date(String start_promotion_date) {
		this.start_promotion_date = start_promotion_date;
	}
	public String getDisposal_date() {
		return disposal_date;
	}
	public void setDisposal_date(String disposal_date) {
		this.disposal_date = disposal_date;
	}
	
}
