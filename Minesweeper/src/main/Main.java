package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DataGrid;

import javax.swing.JButton;
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
	 * Launch the application.
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
	 * Create the frame.
	 */
	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 690);
//		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel center = new Playingfield(4, 3);
		
		contentPane.add(center, BorderLayout.CENTER);
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.PAGE_START);
		
		JLabel lblHallo = new JLabel("Hallo");
		top.add(lblHallo);
	}

}
