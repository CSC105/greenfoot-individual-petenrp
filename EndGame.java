import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGame extends World
{
    TotalScore totalscoreObj = null;
    
    public EndGame(int score) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 506, 1, false); 
        
        setPaintOrder (GameOver.class, PlayAgain.class, TotalScore.class);
        
        GameOver gameover = new GameOver();
        addObject (gameover, getWidth()/2, 120);
        
        PlayAgain playagain = new PlayAgain();
        addObject (playagain, 752, 457);
        
        totalscoreObj = new TotalScore(score);
        addObject (totalscoreObj, 450, 260);
        
        EndGameBackground world1 = new EndGameBackground();
        EndGameBackground world2 = new EndGameBackground();
        addObject(world1, getWidth()/2, getHeight()/2);
        addObject(world2, getWidth() + getWidth()/2, getHeight()/2);
    }
}
