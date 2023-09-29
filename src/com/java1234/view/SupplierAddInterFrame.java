package com.java1234.view;

/**
 * 供應商資料新增介面
 * @author Jack
 *
 */

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.SupplierDao;
import com.java1234.model.Supplier;
import com.java1234.util.DbUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class SupplierAddInterFrame extends JInternalFrame {
	private JTextField supplierNameTxt;
	private JTextField supplierPhoneTxt;
	private JTextField supplierEmailTxt;
	private JTextField supplierAddressTxt;
	private JTextField supplierResponsiblePersonTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private SupplierDao supplierDao = new SupplierDao();
	private SupplierManageInterFrame smif = new SupplierManageInterFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierAddInterFrame frame = new SupplierAddInterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SupplierAddInterFrame() {
		setTitle("加入供應商資料");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 382, 459);
		
		JLabel lblNewLabel = new JLabel("水果供應商名稱:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("電話:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("住址:");
		lblNewLabel_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4 = new JLabel("負責人姓名:");
		lblNewLabel_4.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		supplierNameTxt = new JTextField();
		supplierNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		supplierNameTxt.setColumns(10);
		
		supplierPhoneTxt = new JTextField();
		supplierPhoneTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		supplierPhoneTxt.setColumns(10);
		
		supplierEmailTxt = new JTextField();
		supplierEmailTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		supplierEmailTxt.setColumns(10);
		
		supplierAddressTxt = new JTextField();
		supplierAddressTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		supplierAddressTxt.setColumns(10);
		
		supplierResponsiblePersonTxt = new JTextField();
		supplierResponsiblePersonTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		supplierResponsiblePersonTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("加入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplierAddButton(e);
			}
		});
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(supplierNameTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(supplierResponsiblePersonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(9))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(supplierAddressTxt))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(supplierEmailTxt))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(supplierPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(138)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(supplierNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierAddressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierResponsiblePersonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void supplierAddButton(ActionEvent evt) {
		// TODO Auto-generated method stub
		String supplierName = this.supplierNameTxt.getText();
		String supplierPhone = this.supplierPhoneTxt.getText();
		String supplierEmail = this.supplierEmailTxt.getText();
		String supplierAddress = this.supplierAddressTxt.getText();
		String supplierResponsiblePerson = this.supplierResponsiblePersonTxt.getText();
		
		Supplier supplier = new Supplier(supplierName, supplierPhone, supplierEmail, supplierAddress, supplierResponsiblePerson);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = supplierDao.supplierAdd(con, supplier);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "供應商資料加入成功");
				resetValue();
				smif.querySupplier();
			}
			else {
				JOptionPane.showMessageDialog(null, "供應商資料加入失敗");
				
			}
			
		} catch(Exception se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(null, "供應商資料加入失敗");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 重製表格
	private void resetValue() {
		this.supplierNameTxt.setText("");
		this.supplierPhoneTxt.setText("");
		this.supplierEmailTxt.setText("");
		this.supplierAddressTxt.setText("");
		this.supplierResponsiblePersonTxt.setText("");
	}
}
