package mvc.controller;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import mvc.view.CardFrame;

public class CardFrameListener implements ComponentListener {
    private CardFrame cardFrame;
    
    public CardFrameListener(CardFrame cardFrame) {
        this.cardFrame = cardFrame;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // TODO Auto-generated method stub
    	cardFrame.getCentrePanel().getCardPanel().setPreferredSize(new Dimension(cardFrame.getWidth(), cardFrame.getCentrePanel().getHeight() * 2 / 3));
    	cardFrame.getCentrePanel().getCardPanel().repaint();
    	cardFrame.getCentrePanel().getCardPanel().revalidate();
        
    	cardFrame.getCentrePanel().getSummaryPanel().setPreferredSize(new Dimension(cardFrame.getWidth(), cardFrame.getCentrePanel().getHeight() / 3));
    	cardFrame.getCentrePanel().getSummaryPanel().repaint();
    	cardFrame.getCentrePanel().getSummaryPanel().revalidate();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub
        
    }

}