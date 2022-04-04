package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import mvc.controller.CardFrameListener;
import mvc.model.GameEngineCallbackGUI;
import view.interfaces.GameEngineCallback;

public class CardFrame extends JFrame {

	
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	private CentrePanel centrepanel;
	private StatusBarPanel sbPanel;
	
	
	GameEngine gameEngine = new GameEngineImpl();
	GameEngineCallback gegui;
	
	
	public CardFrame() {
		super("CardGame"); // calls frame constructor with title "CardGame"
        setMinimumSize(new Dimension((int) dimension.getWidth() / 2, (int) dimension.getHeight() / 2)); // sets window's minimum height/width of half screen size
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    addComponentListener(new CardFrameListener(this)); // adds frame listener to adjust frame components when resizing it 
	    setLayout(new BorderLayout());
	    populate();
	    
	    gegui = new GameEngineCallbackGUI(this);
	    gameEngine.addGameEngineCallback(gegui); // links A1 GameEngine to A2 GUI
	    
	    
	}
	
	public void populate() // adds the appropriate panels to the right locations according to the BorderLayout of the CardFrame
	{
		
		
		this.sbPanel = new StatusBarPanel(this);
		add(sbPanel, BorderLayout.SOUTH);
		
		this.centrepanel = new CentrePanel(this);
		centrepanel.populate();
		add(centrepanel, BorderLayout.CENTER);
		
		add(new CardToolBarPanel(this), BorderLayout.NORTH);
		
		repaint();
		revalidate();
	}
	
	
	
	public CentrePanel getCentrePanel() {
		
		return centrepanel;
	}
	
	
	public GameEngine getGameEngine() {
		
		return gameEngine;
	}
	
	public StatusBarPanel getStatusBarPanel() {
		
		return sbPanel;
	}
	
	
	
	
}
