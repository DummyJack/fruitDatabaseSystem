package com.java1234.dao;

/**
 * 會員Dao類
 * @author Jack
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.Member;
import com.java1234.util.DbUtil;

public class MemberDao {
	
		private DbUtil dbUtil = new DbUtil();
		
		// 加入
		public int add(Connection con, Member member) throws Exception {
			String sql = "insert into member values('" + member.getMember_id() + "',?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_name());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getSmartphone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getJoinLine());
			pstmt.setString(6, member.getAddress());
			pstmt.setInt(7, member.getAge());
			pstmt.setBlob(8, member.getPhoto());
			pstmt.setFloat(9, member.getDiscount());

			return pstmt.executeUpdate();
		}
		
		// 查詢全部會員
		public ArrayList<Member> queryAllMember(Connection con) {
			ArrayList<Member> array = new ArrayList<Member>();
			String queryAllSql = "select * from member";
			try {
				con = dbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement(queryAllSql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Member member = new Member();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setPhone(rs.getString("phone"));
					member.setSmartphone(rs.getString("smartphone"));
					member.setEmail(rs.getString("email"));
					member.setJoinLine(rs.getString("joinLine"));
					member.setAddress(rs.getString("address"));
					member.setAge(rs.getInt("age"));
					member.setPhoto(rs.getBinaryStream("photo"));
					member.setDiscount(rs.getFloat("discount"));
					array.add(member);
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
		
		// 查詢部份會員
		public ArrayList<Member> querySomeMember(Member member, Connection con) {
			ArrayList<Member> arrayMember = new ArrayList<Member>();
			String querySomeSql = "select * from member where member_id like '%" + member.getMember_id() + "%' and member_name like '%" + member.getMember_name() + "%' ";
			//		System.out.println(querySomeSql); // 測試sql語法
			try {
				con = dbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement(querySomeSql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Member queryMember = new Member();
					queryMember.setMember_id(rs.getString("member_id"));
					queryMember.setMember_name(rs.getString("member_name"));
					queryMember.setPhone(rs.getString("phone"));
					queryMember.setSmartphone(rs.getString("smartphone"));
					queryMember.setEmail(rs.getString("email"));
					queryMember.setJoinLine(rs.getString("joinLine"));
					queryMember.setAddress(rs.getString("address"));
					queryMember.setAge(rs.getInt("age"));
					queryMember.setPhoto(rs.getBinaryStream("photo"));
					queryMember.setDiscount(rs.getFloat("discount"));
					arrayMember.add(queryMember);
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
			return arrayMember;
		}
		
		
		// 刪除
		public String deleteMember(String id, Connection con) {
			String resultStr = "刪除失敗";
			String deleteSql = "delete from member where member_id = ?";
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
		public int update(Connection con, Member member) throws Exception {
			String updateSql = "update member set member_name=?, phone=?, smartphone=?, email=?, address=?, age=?, photo=? where member_id=?";
			PreparedStatement pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, member.getMember_name());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getSmartphone());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getAddress());
			pstmt.setInt(6, member.getAge());
			pstmt.setBlob(7, member.getPhoto());
			pstmt.setString(8, member.getMember_id());
			return pstmt.executeUpdate();
		}
}
