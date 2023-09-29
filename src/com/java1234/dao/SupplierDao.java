package com.java1234.dao;

/**
 * 供應商Dao類
 * @author Jack
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.Supplier;
import com.java1234.util.DbUtil;

public class SupplierDao {
		
	private DbUtil dbUtil = new DbUtil();
	
	// 加入
	public int supplierAdd(Connection con, Supplier supplier) throws Exception {
		String sql = "insert into supplier values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, supplier.getSupplier_name());
		pstmt.setString(2, supplier.getSupplier_phone());
		pstmt.setString(3, supplier.getSupplier_email());
		pstmt.setString(4, supplier.getSupplier_address());
		pstmt.setString(5, supplier.getResponsible_person());
	
		return pstmt.executeUpdate();
	}
		
	// 查詢全部供應商
	public ArrayList<Supplier> queryAllSupplier(Connection con) {
		ArrayList<Supplier> array = new ArrayList<Supplier>();
		String queryAllSql = "select * from supplier";
		try {
		con = dbUtil.getCon();
		PreparedStatement pstmt = con.prepareStatement(queryAllSql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Supplier supplier = new Supplier();
			supplier.setSupplier_id(rs.getString("supplier_id"));
			supplier.setSupplier_name(rs.getString("supplier_name"));
			supplier.setSupplier_phone(rs.getString("supplier_phone"));
			supplier.setSupplier_email(rs.getString("supplier_email"));
			supplier.setSupplier_address(rs.getString("supplier_address"));
			supplier.setResponsible_person(rs.getString("responsible_person"));
			array.add(supplier);
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
	
	// 查詢部分供應商
	public ArrayList<Supplier> querySomeSupplier(Supplier supplier, Connection con) {
		ArrayList<Supplier> arraySupplier = new ArrayList<Supplier>();
		String querySomeSql = "select * from supplier where supplier_id like '%" + supplier.getSupplier_id() + "%' and supplier_name like '%" + supplier.getSupplier_name() + "%' ";
		//		System.out.println(querySomeSql); // 測試sql語法
		try {
			con = dbUtil.getCon();
			PreparedStatement pstmt = con.prepareStatement(querySomeSql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Supplier querySupplier = new Supplier();
				querySupplier.setSupplier_id(rs.getString("supplier_id"));
				querySupplier.setSupplier_name(rs.getString("supplier_name"));
				querySupplier.setSupplier_phone(rs.getString("supplier_phone"));
				querySupplier.setSupplier_email(rs.getString("supplier_email"));
				querySupplier.setSupplier_address(rs.getString("supplier_address"));
				querySupplier.setResponsible_person(rs.getString("responsible_person"));
				arraySupplier.add(querySupplier);
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
		return arraySupplier;
	}
	
	// 刪除
	public String deleteSupplier(String id, Connection con) {
		String resultStr = "刪除失敗";
		String deleteSql = "delete from supplier where supplier_id = ?";
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
	public int update(Connection con, Supplier supplier) throws Exception {
		String updateSql = "update supplier set supplier_name=?, supplier_phone=?, supplier_email=?, supplier_address=?, responsible_person=? where supplier_id=?";
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, supplier.getSupplier_name());
		pstmt.setString(2, supplier.getSupplier_phone());
		pstmt.setString(3, supplier.getSupplier_email());
		pstmt.setString(4, supplier.getSupplier_address());
		pstmt.setString(5, supplier.getResponsible_person());
		pstmt.setString(6, supplier.getSupplier_id());
		return pstmt.executeUpdate();
	}
}
