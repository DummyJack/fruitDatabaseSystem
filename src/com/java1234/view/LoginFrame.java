package com.java1234.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

/**
 * 使用者登入介面
 * @author Jack
 *
 */

public class LoginFrame extends JFrame {
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("管理系統登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 400);
		
		JLabel lblNewLabel = new JLabel("水果管理系統");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/apple.jpg")));
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		userNameTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("登入");
		btnNewButton_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(150)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addGap(34))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1)
											.addGap(18)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
										.addComponent(userNameTxt)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(218)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1))
					.addGap(39)
					.addComponent(btnNewButton_1)
					.addGap(106))
		);
		getContentPane().setLayout(groupLayout);
		
		// 設置JFrame追蹤顯示
		this.setLocationRelativeTo(null);
	}
	
	// 登入事件處理
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName =  this.userNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "帳號不能為空!");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密碼不能為空!");
			return;
		}
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser != null) {
				dispose();
				new MainFrame().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
