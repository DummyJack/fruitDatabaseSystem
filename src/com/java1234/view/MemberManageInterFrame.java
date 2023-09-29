package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.MemberDao;
import com.java1234.model.Member;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 會員管理介面
 * @author Jack
 *
 */

public class MemberManageInterFrame extends JInternalFrame {
	private JTable memberTable;
	
	private JTextField s_memberIdTxt;
	private JTextField s_memberNameTxt;
	
	private DefaultTableModel dtm = null;
	private MemberDao memberDao = new MemberDao();
	private DbUtil dbUtil = new DbUtil();
	
	private JTextField memberIdTxt;
	private JTextField memberNameTxt;
	private JTextField memberPhoneTxt;
	private JTextField memberSmartPhoneTxt;
	private JTextField memberEmailTxt;
	private JTextField memberAddressTxt;
	private JTextField memberAgeTxt;
	private JLabel lbl_Image;
	private JLabel query_img;
	
	private String img_path = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManageInterFrame frame = new MemberManageInterFrame();
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
	public MemberManageInterFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("會員管理");
		setBounds(100, 100, 1327, 592);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u5C0B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton(e);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u55AE\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_4 = new JLabel("照片:");
		lblNewLabel_4.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		query_img = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(475)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1307, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 997, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_4)
									.addGap(18)
									.addComponent(query_img, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGap(36))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(51)
								.addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(query_img, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateButton(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_2_1 = new JLabel("會員身分證字號:");
		lblNewLabel_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2 = new JLabel("會員姓名:");
		lblNewLabel_2_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2_1 = new JLabel("電話:");
		lblNewLabel_2_2_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("手機號碼:");
		lblNewLabel_2_2_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_2_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		memberIdTxt = new JTextField();
		memberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberIdTxt.setColumns(10);
		
		memberNameTxt = new JTextField();
		memberNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		memberNameTxt.setColumns(10);
		
		memberPhoneTxt = new JTextField();
		memberPhoneTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberPhoneTxt.setColumns(10);
		
		memberSmartPhoneTxt = new JTextField();
		memberSmartPhoneTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberSmartPhoneTxt.setColumns(10);
		
		memberEmailTxt = new JTextField();
		memberEmailTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberEmailTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("住址:");
		lblNewLabel_2_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		memberAddressTxt = new JTextField();
		memberAddressTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		memberAddressTxt.setColumns(10);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("年齡:");
		lblNewLabel_2_1_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		memberAgeTxt = new JTextField();
		memberAgeTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberAgeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("照片:");
		lblNewLabel_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("選擇檔案");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser filechooser = new JFileChooser();
				filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "gif");
				int result = filechooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = filechooser.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lbl_Image.setIcon(ResizeImage(path, null));
					img_path = path;
				}
				else if(result == JFileChooser.CANCEL_OPTION) {
					System.out.println("No File Select");
				}
			}
		});
		btnNewButton_2.setFont(new Font("標楷體", Font.PLAIN, 13));
		
		lbl_Image = new JLabel("");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberIdTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_2_1))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_1_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberAgeTxt, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lbl_Image, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberPhoneTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_2_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberSmartPhoneTxt, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_2_1_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberAddressTxt, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(60)
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))))
					.addGap(93))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(memberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2)
						.addComponent(memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_1)
						.addComponent(memberPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_1_1)
						.addComponent(memberSmartPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_2_1_1_1)
						.addComponent(memberEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(memberAddressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(48)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(memberAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(btnNewButton_2))
							.addGap(61))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lbl_Image, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_1_1)
							.addGap(28))))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("會員身分證字號:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		s_memberIdTxt = new JTextField();
		s_memberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		s_memberIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("會員姓名:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		s_memberNameTxt = new JTextField();
		s_memberNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		s_memberNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryButton(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(302, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_memberIdTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(97)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(136))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_memberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		memberTable = new JTable();
		memberTable.setFont(new Font("標楷體", Font.PLAIN, 14));
		memberTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				memberTableMousePressed(e);
			}
		});
		memberTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6703\u54E1\u8EAB\u5206\u8B49\u5B57\u865F", "\u6703\u54E1\u59D3\u540D", "\u96FB\u8A71", "\u624B\u6A5F\u865F\u78BC", "Email", "\u662F\u5426\u52A0\u5165\u6771\u6D77\u6C34\u679C\u516C\u53F8\u4E4BLine", "\u4F4F\u5740", "\u5E74\u9F61", "\u7167\u7247", "\u6703\u54E1\u6298\u6263"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, true, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		memberTable.getColumnModel().getColumn(0).setPreferredWidth(101);
		memberTable.getColumnModel().getColumn(2).setPreferredWidth(67);
		memberTable.getColumnModel().getColumn(4).setPreferredWidth(99);
		memberTable.getColumnModel().getColumn(5).setPreferredWidth(167);
		memberTable.getColumnModel().getColumn(6).setPreferredWidth(97);
		memberTable.getColumnModel().getColumn(7).setPreferredWidth(43);
		memberTable.getColumnModel().getColumn(9).setPreferredWidth(76);
		scrollPane.setViewportView(memberTable);
		getContentPane().setLayout(groupLayout);

		dtm = (DefaultTableModel) this.memberTable.getModel();
		queryMember();
	}
	
	// 表格行點擊事件處理
	private void memberTableMousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = this.memberTable.getSelectedRow();
		this.memberIdTxt.setText((String)memberTable.getValueAt(row, 0) + "");
		this.memberNameTxt.setText((String)memberTable.getValueAt(row, 1) + "");
		this.memberPhoneTxt.setText((String)memberTable.getValueAt(row, 2) + "");
		this.memberSmartPhoneTxt.setText((String)memberTable.getValueAt(row, 3) + "");
		this.memberEmailTxt.setText((String)memberTable.getValueAt(row, 4) + "");
		this.memberAddressTxt.setText((String)memberTable.getValueAt(row, 6) + "");
		this.memberAgeTxt.setText((Integer)memberTable.getValueAt(row, 7) + "");
		this.query_img.setIcon((ImageIcon)memberTable.getValueAt(row, 8));
		this.lbl_Image.setIcon((ImageIcon)memberTable.getValueAt(row, 8));
	}

	// 會員修改事件
	private void updateButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String memberId = this.memberIdTxt.getText();
		if(StringUtil.isEmpty(memberId)) {
			JOptionPane.showMessageDialog(null, "選擇要修改的紀錄");
			return;
		}
		
		String memberName = this.memberNameTxt.getText();
		String memberPhone = this.memberPhoneTxt.getText();
		String memberSmartPhone = this.memberSmartPhoneTxt.getText();
		String memberEmail = this.memberEmailTxt.getText();
		String memberAddress = this.memberAddressTxt.getText();
		Integer memberAge = Integer.parseInt(this.memberAgeTxt.getText());
		
		
		InputStream img = null;
		try {
			img = new FileInputStream(new File(img_path));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Member member = new Member(memberId, memberName, memberPhone, memberSmartPhone, memberEmail, memberAddress, memberAge, img);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n1 = memberDao.update(con, member);
			if(n1 == 1) {
				JOptionPane.showMessageDialog(null, "會員資料修改成功");
				this.resetValue();
				queryMember();
			}
			else {
				JOptionPane.showMessageDialog(null, "會員資料修改失敗");
			}
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "會員資料修改失敗");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	// 會員刪除事件
	private void deleteButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String id = dtm.getValueAt(memberTable.getSelectedRow(), 0).toString();
		JOptionPane.showMessageDialog(this, new MemberDao().deleteMember(id, null));
		queryMember();
	}

	// 會員查詢事件
	private void queryButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setMember_id(s_memberIdTxt.getText());
		member.setMember_name(s_memberNameTxt.getText());
		
		ArrayList<Member> arrayMember = new MemberDao().querySomeMember(member, null);
		dtm.setRowCount(0);
		
		for(Member m : arrayMember) {
			Vector v = new Vector();
			v.add(m.getMember_id());
			v.add(m.getMember_name());
			v.add(m.getPhone());
			v.add(m.getSmartphone());
			v.add(m.getEmail());
			v.add(m.getJoinLine());
			v.add(m.getAddress());
			v.add(m.getAge());
			try {
				v.add(new ImageIcon(ImageIO.read(m.getPhoto()).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			v.add(m.getDiscount());
			dtm.addRow(v);
		}
	}
	
	public void queryMember() {
		dtm.setRowCount(0);
		List<Member> memberList = new MemberDao().queryAllMember(null);
		
		for(Member m : memberList) {
			Vector v = new Vector();
			v.add(m.getMember_id());
			v.add(m.getMember_name());
			v.add(m.getPhone());
			v.add(m.getSmartphone());
			v.add(m.getEmail());
			v.add(m.getJoinLine());
			v.add(m.getAddress());
			v.add(m.getAge());
			try {
				v.add(new ImageIcon(ImageIO.read(m.getPhoto()).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			v.add(m.getDiscount());
			dtm.addRow(v);
		}
		

	}

	// 重製表格
	private void resetValue() {
		this.memberIdTxt.setText("");
		this.memberNameTxt.setText("");
		this.memberPhoneTxt.setText("");
		this.memberSmartPhoneTxt.setText("");
		this.memberEmailTxt.setText("");
		this.memberAddressTxt.setText("");
		this.memberAgeTxt.setText("");
	}
	
	// 顯示圖片
	public ImageIcon ResizeImage(String ImagePath, byte[] pic) {
		ImageIcon myImage = null;
		if(ImagePath != null) {
			myImage = new ImageIcon(ImagePath);
		}
		else {
			myImage = new ImageIcon(pic);
		}
		Image img = myImage.getImage().getScaledInstance(lbl_Image.getWidth(), lbl_Image.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		return image;
	}
}
