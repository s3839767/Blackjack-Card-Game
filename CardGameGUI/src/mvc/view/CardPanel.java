package mvc.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.interfaces.PlayingCard;

public class CardPanel extends JPanel {
	
	private JPanel cardpanel = new JPanel();
	TitledBorder titledBorder;
	private CardFrame cardFrame;
	File[] imageFile;
	
	public CardPanel(CardFrame cardFrame) {
		
		this.cardFrame = cardFrame;
		imageFile = new File(String.format("img%scards", File.separator)).listFiles();
		
		titledBorder = BorderFactory.createTitledBorder("Card Panel");
		cardpanel.setBorder(titledBorder);
		titledBorder.setTitleColor(Color.WHITE);
		cardpanel.setBackground(Color.black);
		cardpanel.setPreferredSize(new Dimension((int) cardFrame.getCentrePanel().getWidth(), (int) cardFrame.getCentrePanel().getHeight() - (cardFrame.getCentrePanel().getHeight() / 3)));
		
		add(cardpanel);
		
	}
	
	public void ImageCreator(PlayingCard pcard) // creates the ability to import images of the stock cards to be shown in the CardPanel.
    {
        String imgFileName = pcard.getSuit().toString() + "_" + pcard.getValue().toString() + ".PNG";
        int index = 0;
        
        while (index < imageFile.length)
        {
            if (imageFile[index].toString().contains(imgFileName)) {
                ImageIcon conurrentCard = new ImageIcon(imageFile[index].toString());
                
                Image imgCard = conurrentCard.getImage();
                Image scaleOfCard = imgCard.getScaledInstance((int) (cardFrame.getWidth() / 7), (int) (cardFrame.getHeight()  / 3), java.awt.Image.SCALE_SMOOTH);
                
                conurrentCard = new ImageIcon(scaleOfCard);
                JLabel labelOfCard = new JLabel(conurrentCard);
                
                add(labelOfCard);

            }
            index++;
        } 
    }
	
	public void clearCardPanel() {
		removeAll();
		revalidate();
		repaint();
	}
	
	
}
