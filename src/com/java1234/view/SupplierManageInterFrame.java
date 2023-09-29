package com.java1234.view;

/**
 * 供應商管理介面
 * 
 * @author Jack
 *
 */

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.SupplierDao;
import com.java1234.model.Supplier;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SupplierManageInterFrame extends JInternalFrame {
	private JTextField s_supplierIdTxt;
	private JTextField s_supplierNameTxt;
	private JTable supplierTable;
	private JTextField supplierIdTxt;
	private JTextField supplierNameTxt;
	private JTextField supplierPhoneTxt;
	private JTextField supplierEmailTxt;
	private JTextField supplierAddressTxt;
	private JTextField supplierResponsiblePersonTxt;
	
	private DefaultTableModel dtm = null;
	private DbUtil dbUtil = new DbUtil();
	private SupplierDao supplierDao = new SupplierDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierManageInterFrame frame = new SupplierManageInterFrame();
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
	public SupplierManageInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("供應商管理");
		setBounds(100, 100, 1126, 581);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u55AE\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(467)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("供應商統一編號:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("水果供應商名稱:");
		lblNewLabel_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("電話:");
		lblNewLabel_2_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("住址:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("負責人姓名:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		supplierIdTxt = new JTextField();
		supplierIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		supplierIdTxt.setColumns(10);
		
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
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierIdTxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierNameTxt, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierPhoneTxt, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(39))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierAddressTxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1_1_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(supplierResponsiblePersonTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGap(136))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(470)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(520, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(supplierIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(supplierNameTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierPhoneTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierEmailTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierAddressTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplierResponsiblePersonTxt, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		supplierTable = new JTable();
		supplierTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				supplierTableMousePressed(e);
			}
		});
		supplierTable.setFont(new Font("標楷體", Font.PLAIN, 14));
		supplierTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4F9B\u61C9\u5546\u7D71\u4E00\u7DE8\u865F", "\u6C34\u679C\u4F9B\u61C9\u5546\u540D\u7A31", "\u96FB\u8A71", "Email", "\u4F4F\u5740", "\u8CA0\u8CAC\u4EBA\u59D3\u540D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		supplierTable.getColumnModel().getColumn(0).setPreferredWidth(98);
		supplierTable.getColumnModel().getColumn(1).setPreferredWidth(98);
		supplierTable.getColumnModel().getColumn(3).setPreferredWidth(94);
		supplierTable.getColumnModel().getColumn(4).setPreferredWidth(101);
		supplierTable.getColumnModel().getColumn(5).setPreferredWidth(72);
		scrollPane.setViewportView(supplierTable);
		
		JLabel lblNewLabel = new JLabel("供應商統一編號:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("水果供應商名稱:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		s_supplierIdTxt = new JTextField();
		s_supplierIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		s_supplierIdTxt.setColumns(10);
		
		s_supplierNameTxt = new JTextField();
		s_supplierNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		s_supplierNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querryButton(e);
			}
		});
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(196)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_supplierIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_supplierNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_supplierIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_supplierNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		dtm = (DefaultTableModel) this.supplierTable.getModel();
		querySupplier();
	}

	private void supplierTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.supplierTable.getSelectedRow();
		this.supplierIdTxt.setText(supplierTable.getValueAt(row, 0) + "");
		this.supplierNameTxt.setText((String)supplierTable.getValueAt(row, 1) + "");
		this.supplierPhoneTxt.setText((String)supplierTable.getValueAt(row, 2) + "");
		this.supplierEmailTxt.setText((String)supplierTable.getValueAt(row, 3) + "");
		this.supplierAddressTxt.setText((String)supplierTable.getValueAt(row, 4) + "");
		this.supplierResponsiblePersonTxt.setText((String)supplierTable.getValueAt(row, 5) + "");		
	}

	// 供應商修改事件處理
	private void updateButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String supplierId = this.supplierIdTxt.getText();
		if(StringUtil.isEmpty(supplierId)) {
			JOptionPane.showMessageDialog(null, "選擇要修改的紀錄");
			return;
		}
		
		String supplierName = this.supplierNameTxt.getText();
		String supplierPhone = this.supplierPhoneTxt.getText();
		String supplierEmail = this.supplierEmailTxt.getText();
		String supplierAddress = this.supplierAddressTxt.getText();
		String ResponsiblePerson =  this.supplierResponsiblePersonTxt.getText();
		
		Supplier supplier = new Supplier(supplierId, supplierName, supplierPhone, supplierEmail, supplierAddress, ResponsiblePerson);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = supplierDao.update(con, supplier);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "供應商資料修改成功");
				this.resetValue();
				querySupplier();
			}
			else {
				JOptionPane.showMessageDialog(null, "供應商資料修改失敗");
				
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
	}
	
	// 供應商刪除事件處理
	private void deleteButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String id = dtm.getValueAt(supplierTable.getSelectedRow(), 0).toString();
		JOptionPane.showMessageDialog(this, new SupplierDao().deleteSupplier(id, null));
		querySupplier();
	}
	
	// 供應商查詢事件處理
	private void querryButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		Supplier supplier = new Supplier();
		supplier.setSupplier_id(s_supplierIdTxt.getText());
		supplier.setSupplier_name(s_supplierNameTxt.getText());
		
		
		ArrayList<Supplier> arraySupplier = new SupplierDao().querySomeSupplier(supplier, null);
		dtm.setRowCount(0);
		
		for(Supplier s : arraySupplier) {
			Vector v = new Vector();
			v.add(s.getSupplier_id());
			v.add(s.getSupplier_name());
			v.add(s.getSupplier_phone());
			v.add(s.getSupplier_email());
			v.add(s.getSupplier_address());
			v.add(s.getResponsible_person());
			dtm.addRow(v);
		}
	}
	
	public void querySupplier() {
		dtm.setRowCount(0);
		List<Supplier> supplierList = new SupplierDao().queryAllSupplier(null);
		
		for(Supplier s : supplierList) {
			Vector v = new Vector();
			v.add(s.getSupplier_id());
			v.add(s.getSupplier_name());
			v.add(s.getSupplier_phone());
			v.add(s.getSupplier_email());
			v.add(s.getSupplier_address());
			v.add(s.getResponsible_person());
			dtm.addRow(v);
		}
	}
	
	// 重製表格
	private void resetValue() {
		this.supplierIdTxt.setText("");
		this.supplierNameTxt.setText("");
		this.supplierPhoneTxt.setText("");
		this.supplierEmailTxt.setText("");
		this.supplierAddressTxt.setText("");
		this.supplierResponsiblePersonTxt.setText("");
	}
}
