package com.java1234.dao;

/**
 * 水果交易Dao類
 * @author Jack
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.Trade;
import com.java1234.util.DbUtil;

public class TradeDao {
	
	private DbUtil dbUtil = new DbUtil();
	
	// 加入
	public int tradeAdd(Connection con, Trade trade) throws Exception {
		String sql = "insert into trade values('" + trade.getTrade_fruit_id() + "', '" + trade.getTrade_member_id() + "',?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, trade.getTrade_fruit_name());
		pstmt.setString(2, trade.getTrade_fruit_supplier_name());
		pstmt.setInt(3, trade.getPurchase_quantity());
		pstmt.setFloat(4, trade.getSell_price());
		pstmt.setFloat(5, trade.getTotal_price());
		pstmt.setFloat(6, trade.getDiscount_price());
		pstmt.setString(7, trade.getTransaction_date());
		pstmt.setString(8, trade.getEstimated_delivery_date());
		pstmt.setString(9, trade.getActual_delivery_date());
		
		return pstmt.executeUpdate();
	}
	
	// 查詢全部水果交易
	public ArrayList<Trade> queryAllTrade(Connection con) {
		ArrayList<Trade> array = new ArrayList<Trade>();
		String queryAllSql = "select * from trade";
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(queryAllSql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Trade trade = new Trade();
				trade.setTrade_fruit_id(rs.getString("trade_fruit_id"));
				trade.setTrade_member_id(rs.getString("trade_member_id"));
				trade.setTrade_fruit_name(rs.getString("trade_fruit_name"));
				trade.setTrade_fruit_supplier_name(rs.getString("trade_fruit_supplier_name"));
				trade.setPurchase_quantity(rs.getInt("purchase_quantity"));
				trade.setSell_price(rs.getFloat("sell_price"));
				trade.setTotal_price(rs.getFloat("total_price"));
				trade.setDiscount_price(rs.getFloat("discount_price"));
				trade.setTransaction_date(rs.getString("transaction_date"));
				trade.setEstimated_delivery_date(rs.getString("estimated_delivery_date"));
				trade.setActual_delivery_date(rs.getString("actual_delivery_date"));
				array.add(trade);
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
	
	// 查詢部分水果交易
	public ArrayList<Trade> querySomeTrade(Trade trade, Connection con) {
		ArrayList<Trade> arrayTrade = new ArrayList<Trade>();
		String querySomeSql = "select * from trade where trade_fruit_id like '%" + trade.getTrade_fruit_id() + "%' and trade_member_id like '%" + trade.getTrade_member_id() + "%' ";
		//		System.out.println(querySomeSql); // 測試sql語法
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(querySomeSql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Trade queryTrade = new Trade();
				queryTrade.setTrade_fruit_id(rs.getString("trade_fruit_id"));
				queryTrade.setTrade_member_id(rs.getString("trade_member_id"));
				queryTrade.setTrade_fruit_name(rs.getString("trade_fruit_name"));
				queryTrade.setTrade_fruit_supplier_name(rs.getString("trade_fruit_supplier_name"));
				queryTrade.setPurchase_quantity(rs.getInt("purchase_quantity"));
				queryTrade.setSell_price(rs.getFloat("sell_price"));
				queryTrade.setTotal_price(rs.getFloat("total_price"));
				queryTrade.setDiscount_price(rs.getFloat("discount_price"));
				queryTrade.setTransaction_date(rs.getString("transaction_date"));
				queryTrade.setEstimated_delivery_date(rs.getString("estimated_delivery_date"));
				queryTrade.setActual_delivery_date(rs.getString("actual_delivery_date"));
				arrayTrade.add(queryTrade);
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
		return arrayTrade;
	}
	
	// 刪除
	public String deleteTrade(String id, Connection con) {
		String resultStr = "刪除失敗";
		String deleteSql = "delete from trade where trade_fruit_id = ?";
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
	public int update(Connection con, Trade trade) throws Exception {
		String updateSql = "update trade set purchase_quantity=?, sell_price=?, discount_price=? where trade_fruit_id=? and trade_member_id=? ";
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setInt(1, trade.getPurchase_quantity());
		pstmt.setFloat(2, trade.getSell_price());
		pstmt.setFloat(3, trade.getDiscount_price());
		pstmt.setString(4, trade.getTrade_fruit_id());
		pstmt.setString(5, trade.getTrade_member_id());
		return pstmt.executeUpdate();
	}
}
