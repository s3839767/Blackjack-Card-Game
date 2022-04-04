package mvc.app;

import javax.swing.SwingUtilities;


import mvc.view.CardFrame;



public class CardTest {
	

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable()
	      {
	         @Override
	         public void run()
	         {
	        	 new CardFrame(	); // creates the GUI of the CardGameApp
	        	 
	         }
	      });
	}

}
