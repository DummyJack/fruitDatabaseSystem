package com.java1234.model;

/**
 * 水果交易實體
 * @author Jack
 *
 */

public class Trade {
	
	private String trade_fruit_id;
	private String trade_member_id;
	private String trade_fruit_name;
	private String trade_fruit_supplier_name;
	private int purchase_quantity;
	private float sell_price;
	private float total_price;
	private float discount_price;
	private String transaction_date;
	private String estimated_delivery_date;
	private String actual_delivery_date;
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Trade(String trade_fruit_id, String trade_member_id, String trade_fruit_name,
			String trade_fruit_supplier_name, int purchase_quantity, float sell_price, float total_price,
			float discount_price, String transaction_date, String estimated_delivery_date,
			String actual_delivery_date) {
		super();
		this.trade_fruit_id = trade_fruit_id;
		this.trade_member_id = trade_member_id;
		this.trade_fruit_name = trade_fruit_name;
		this.trade_fruit_supplier_name = trade_fruit_supplier_name;
		this.purchase_quantity = purchase_quantity;
		this.sell_price = sell_price;
		this.total_price = total_price;
		this.discount_price = discount_price;
		this.transaction_date = transaction_date;
		this.estimated_delivery_date = estimated_delivery_date;
		this.actual_delivery_date = actual_delivery_date;
	}
	
	public Trade(String trade_fruit_id, String trade_member_id, int purchase_quantity, float sell_price,
			float discount_price) {
		super();
		this.trade_fruit_id = trade_fruit_id;
		this.trade_member_id = trade_member_id;
		this.purchase_quantity = purchase_quantity;
		this.sell_price = sell_price;
		this.discount_price = discount_price;
	}

	public String getTrade_fruit_id() {
		return trade_fruit_id;
	}

	public void setTrade_fruit_id(String trade_fruit_id) {
		this.trade_fruit_id = trade_fruit_id;
	}

	public String getTrade_member_id() {
		return trade_member_id;
	}

	public void setTrade_member_id(String trade_member_id) {
		this.trade_member_id = trade_member_id;
	}

	public String getTrade_fruit_name() {
		return trade_fruit_name;
	}

	public void setTrade_fruit_name(String trade_fruit_name) {
		this.trade_fruit_name = trade_fruit_name;
	}

	public String getTrade_fruit_supplier_name() {
		return trade_fruit_supplier_name;
	}

	public void setTrade_fruit_supplier_name(String trade_fruit_supplier_name) {
		this.trade_fruit_supplier_name = trade_fruit_supplier_name;
	}

	public int getPurchase_quantity() {
		return purchase_quantity;
	}

	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}

	public float getSell_price() {
		return sell_price;
	}

	public void setSell_price(float sell_price) {
		this.sell_price = sell_price;
	}

	public float getTotal_price() {
		total_price = this.purchase_quantity * this.sell_price;
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public float getDiscount_price() {
		return discount_price;
	}

	public void setDiscount_price(float discount_price) {
		this.discount_price = discount_price;
	}

	public String getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getEstimated_delivery_date() {
		return estimated_delivery_date;
	}

	public void setEstimated_delivery_date(String estimated_delivery_date) {
		this.estimated_delivery_date = estimated_delivery_date;
	}

	public String getActual_delivery_date() {
		return actual_delivery_date;
	}

	public void setActual_delivery_date(String actual_delivery_date) {
		this.actual_delivery_date = actual_delivery_date;
	}
}
