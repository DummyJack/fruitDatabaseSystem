package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.Fruit;
import com.java1234.util.DbUtil;

/**
 * 水果Dao類
 * @author Jack
 *
 */

public class FruitDao {
	
	private DbUtil dbUtil = new DbUtil();
	
	// 加入
	public int fruitAdd(Connection con, Fruit fruit) throws Exception {
		String sql = "insert into fruit values('" + fruit.getFruit_id() + "',?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, fruit.getFruit_name());
		pstmt.setString(2, fruit.getFruit_supplier_name());
		pstmt.setInt(3, fruit.getQuantity());
		pstmt.setString(4, fruit.getUnit());
		pstmt.setFloat(5, fruit.getPrime_cost());
		pstmt.setFloat(6, fruit.getCurrent_price());
		pstmt.setString(7, fruit.getLocation());
		pstmt.setString(8, fruit.getDate_of_input());
		pstmt.setString(9, fruit.getStart_promotion_date());
		pstmt.setString(10, fruit.getDisposal_date());
		
		return pstmt.executeUpdate();
	}

	// 查詢全部水果
	public ArrayList<Fruit> queryAllFruit(Connection con) {
		ArrayList<Fruit> array = new ArrayList<Fruit>();
		String queryAllSql = "select * from fruit";
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(queryAllSql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Fruit fruit = new Fruit();
				fruit.setFruit_id(rs.getString("fruit_id"));
				fruit.setFruit_name(rs.getString("fruit_name"));
				fruit.setFruit_supplier_name(rs.getString("fruit_supplier_name"));
				fruit.setQuantity(rs.getInt("quantity"));
				fruit.setUnit(rs.getString("unit"));
				fruit.setPrime_cost(rs.getFloat("prime_cost"));
				fruit.setCurrent_price(rs.getFloat("current_price"));
				fruit.setLocation(rs.getString("location"));
				fruit.setDate_of_input(rs.getString("date_of_input"));
				fruit.setStart_promotion_date(rs.getString("start_promotion_date"));
				fruit.setDisposal_date(rs.getString("disposal_date"));
				array.add(fruit);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return array;
	}
	
	// 查詢部分水果
	public ArrayList<Fruit> querySomeFruit(Fruit fruit, Connection con) {
		ArrayList<Fruit> arrayFruit = new ArrayList<Fruit>();
		String querySomeSql = "select * from fruit where fruit_name like '%" + fruit.getFruit_name() + "%' and fruit_id like '%" + fruit.getFruit_id() + "%' ";
		//		System.out.println(querySomeSql); // 測試sql語法
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(querySomeSql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Fruit queryFruit = new Fruit();
				queryFruit.setFruit_id(rs.getString("fruit_id"));
				queryFruit.setFruit_name(rs.getString("fruit_name"));
				queryFruit.setFruit_supplier_name(rs.getString("fruit_supplier_name"));
				queryFruit.setQuantity(rs.getInt("quantity"));
				queryFruit.setUnit(rs.getString("unit"));
				queryFruit.setPrime_cost(rs.getFloat("prime_cost"));
				queryFruit.setCurrent_price(rs.getFloat("current_price"));
				queryFruit.setLocation(rs.getString("location"));
				queryFruit.setDate_of_input(rs.getString("date_of_input"));
				queryFruit.setStart_promotion_date(rs.getString("start_promotion_date"));
				queryFruit.setDisposal_date(rs.getString("disposal_date"));
				arrayFruit.add(queryFruit);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return arrayFruit;
	}
	
	// 刪除
	public String deleteFruit(String id, Connection con) {
		String resultStr = "刪除失敗";
		String deleteSql = "delete from fruit where fruit_id = ?";
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(deleteSql);
			pstmt.setString(1, id);
			if(pstmt.executeUpdate() > 0) {
				resultStr = "刪除成功";
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultStr;
		}
	}
	
	// 修改
	public int update(Connection con, Fruit fruit) throws Exception {
		String updateSql = "update fruit set fruit_name=?, fruit_supplier_name=?, quantity=?, prime_cost=?, location=? where fruit_id=?";
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, fruit.getFruit_name());
		pstmt.setString(2, fruit.getFruit_supplier_name());
		pstmt.setInt(3, fruit.getQuantity());
		pstmt.setFloat(4, fruit.getPrime_cost());
		pstmt.setString(5, fruit.getLocation());
		pstmt.setString(6, fruit.getFruit_id());
		return pstmt.executeUpdate();
	}
}






