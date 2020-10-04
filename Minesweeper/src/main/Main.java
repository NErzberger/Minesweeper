package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JSplitPane;

/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Hier wird die Applikation gestartet.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * In diesem Konstruktor wird das Frame erstellt.
	 */
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 690);
//		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel center = new Playingfield(6, 5);
		
		contentPane.add(center, BorderLayout.CENTER);
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.PAGE_START);
		GridLayout gLayout = new GridLayout(0,3);		
		top.setLayout(gLayout);
		
		JPanel panel = new JPanel();
		top.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnRestart = new JButton("Restart");
		panel.add(btnRestart);
		btnRestart.setMargin(new Insets(10,10,10,10));
		
		JLabel lblTitle = new JLabel("Minesweeper");
		top.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}

}
