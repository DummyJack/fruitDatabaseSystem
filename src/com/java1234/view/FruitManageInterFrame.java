package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.FruitDao;
import com.java1234.model.Fruit;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

/**
 * 水果管理介面
 * 
 * @author Jack
 *
 */

public class FruitManageInterFrame extends JInternalFrame {
	private JTable fruitTable;

	private DefaultTableModel dtm = null;
	private DbUtil dbUtil = new DbUtil();
	private FruitDao fruitDao = new FruitDao();

	private JTextField s_fruitNameTxt;
	private JTextField s_fruitIdTxt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField fruitNameTxt;
	private JTextField fruitSupplierNameTxt;
	private JTextField fruitQuantityTxt;
	private JTextField fruitPrimeCostTxt;
	private JTextField fruitLocationTxt;
	private JTextField fruitIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitManageInterFrame frame = new FruitManageInterFrame();
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
	public FruitManageInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("水果管理");
		setBounds(100, 100, 1372, 548);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u8868\u55AE\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u641C\u7D22", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														1330, Short.MAX_VALUE)
												.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														1330, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(588).addComponent(btnNewButton_1,
										GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panel,
										GroupLayout.DEFAULT_SIZE, 1342, Short.MAX_VALUE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE).addGap(20)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnNewButton_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));

		JLabel lblNewLabel_2 = new JLabel("水果名稱:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));

		JLabel lblNewLabel_2_1 = new JLabel("水果供應商名稱:");
		lblNewLabel_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));

		JLabel lblNewLabel_2_1_1 = new JLabel("公司內現有數量:");
		lblNewLabel_2_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));

		JLabel lblNewLabel_2_1_1_1 = new JLabel("進貨單價:");
		lblNewLabel_2_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("公司內存放位置:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));

		fruitNameTxt = new JTextField();
		fruitNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitNameTxt.setColumns(10);

		fruitSupplierNameTxt = new JTextField();
		fruitSupplierNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitSupplierNameTxt.setColumns(10);

		fruitQuantityTxt = new JTextField();
		fruitQuantityTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitQuantityTxt.setColumns(10);

		fruitPrimeCostTxt = new JTextField();
		fruitPrimeCostTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitPrimeCostTxt.setColumns(10);

		fruitLocationTxt = new JTextField();
		fruitLocationTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitLocationTxt.setColumns(10);

		JButton btnNewButton_1_2 = new JButton("修改");
		btnNewButton_1_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButton(e);
			}
		});

		JLabel lblNewLabel_2_2 = new JLabel("水果編號:");
		lblNewLabel_2_2.setFont(new Font("標楷體", Font.PLAIN, 14));

		fruitIdTxt = new JTextField();
		fruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		fruitIdTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(4).addComponent(lblNewLabel_2_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fruitNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fruitSupplierNameTxt, GroupLayout.PREFERRED_SIZE, 147,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 111,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fruitQuantityTxt, GroupLayout.PREFERRED_SIZE, 58,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 71,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fruitPrimeCostTxt, GroupLayout.PREFERRED_SIZE, 71,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(lblNewLabel_2_1_1_1_1).addGap(4).addComponent(fruitLocationTxt,
										GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addGap(544).addComponent(btnNewButton_1_2,
								GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(47, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel
						.createSequentialGroup().addGap(
								25)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2_2)
										.addComponent(fruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2)
										.addComponent(fruitNameTxt, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1)
										.addComponent(fruitSupplierNameTxt, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_1)
										.addComponent(fruitQuantityTxt, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_1_1)
										.addComponent(fruitPrimeCostTxt, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_1_1_1_1).addComponent(fruitLocationTxt,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE).addComponent(btnNewButton_1_2)
						.addGap(26)));
		panel.setLayout(gl_panel);

		JButton btnNewButton = new JButton("查詢");
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryButton(e);
			}
		});

		s_fruitIdTxt = new JTextField();
		s_fruitIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		s_fruitIdTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("水果編號:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("水果名稱:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));

		s_fruitNameTxt = new JTextField();
		s_fruitNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		s_fruitNameTxt.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap(371, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(s_fruitIdTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblNewLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(s_fruitNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(49)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGap(437)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(s_fruitIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(lblNewLabel)
								.addComponent(s_fruitNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))
						.addContainerGap(38, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JButton btnNewButton_1_1 = new JButton("修改");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		fruitTable = new JTable();
		fruitTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				fruitTableMousePressed(e);
			}
		});
		fruitTable.setFont(new Font("標楷體", Font.PLAIN, 14));
		fruitTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6C34\u679C\u7DE8\u865F", "\u6C34\u679C\u540D\u7A31",
						"\u6C34\u679C\u4F9B\u61C9\u5546\u540D\u7A31", "\u516C\u53F8\u5167\u73FE\u6709\u6578\u91CF",
						"\u55AE\u4F4D", "\u9032\u8CA8\u55AE\u50F9", "\u73FE\u6709\u50F9\u503C\u5C0F\u8A08",
						"\u516C\u53F8\u5167\u5B58\u653E\u4F4D\u7F6E", "\u9032\u8CA8\u65E5\u671F",
						"\u958B\u59CB\u4FC3\u92B7\u65E5\u671F", "\u8A72\u4E1F\u68C4\u4E4B\u65E5\u671F" }) {
			boolean[] columnEditables = new boolean[] { false, true, false, false, false, false, true, false, true,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		fruitTable.getColumnModel().getColumn(2).setPreferredWidth(96);
		fruitTable.getColumnModel().getColumn(3).setPreferredWidth(106);
		fruitTable.getColumnModel().getColumn(4).setPreferredWidth(36);
		fruitTable.getColumnModel().getColumn(6).setPreferredWidth(94);
		fruitTable.getColumnModel().getColumn(7).setPreferredWidth(100);
		fruitTable.getColumnModel().getColumn(9).setPreferredWidth(92);
		fruitTable.getColumnModel().getColumn(10).setPreferredWidth(90);
		scrollPane.setViewportView(fruitTable);
		getContentPane().setLayout(groupLayout);

		dtm = (DefaultTableModel) this.fruitTable.getModel();
		queryFruit();

	}

	// 修改事件處理
	private void updateButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String fruitId = this.fruitIdTxt.getText();
		if (StringUtil.isEmpty(fruitId)) {
			JOptionPane.showMessageDialog(null, "選擇要修改的紀錄");
			return;
		}

		String fruitName = this.fruitNameTxt.getText();
		String fruitSupplierName = this.fruitSupplierNameTxt.getText();
		Integer fruitQuantity = Integer.parseInt(this.fruitQuantityTxt.getText());
		Float fruitPrimeCost = Float.parseFloat(this.fruitPrimeCostTxt.getText());
		String fruitLocation = this.fruitLocationTxt.getText();

		Fruit fruit = new Fruit(fruitId, fruitName, fruitSupplierName, fruitQuantity, fruitPrimeCost, fruitLocation);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = fruitDao.update(con, fruit);
			if (n == 1) {
				JOptionPane.showMessageDialog(null, "水果資料修改成功");
				this.resetValue();
				queryFruit();
			} else {
				JOptionPane.showMessageDialog(null, "水果資料修改失敗");

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

	// 表格行點擊事件處理
	private void fruitTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.fruitTable.getSelectedRow();
		this.fruitIdTxt.setText((String) fruitTable.getValueAt(row, 0) + "");
		this.fruitNameTxt.setText((String) fruitTable.getValueAt(row, 1) + "");
		this.fruitSupplierNameTxt.setText((String) fruitTable.getValueAt(row, 2) + "");
		this.fruitQuantityTxt.setText((Integer) fruitTable.getValueAt(row, 3) + "");
		this.fruitPrimeCostTxt.setText((Float) fruitTable.getValueAt(row, 5) + "");
		this.fruitLocationTxt.setText((String) fruitTable.getValueAt(row, 7) + "");
	}

	// 水果刪除事件處理
	private void deleteButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String id = dtm.getValueAt(fruitTable.getSelectedRow(), 0).toString();
		JOptionPane.showMessageDialog(this, new FruitDao().deleteFruit(id, null));
		queryFruit();
	}

	// 水果查詢事件處理
	private void queryButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		Fruit fruit = new Fruit();
		fruit.setFruit_name(s_fruitNameTxt.getText());
		fruit.setFruit_id(s_fruitIdTxt.getText());

		ArrayList<Fruit> arrayFruit = new FruitDao().querySomeFruit(fruit, null);
		dtm.setRowCount(0);

		for (Fruit f : arrayFruit) {
			Vector v = new Vector();
			v.add(f.getFruit_id());
			v.add(f.getFruit_name());
			v.add(f.getFruit_supplier_name());
			v.add(f.getQuantity());
			v.add(f.getUnit());
			v.add(f.getPrime_cost());
			v.add(f.getCurrent_price());
			v.add(f.getLocation());
			v.add(f.getDate_of_input());
			v.add(f.getStart_promotion_date());
			v.add(f.getDisposal_date());
			dtm.addRow(v);
		}
	}

	public void queryFruit() {
		dtm.setRowCount(0);
		List<Fruit> fruitList = new FruitDao().queryAllFruit(null);

		for (Fruit f : fruitList) {
			Vector v = new Vector();
			v.add(f.getFruit_id());
			v.add(f.getFruit_name());
			v.add(f.getFruit_supplier_name());
			v.add(f.getQuantity());
			v.add(f.getUnit());
			v.add(f.getPrime_cost());
			v.add(f.getCurrent_price());
			v.add(f.getLocation());
			v.add(f.getDate_of_input());
			v.add(f.getStart_promotion_date());
			v.add(f.getDisposal_date());
			dtm.addRow(v);
		}
	}

	// 重製表格
	private void resetValue() {
		this.fruitIdTxt.setText("");
		this.fruitNameTxt.setText("");
		this.fruitSupplierNameTxt.setText("");
		this.fruitQuantityTxt.setText("");
		this.fruitPrimeCostTxt.setText("");
		this.fruitLocationTxt.setText("");
	}
}
