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
 * standardmäßig verwendete GUI. Sie dient als Container für das Spielfeld.
 * 
 * @author Nico
 * @author Larissa
 *
 */

public class MainView extends JFrame implements IMainView{
	
	/**
	 * Diese Klassenvariable ist vom Typ {@link JPanel} und enthält die gesamte sichtbare Fläche.
	 */
	private JPanel contentPane;
	
	/**
	 * Im Konstruktor werden alle Inhalte der GUI festgelegt. 
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1192, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Das Spielfeld wird angezeigt.
		Playingfield pf = new Playingfield();
		JPanel center = pf;
		contentPane.add(center, BorderLayout.CENTER);
		
		// Der Bereich über dem Spielfeld wird aufgeteilt, sodass die Überschrift mittig und ein Button linksbündig angezeigt werden
		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.PAGE_START);
		GridLayout gLayout = new GridLayout(0,3);		
		top.setLayout(gLayout);
		JPanel panel = new JPanel();
		top.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		// Button Neustart wird eingefügt
		JButton btnRestart = new JButton("Neustart");
		btnRestart.setMargin(new Insets(10,10,10,10));
		btnRestart.addActionListener(new ActionListener() {
			// Anklicken des Buttons wird erkannt und Methode im Controller zum Neustarten des Spiels wird aufgerufen
			@Override
			public void actionPerformed(ActionEvent e) {
				pf.getPlayingFieldController().restart();
			}
		});
		panel.add(btnRestart);
		// Überschrift wird hinzugefügt
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