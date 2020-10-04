package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

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
		
		JLabel lblHallo = new JLabel("Minesweeper");
		top.add(lblHallo);
	}

}
