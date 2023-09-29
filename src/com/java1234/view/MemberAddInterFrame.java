package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.java1234.dao.MemberDao;
import com.java1234.model.Member;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

/**
 * 會員資料新增介面
 * @author Jack
 *
 */

public class MemberAddInterFrame extends JInternalFrame {
	private JTextField memberNameTxt;
	private JTextField memberPhoneTxt;
	private JTextField memberSmartphoneTxt;
	private JTextField memberEmailTxt;
	private JTextField memberAddressTxt;
	private JTextField memberAgeTxt;
	private JTextField memberDiscountTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton yesJrb;
	private JRadioButton noJrb;
	private JLabel lbl_Image;
	
	private DbUtil dbUtil = new DbUtil();
	private MemberDao memberDao = new MemberDao();
	private MemberManageInterFrame mmif = new MemberManageInterFrame();
	
	private String img_path = null;
	private JTextField memberIdTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAddInterFrame frame = new MemberAddInterFrame();
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
	public MemberAddInterFrame() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setFont(new Font("標楷體", Font.PLAIN, 14));
		setTitle("加入會員資料");
		setBounds(100, 100, 492, 697);
		
		JLabel lblNewLabel_1 = new JLabel("會員姓名:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("電話:");
		lblNewLabel_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("手機號碼:");
		lblNewLabel_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblline = new JLabel("是否加入東海水果公司之Line:");
		lblline.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_6 = new JLabel("住址:");
		lblNewLabel_6.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_7 = new JLabel("年齡:");
		lblNewLabel_7.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_8 = new JLabel("照片:");
		lblNewLabel_8.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9 = new JLabel("會員折扣:");
		lblNewLabel_9.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		memberNameTxt = new JTextField();
		memberNameTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		memberNameTxt.setColumns(10);
		
		memberPhoneTxt = new JTextField();
		memberPhoneTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberPhoneTxt.setColumns(10);
		
		memberSmartphoneTxt = new JTextField();
		memberSmartphoneTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberSmartphoneTxt.setColumns(10);
		
		memberEmailTxt = new JTextField();
		memberEmailTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberEmailTxt.setColumns(10);
		
		memberAddressTxt = new JTextField();
		memberAddressTxt.setFont(new Font("標楷體", Font.PLAIN, 14));
		memberAddressTxt.setColumns(10);
		
		memberAgeTxt = new JTextField();
		memberAgeTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberAgeTxt.setColumns(10);
		
		memberDiscountTxt = new JTextField();
		memberDiscountTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("加入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberAddButton(e);
			}
		});
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("選擇檔案");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 13));
		
		yesJrb = new JRadioButton("是");
		yesJrb.setFont(new Font("標楷體", Font.PLAIN, 13));
		yesJrb.setSelected(true);
		buttonGroup.add(yesJrb);
		
		noJrb = new JRadioButton("否");
		noJrb.setFont(new Font("標楷體", Font.PLAIN, 13));
		buttonGroup.add(noJrb);
		
		lbl_Image = new JLabel("");
		lbl_Image.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員身分證字號:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		memberIdTxt = new JTextField();
		memberIdTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		memberIdTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberSmartphoneTxt, 175, 175, 175))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(memberEmailTxt, 163, 163, 163))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblline)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(yesJrb, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(noJrb, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_6)
										.addComponent(lblNewLabel_7))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(memberAddressTxt, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
										.addComponent(memberAgeTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_9)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(memberDiscountTxt, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnNewButton_1)))
									.addGap(18)
									.addComponent(lbl_Image, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberPhoneTxt, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberIdTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(184)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(memberIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(memberNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(memberPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(memberSmartphoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(memberEmailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblline)
						.addComponent(yesJrb)
						.addComponent(noJrb))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(memberAddressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(memberAgeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_8))
						.addComponent(lbl_Image, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(memberDiscountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnNewButton)
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	// 會員資料加入事件處理
	private void memberAddButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String memberId = this.memberIdTxt.getText();
		String memberName = this.memberNameTxt.getText();
		String memberPhone = this.memberPhoneTxt.getText();
		String memberSmartphone = this.memberSmartphoneTxt.getText();
		String memberEmail = this.memberEmailTxt.getText();
	
		String choice = "";
		if(yesJrb.isSelected()) {
			choice = "是";
		}
		else if(noJrb.isSelected()) {
			choice = "否";
		}
		
		String memberAddress = this.memberAddressTxt.getText();
		Integer memberAge = Integer.parseInt(this.memberAgeTxt.getText());
		
		InputStream img = null;
		try {
			img = new FileInputStream(new File(img_path));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Float memberDiscount = Float.parseFloat(this.memberDiscountTxt.getText());
		
		if(StringUtil.isEmpty(memberName)) {
			JOptionPane.showMessageDialog(null, "會員名稱不能為空!");
			return;
		}
				
		Member member = new Member(memberId, memberName, memberPhone, memberSmartphone, memberEmail, choice, memberAddress, memberAge, img, memberDiscount);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n1 = memberDao.add(con, member);
			
			if(n1 == 1) {
				JOptionPane.showMessageDialog(null, "會員資料加入成功");
				resetValue();
				mmif.queryMember();
			}
			else {
				JOptionPane.showMessageDialog(null, "會員資料加入失敗");
			}
			
		} catch(Exception se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(null, "會員資料加入失敗");
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
			this.memberIdTxt.setText("");
			this.memberNameTxt.setText("");
			this.memberPhoneTxt.setText("");
			this.memberSmartphoneTxt.setText("");
			this.memberEmailTxt.setText("");
			this.yesJrb.setSelected(true);
			this.memberAddressTxt.setText("");
			this.memberAgeTxt.setText("");
			this.memberDiscountTxt.setText("");
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
			Image img = myImage.getImage();
			Image newImg = img.getScaledInstance(lbl_Image.getWidth(), lbl_Image.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(newImg);
			return image;
		}
}
