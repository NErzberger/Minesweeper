package main;

import controller.IMainView;
import view.MainView;

/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Main{

	public Main(IMainView mView) {
		mView.run();
	}
	

	/**
	 * Hier wird die Applikation gestartet.
	 */
	public static void main(String[] args) {
		new Main(new MainView());
		
	}


}
