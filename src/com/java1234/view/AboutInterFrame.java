package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

/**
 * 關於我們介面
 * @author Jack
 *
 */

public class AboutInterFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutInterFrame frame = new AboutInterFrame();
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
	public AboutInterFrame() {
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("S09350204 廖書賢");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 26));
		
		JLabel lblS = new JLabel("S09350207 陳茂霖");
		lblS.setFont(new Font("標楷體", Font.PLAIN, 26));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblS, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(lblNewLabel)
					.addGap(49)
					.addComponent(lblS, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		setClosable(true);
		setTitle("製作人員");
		setBounds(100, 100, 450, 300);

	}
}
