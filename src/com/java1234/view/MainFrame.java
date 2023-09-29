package com.java1234.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

/**
 * 主介面
 * @author Jack
 *
 */

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("管理系統主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2208, 1296);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("選項");
		mnNewMenu.setFont(new Font("標楷體", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("水果");
		mnNewMenu_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("加入");
		mntmNewMenuItem_2.setFont(new Font("標楷體", Font.PLAIN, 15));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FruitAddInterFrame faif = new FruitAddInterFrame();
				faif.setVisible(true);
				table.add(faif);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("管理");
		mntmNewMenuItem_3.setFont(new Font("標楷體", Font.PLAIN, 15));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FruitManageInterFrame fmif = new FruitManageInterFrame();
				fmif.setVisible(true);
				table.add(fmif);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("會員");
		mnNewMenu_4.setFont(new Font("標楷體", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("加入");
		mntmNewMenuItem_4.setFont(new Font("標楷體", Font.PLAIN, 15));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberAddInterFrame maif = new MemberAddInterFrame();
				maif.setVisible(true);
				table.add(maif);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("管理");
		mntmNewMenuItem_5.setFont(new Font("標楷體", Font.PLAIN, 15));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberManageInterFrame mmif = new MemberManageInterFrame();
				mmif.setVisible(true);
				table.add(mmif);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_5 = new JMenu("供應商");
		mnNewMenu_5.setFont(new Font("標楷體", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("加入");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierAddInterFrame saif = new SupplierAddInterFrame();
				saif.setVisible(true);
				table.add(saif);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("標楷體", Font.PLAIN, 15));
		mnNewMenu_5.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("管理");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierManageInterFrame smif = new SupplierManageInterFrame();
				smif.setVisible(true);
				table.add(smif);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("標楷體", Font.PLAIN, 15));
		mnNewMenu_5.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("水果交易");
		mnNewMenu_2.setFont(new Font("標楷體", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("加入");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradeAddInterFrame taif = new TradeAddInterFrame();
				taif.setVisible(true);
				table.add(taif);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("標楷體", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("管理");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradeManageInterFrame tmif = new TradeManageInterFrame();
				tmif.setVisible(true);
				table.add(tmif);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("標楷體", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("退出系統");
		mntmNewMenuItem.setFont(new Font("標楷體", Font.PLAIN, 16));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系統");
				if(result == 0) {
					dispose();
				}	
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu.add(menuBar_1);
		
		JMenu mnNewMenu_3 = new JMenu("關於我們");
		mnNewMenu_3.setFont(new Font("標楷體", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("製作人員");
		mntmNewMenuItem_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutInterFrame aif = new AboutInterFrame();
				aif.setVisible(true);
				table.add(aif);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		// 設置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
