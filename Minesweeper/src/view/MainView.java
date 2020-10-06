package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.IMainView;

/**
 * Die Klasse MainView implementiert das Interface IMainView und ist die 
 * standartmäßig verwendete GUI. Sie dient als Container für das Spielfeld.
 * 
 * @author Nico
 * @author Larissa
 *
 */

public class MainView extends JFrame implements IMainView{
	
	/**
	 * 
	 */
	private JPanel contentPane;
	
	/**
	 * Im Konstruktor werden alle Inhalte der GUI festgelegt. 
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 690);
//		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Playingfield pf = new Playingfield(6, 5);
		
		JPanel center = pf;
		
		contentPane.add(center, BorderLayout.CENTER);
		
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.PAGE_START);
		GridLayout gLayout = new GridLayout(0,3);		
		top.setLayout(gLayout);
		
		JPanel panel = new JPanel();
		top.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnRestart = new JButton("Neustart");
		
		
		btnRestart.setMargin(new Insets(10,10,10,10));
		btnRestart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pf.getPlayingFieldController().restart();
				
			}
		});
		panel.add(btnRestart);
		
		JLabel lblTitle = new JLabel("Minesweeper");
		top.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	/**
	 * Die Methode run erstellt eine Queue, in der ein Thread gestartet wird, worin die GUI läuft.
	 * Somit hat die GUI einen eigenen Thread als Umgebung.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
