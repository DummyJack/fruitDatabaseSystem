package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.FruitDao;
import com.java1234.model.Fruit;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;
import com.toedter.calendar.JDateChooser;

/**
 * 水果資料新增介面
 * @author Jack
 *
 */

public class FruitAddInterFrame extends JInternalFrame {
	private JTextField fruitIdTxt;
	private JTextField fruitNameTxt;
	private JTextField fruitSupplierNameTxt;
	private JTextField fruitQuantityTxt;
	private JTextField fruitUnitTxt;
	private JTextField fruitPrimeCostTxt;
	private JTextField fruitLocationTxt;
	private JTextField fruitDateOfInputTxt;
	private JTextField fruitStartPromotionDateTxt;
	private JTextField fruitDisposalTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private FruitDao fruitDao = new FruitDao();
	private FruitManageInterFrame fmif = new FruitManageInterFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitAddInterFrame frame = new FruitAddInterFrame();
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
	public FruitAddInterFrame() {
		getContentPane().setFont(new Font("標楷體", Font.PLAIN, 14));
		setClosable(true);
		setIconifiable(true);
		setTitle("加入水果資料");
		setBounds(100, 100, 543, 655);
		
		JLabel lblNewLabel = new JLabel("水果名稱:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		fruitNameTxt = new JTextField();
		fruitNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("水果供應商名稱:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		fruitSupplierNameTxt = new JTextField();
		fruitSupplierNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitSupplierNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("單位:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		fruitQuantityTxt = new JTextField();
		fruitQuantityTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitQuantityTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("公司內現有數量:");
		lblNewLabel_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("進貨單價:");
		lblNewLabel_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("公司內存放位置:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("進貨日期:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1_2_2 = new JLabel("開始促銷日期:");
		lblNewLabel_1_1_1_1_2_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		fruitUnitTxt = new JTextField();
		fruitUnitTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitUnitTxt.setColumns(10);
		
		fruitPrimeCostTxt = new JTextField();
		fruitPrimeCostTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitPrimeCostTxt.setColumns(10);
		
		fruitLocationTxt = new JTextField();
		fruitLocationTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitLocationTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2_2_1 = new JLabel("該丟棄之日期:");
		lblNewLabel_1_1_1_1_2_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("加入");
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fruitAddActionPerformed(e);
			}
		});
		
		JDateChooser fruitDate1Txt = new JDateChooser();
		
		fruitDate1Txt.setDateFormatString("yyyy-MM-dd");
		
		JDateChooser fruitDate2Txt = new JDateChooser();		
		fruitDate2Txt.setDateFormatString("yyyy-MM-dd");
		
		JDateChooser fruitDate3Txt = new JDateChooser();
		fruitDate3Txt.setDateFormatString("yyyy-MM-dd");
		
		JButton btnNewButton_1 = new JButton("轉換");
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate1 = ((JTextField) fruitDate1Txt.getDateEditor().getUiComponent()).getText();
				fruitDateOfInputTxt.setText(selectdate1);
			}
		});
		
		fruitDateOfInputTxt = new JTextField();
		fruitDateOfInputTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitDateOfInputTxt.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("轉換");
		btnNewButton_1_1.setFont(new Font("標楷體", Font.PLAIN, 13));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate2 = ((JTextField) fruitDate2Txt.getDateEditor().getUiComponent()).getText();
				fruitStartPromotionDateTxt.setText(selectdate2);
			}
		});
		
		fruitStartPromotionDateTxt = new JTextField();
		fruitStartPromotionDateTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitStartPromotionDateTxt.setColumns(10);
		
		JButton btnNewButton_1_1_1 = new JButton("轉換");
		btnNewButton_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 13));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate3 = ((JTextField) fruitDate3Txt.getDateEditor().getUiComponent()).getText();
				fruitDisposalTxt.setText(selectdate3);
			}
		});
		
		fruitDisposalTxt = new JTextField();
		fruitDisposalTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitDisposalTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("水果編號:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		fruitIdTxt = new JTextField();
		fruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitIdTxt.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fruitLocationTxt, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(fruitSupplierNameTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(fruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblNewLabel)
													.addGap(4)
													.addComponent(fruitNameTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(fruitPrimeCostTxt, 0, 0, Short.MAX_VALUE))
													.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(fruitUnitTxt, 0, 0, Short.MAX_VALUE))
															.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(fruitQuantityTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_1_1_1_1_2_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(fruitDate2Txt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btnNewButton_1_1))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_1_1_1_1_2_2_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(fruitDate3Txt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btnNewButton_1_1_1))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(fruitDate1Txt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(btnNewButton_1)))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(fruitDisposalTxt, 0, 0, Short.MAX_VALUE)
												.addComponent(fruitStartPromotionDateTxt, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
												.addComponent(fruitDateOfInputTxt, 0, 0, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(210)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(fruitNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(fruitSupplierNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(fruitQuantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(fruitUnitTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(fruitPrimeCostTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(fruitLocationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1)
							.addComponent(fruitDateOfInputTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(fruitDate1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1_2_2)
						.addComponent(fruitDate2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1)
						.addComponent(fruitStartPromotionDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1_2_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1_1_1)
							.addComponent(fruitDisposalTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(fruitDate3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnNewButton)
					.addGap(20))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	// 水果資料加入事件處理
	private void fruitAddActionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String fruitId = this.fruitIdTxt.getText();
		String fruitName = this.fruitNameTxt.getText();
		String fruitSupplierName = this.fruitSupplierNameTxt.getText();
		Integer fruitQuantity = Integer.parseInt(this.fruitQuantityTxt.getText());
		String fruitUnit = this.fruitUnitTxt.getText();
		Float fruitPrimeCost = Float.parseFloat(this.fruitPrimeCostTxt.getText());
		Float fruitCurrentPrice = Integer.parseInt(this.fruitQuantityTxt.getText()) * Float.parseFloat(this.fruitPrimeCostTxt.getText());
		String fruitLocation =  this.fruitLocationTxt.getText();
		String dateOfInput = this.fruitDateOfInputTxt.getText();
		String startPromotionDate = this.fruitStartPromotionDateTxt.getText();
		String disposal_date = this.fruitDisposalTxt.getText();
		
		if(StringUtil.isEmpty(fruitName)) {
			JOptionPane.showMessageDialog(null, "水果名稱不能為空!");
			return;
		}
		
		if(StringUtil.isEmpty(Integer.toString(fruitQuantity))) {
			JOptionPane.showMessageDialog(null, "公司內現有數量不能為空!");
			return;
		}
		
		if(StringUtil.isEmpty(Float.toString(fruitPrimeCost))) {
			JOptionPane.showMessageDialog(null, "進貨單價不能為空!");
			return;
		}
		
		Fruit fruit = new Fruit(fruitId, fruitName,fruitSupplierName,fruitQuantity,fruitUnit,fruitPrimeCost,fruitCurrentPrice,fruitLocation, dateOfInput, startPromotionDate, disposal_date);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = fruitDao.fruitAdd(con, fruit);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "水果資料加入成功");
				resetValue();
				fmif.queryFruit();
			}
			else {
				JOptionPane.showMessageDialog(null, "水果資料加入失敗");
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "水果資料加入失敗");
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
		this.fruitIdTxt.setText("");
		this.fruitNameTxt.setText("");
		this.fruitSupplierNameTxt.setText("");
		this.fruitQuantityTxt.setText("");
		this.fruitUnitTxt.setText("");
		this.fruitPrimeCostTxt.setText("");
		this.fruitPrimeCostTxt.setText("");
		this.fruitLocationTxt.setText("");
		this.fruitDateOfInputTxt.setText("");
		this.fruitStartPromotionDateTxt.setText("");
		this.fruitDisposalTxt.setText("");
	}
}
