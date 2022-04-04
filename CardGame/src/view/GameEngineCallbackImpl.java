package view;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   public static final Logger logger = Logger.getLogger(GameEngineCallbackImpl.class.getName());

   // utility method to set output level of logging handlers
   public static Logger setAllHandlers(Level level, Logger logger, boolean recursive)
   {
      // end recursion?
      if (logger != null)
      {
         logger.setLevel(level);
         for (Handler handler : logger.getHandlers())
            handler.setLevel(level);
         // recursion
         setAllHandlers(level, logger.getParent(), recursive);
      }
      return logger;
   }

   public GameEngineCallbackImpl()
   {
      // NOTE can also set the console to FINE in %JRE_HOME%\lib\logging.properties
      setAllHandlers(Level.FINE, logger, true);
   }

   @Override
   public void nextCard(Player player, PlayingCard card, GameEngine engine) // Outputs the next card dealt for player
   {
      // intermediate results logged at Level.FINE
	   logger.log(Level.FINE, String.format("Card Dealt to %s .. %s", player.getPlayerName(), card));
      
   }

   @Override
   public void result(Player player, int result, GameEngine engine) // Outputs the final results for player
   {
      // final results logged at Level.INFO
	   logger.log(Level.INFO, String.format("%s, final result =%d", player.getPlayerName() , result));
      
   }

@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) // Outputs the bust card dealt to player
	{ 
		logger.log(Level.INFO, String.format("Card Dealt to %s .. %s ... YOU BUSTED!", player.getPlayerName(), card));
	
	}

@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) // Outputs the next card dealt for House
	{
		logger.log(Level.FINE, String.format("Card Dealt to House .. %s", card));
	
	}

@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) // Outputs the bust card dealt to House
	{
		logger.log(Level.INFO, String.format("Card Dealt to House .. %s ... HOUSE BUSTED!", card));
	
	}

@Override
	public void houseResult(int result, GameEngine engine)  // Outputs the final results for House
	{
		logger.log(Level.INFO, String.format("House, final result =%d", result));
		StringBuilder sbuilder = new StringBuilder("Final Player Results \n");
		for (Player p1 : engine.getAllPlayers())
			sbuilder.append(p1.toString() + "\n");
		logger.log(Level.INFO, sbuilder.toString());	
	}
	




}
