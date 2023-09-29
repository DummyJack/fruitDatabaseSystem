package com.java1234.view;

/**
 * 水果交易管理介面
 * 
 * @author Jack
 *
 */

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.TradeDao;
import com.java1234.model.Trade;
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

public class TradeManageInterFrame extends JInternalFrame {
	private JTextField s_tradeFruitIdTxt;
	private JTextField s_tradeMemberIdTxt;
	private JTable tradeTable;
	private JTextField tradeFruitIdTxt;
	private JTextField tradeMemberIdTxt;
	private JTextField tradePurchaseQuantityTxt;
	private JTextField tradeSellPriceTxt;
	private JTextField tradeDiscountPriceTxt;
	
	private DefaultTableModel dtm = null;
	private DbUtil dbUtil = new DbUtil();
	private TradeDao tradeDao = new TradeDao();
	
	private FruitManageInterFrame fmif = new FruitManageInterFrame();
	private MemberManageInterFrame mmif = new MemberManageInterFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradeManageInterFrame frame = new TradeManageInterFrame();
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
	public TradeManageInterFrame() {
		setTitle("水果交易管理");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1173, 626);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u5C0B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u55AE\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(504)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("水果編號:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradeFruitIdTxt = new JTextField();
		tradeFruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeFruitIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員身分證字號:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradeMemberIdTxt = new JTextField();
		tradeMemberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeMemberIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("購買數量:");
		lblNewLabel_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("出售單價:");
		lblNewLabel_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("折扣後金額:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		tradePurchaseQuantityTxt = new JTextField();
		tradePurchaseQuantityTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradePurchaseQuantityTxt.setColumns(10);
		
		tradeSellPriceTxt = new JTextField();
		tradeSellPriceTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeSellPriceTxt.setColumns(10);
		
		tradeDiscountPriceTxt = new JTextField();
		tradeDiscountPriceTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		tradeDiscountPriceTxt.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButton(e);
			}
		});
		btnNewButton_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tradePurchaseQuantityTxt, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tradeSellPriceTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1_1_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tradeDiscountPriceTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradePurchaseQuantityTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeSellPriceTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tradeDiscountPriceTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel_1.setLayout(gl_panel_1);
		
		tradeTable = new JTable();
		tradeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tradeTableMousePressed(e);
			}
		});
		tradeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6C34\u679C\u7DE8\u865F", "\u6703\u54E1\u8EAB\u5206\u8B49\u5B57\u865F", "\u6C34\u679C\u540D\u7A31", "\u6C34\u679C\u4F9B\u61C9\u5546\u540D\u7A31", "\u8CFC\u8CB7\u6578\u91CF", "\u51FA\u552E\u55AE\u50F9", "\u7E3D\u91D1\u984D", "\u6298\u6263\u5F8C\u91D1\u984D", "\u4EA4\u6613\u65E5\u671F", "\u9810\u8A08\u4EA4\u904B\u65E5\u671F", "\u5BE6\u969B\u4EA4\u904B\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tradeTable.getColumnModel().getColumn(1).setPreferredWidth(102);
		tradeTable.getColumnModel().getColumn(3).setPreferredWidth(101);
		tradeTable.getColumnModel().getColumn(9).setPreferredWidth(96);
		tradeTable.getColumnModel().getColumn(10).setPreferredWidth(85);
		tradeTable.setFont(new Font("標楷體", Font.PLAIN, 14));
		scrollPane.setViewportView(tradeTable);
		
		JLabel lblNewLabel = new JLabel("水果編號:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("會員身分證字號:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		s_tradeFruitIdTxt = new JTextField();
		s_tradeFruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		s_tradeFruitIdTxt.setColumns(10);
		
		s_tradeMemberIdTxt = new JTextField();
		s_tradeMemberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		s_tradeMemberIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryButton(e);
			}
		});
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(277, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(271))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(s_tradeMemberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_tradeFruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		dtm = (DefaultTableModel) this.tradeTable.getModel();
		queryTrade();
	}
	
	// 表格行點擊事件處理
	private void tradeTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.tradeTable.getSelectedRow();
		this.tradeFruitIdTxt.setText((String) tradeTable.getValueAt(row, 0) + "");
		this.tradeMemberIdTxt.setText((String) tradeTable.getValueAt(row, 1) + "");
		this.tradePurchaseQuantityTxt.setText((Integer) tradeTable.getValueAt(row, 4) + "");
		this.tradeSellPriceTxt.setText((Float) tradeTable.getValueAt(row, 5) + "");
		this.tradeDiscountPriceTxt.setText((Float) tradeTable.getValueAt(row, 7) + "");
	}

	// 水果交易修改事件處理
	private void updateButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String tradeFruitId = this.tradeFruitIdTxt.getText();
		String tradeMemberId = this.tradeMemberIdTxt.getText();
		if (StringUtil.isEmpty(tradeFruitId) && StringUtil.isEmpty(tradeMemberId)) {
			JOptionPane.showMessageDialog(null, "選擇要修改的紀錄");
			return;
		}

		Integer tradePurchaseQuantity = Integer.parseInt(this.tradePurchaseQuantityTxt.getText());
		Float tradeSellPrice = Float.parseFloat(this.tradeSellPriceTxt.getText());
		Float tradeDiscountPrice = Float.parseFloat(this.tradeDiscountPriceTxt.getText());

		Trade trade = new Trade(tradeFruitId, tradeMemberId, tradePurchaseQuantity, tradeSellPrice, tradeDiscountPrice);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = tradeDao.update(con, trade);
			if (n == 1  || n == 2) {
				JOptionPane.showMessageDialog(null, "水果交易資料修改成功");
				this.resetValue();
				queryTrade();
			} else {
				JOptionPane.showMessageDialog(null, "水果交易資料修改失敗");

			}
		} catch (Exception e) {
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

	// 水果交易刪除事件處理
	private void deleteButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String id = dtm.getValueAt(tradeTable.getSelectedRow(), 0).toString();
		JOptionPane.showMessageDialog(this, new TradeDao().deleteTrade(id, null));
		queryTrade();
	}

	// 水果交易查詢事件處理
	private void queryButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		Trade trade = new Trade();
		trade.setTrade_fruit_id(s_tradeFruitIdTxt.getText());
		trade.setTrade_member_id(s_tradeMemberIdTxt.getText());

		ArrayList<Trade> arrayTrade = new TradeDao().querySomeTrade(trade, null);
		dtm.setRowCount(0);

		for (Trade t : arrayTrade) {
			Vector v = new Vector();
			v.add(t.getTrade_fruit_id());
			v.add(t.getTrade_member_id());
			v.add(t.getTrade_fruit_name());
			v.add(t.getTrade_fruit_supplier_name());
			v.add(t.getPurchase_quantity());
			v.add(t.getSell_price());
			v.add(t.getTotal_price());
			v.add(t.getDiscount_price());
			v.add(t.getTransaction_date());
			v.add(t.getEstimated_delivery_date());
			v.add(t.getActual_delivery_date());
			dtm.addRow(v);
		}
	}
	
	public void queryTrade() {
		dtm.setRowCount(0);
		List<Trade> tradeList = new TradeDao().queryAllTrade(null);

		for (Trade t: tradeList) {
			Vector v = new Vector();
			v.add(t.getTrade_fruit_id());
			v.add(t.getTrade_member_id());
			v.add(t.getTrade_fruit_name());
			v.add(t.getTrade_fruit_supplier_name());
			v.add(t.getPurchase_quantity());
			v.add(t.getSell_price());
			v.add(t.getTotal_price());
			v.add(t.getDiscount_price());
			v.add(t.getTransaction_date());
			v.add(t.getEstimated_delivery_date());
			v.add(t.getActual_delivery_date());
			dtm.addRow(v);
		}
	}
	
	// 重製表格
	private void resetValue() {
		this.tradeMemberIdTxt.setText("");
		this.tradeFruitIdTxt.setText("");
		this.tradePurchaseQuantityTxt.setText("");
		this.tradeSellPriceTxt.setText("");
		this.tradeDiscountPriceTxt.setText("");
	}
}
