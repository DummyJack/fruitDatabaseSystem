package com.java1234.view;

/**
 * 水果交易資料新增介面
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
import javax.swing.JTextField;
import javax.swing.JButton;

import com.java1234.dao.TradeDao;
import com.java1234.model.Trade;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TradeAddInterFrame extends JInternalFrame {
	private JTextField tradeFruitIdTxt;
	private JTextField tradeMemberIdTxt;
	private JTextField tradePurchaseQuantityTxt;
	private JTextField tradeSellPriceTxt;
	private JTextField tradeTransactionDateTxt;
	private JTextField tradeEstimatedDeliveryDateTxt;
	private JTextField tradeActualDeliveryDateTxt;
	private JTextField tradeFruitNameTxt;
	private JTextField tradeSupplierNameTxt;
	private JTextField tradeDiscountTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private TradeDao tradeDao = new TradeDao();
	private TradeManageInterFrame tmif = new TradeManageInterFrame();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeAddInterFrame frame = new TradeAddInterFrame();
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
	public TradeAddInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("加入水果交易資料");
		setBounds(100, 100, 602, 631);
		
		JLabel lblNewLabel = new JLabel("水果編號:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("會員身分證字號:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("預計交運日期:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("實際交運日期:");
		lblNewLabel_1_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("購買數量:");
		lblNewLabel_1_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_4 = new JLabel("出售單價:");
		lblNewLabel_1_4.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_7 = new JLabel("交易日期:");
		lblNewLabel_1_7.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradeFruitIdTxt = new JTextField();
		tradeFruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeFruitIdTxt.setColumns(10);
		
		tradeMemberIdTxt = new JTextField();
		tradeMemberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeMemberIdTxt.setColumns(10);
		
		tradePurchaseQuantityTxt = new JTextField();
		tradePurchaseQuantityTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradePurchaseQuantityTxt.setColumns(10);
		
		tradeSellPriceTxt = new JTextField();
		tradeSellPriceTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeSellPriceTxt.setColumns(10);
		
		tradeTransactionDateTxt = new JTextField();
		tradeTransactionDateTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeTransactionDateTxt.setColumns(10);
		
		tradeEstimatedDeliveryDateTxt = new JTextField();
		tradeEstimatedDeliveryDateTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeEstimatedDeliveryDateTxt.setColumns(10);
		
		tradeActualDeliveryDateTxt = new JTextField();
		tradeActualDeliveryDateTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeActualDeliveryDateTxt.setColumns(10);
		
		JDateChooser tradeDate1Txt = new JDateChooser();
		tradeDate1Txt.setDateFormatString("yyyy-MM-dd");
		
		JDateChooser tradeDate2Txt = new JDateChooser();
		tradeDate2Txt.setDateFormatString("yyyy-MM-dd");
		
		JDateChooser tradeDate3Txt = new JDateChooser();
		tradeDate3Txt.setDateFormatString("yyyy-MM-dd");
		
		JButton btnNewButton = new JButton("轉換");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate1 = ((JTextField) tradeDate1Txt.getDateEditor().getUiComponent()).getText();
				tradeTransactionDateTxt.setText(selectdate1);
			}
		});
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 13));
		
		JButton btnNewButton_1 = new JButton("轉換");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate2 = ((JTextField) tradeDate2Txt.getDateEditor().getUiComponent()).getText();
				tradeEstimatedDeliveryDateTxt.setText(selectdate2);
			}
		});
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 13));
		
		JButton btnNewButton_2 = new JButton("轉換");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectdate3 = ((JTextField) tradeDate3Txt.getDateEditor().getUiComponent()).getText();
				tradeActualDeliveryDateTxt.setText(selectdate3);
			}
		});
		btnNewButton_2.setFont(new Font("標楷體", Font.PLAIN, 13));
		
		JButton btnNewButton_3 = new JButton("加入");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradeAddButton(e);
			}
		});
		btnNewButton_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("水果名稱:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("水果供應商名稱:");
		lblNewLabel_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradeFruitNameTxt = new JTextField();
		tradeFruitNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		tradeFruitNameTxt.setColumns(10);
		
		tradeSupplierNameTxt = new JTextField();
		tradeSupplierNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		tradeSupplierNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("折扣後金額:");
		lblNewLabel_2_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradeDiscountTxt = new JTextField();
		tradeDiscountTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeDiscountTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tradePurchaseQuantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_1_5)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(21)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeSupplierNameTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeFruitNameTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeDate2Txt, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeDate3Txt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeDate1Txt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tradeSellPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tradeActualDeliveryDateTxt, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tradeEstimatedDeliveryDateTxt, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_2_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(tradeDiscountTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addComponent(tradeTransactionDateTxt, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))))
							.addGap(2)))
					.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(239))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeFruitNameTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeSupplierNameTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(tradePurchaseQuantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_4)
						.addComponent(tradeSellPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeDiscountTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton)
							.addComponent(tradeTransactionDateTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(tradeDate1Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_7)))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_5)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1)
							.addComponent(btnNewButton_1)
							.addComponent(tradeEstimatedDeliveryDateTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(tradeDate2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2)
							.addComponent(btnNewButton_2)
							.addComponent(tradeActualDeliveryDateTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(tradeDate3Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnNewButton_3)
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void TradeAddButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String tradeFruitId = this.tradeFruitIdTxt.getText();
		String tradeMemberId = this.tradeMemberIdTxt.getText();
		String tradeFruitName =  this.tradeFruitNameTxt.getText();
		String tradeFruitSupplierName =  this.tradeSupplierNameTxt.getText();
		Integer tradePurchaseQuantity = Integer.parseInt(this.tradePurchaseQuantityTxt.getText());
		Float tradeSellPrice = Float.parseFloat(this.tradeSellPriceTxt.getText());
		Float tradeTotalPrice = Integer.parseInt(this.tradePurchaseQuantityTxt.getText()) * Float.parseFloat(this.tradeSellPriceTxt.getText());
		Float tradeDiscountPrice = Float.parseFloat(this.tradeDiscountTxt.getText());
		String tradeTransactionDate = this.tradeTransactionDateTxt.getText();
		String tradeEstimatedDeliveryDate = this.tradeEstimatedDeliveryDateTxt.getText();
		String tradeActualDeliveryDate = this.tradeActualDeliveryDateTxt.getText();
		
		if(StringUtil.isEmpty(tradeFruitName)) {
			JOptionPane.showMessageDialog(null, "水果交易名稱不能為空!");
			return;
		}
		
		if(StringUtil.isEmpty(tradeFruitSupplierName)) {
			JOptionPane.showMessageDialog(null, "水果交易供應商名稱不能為空!");
			return;
		}
		
		Trade trade = new Trade(tradeFruitId, tradeMemberId, tradeFruitName, tradeFruitSupplierName, tradePurchaseQuantity, tradeSellPrice, tradeTotalPrice, tradeDiscountPrice, tradeTransactionDate, tradeEstimatedDeliveryDate, tradeActualDeliveryDate);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = tradeDao.tradeAdd(con, trade);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "水果交易資料加入成功");
				resetValue();
				tmif.queryTrade();
			}
			else {
				JOptionPane.showMessageDialog(null, "水果交易資料加入失敗");
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "水果交易資料加入失敗");
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
		this.tradeFruitIdTxt.setText("");
		this.tradeMemberIdTxt.setText("");
		this.tradeFruitNameTxt.setText("");
		this.tradeSupplierNameTxt.setText("");
		this.tradePurchaseQuantityTxt.setText("");
		this.tradeSellPriceTxt.setText("");
		this.tradeDiscountTxt.setText("");
		this.tradeTransactionDateTxt.setText("");
		this.tradeEstimatedDeliveryDateTxt.setText("");
		this.tradeActualDeliveryDateTxt.setText("");
	}
}
