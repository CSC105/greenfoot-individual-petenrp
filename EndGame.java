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
    public static GreenfootSound end = new GreenfootSound ("End.mp3");

    public void act(){
        Sound();
    }

    public void Sound(){
        end.play();
        MyWorld.galaxy.stop();
    }

    public EndGame(int score) {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 506, 1, false); 
        
        totalscoreObj = new TotalScore(score);
        addObject (totalscoreObj, 450, 260);

        setPaintOrder (GameOver.class, TryAgain.class, TotalScore.class, Menu.class);

        GameOver gameover = new GameOver();
        addObject (gameover, getWidth()/2, 120);

        TryAgain tryagain = new TryAgain();
        addObject (tryagain, 455, 355);

        Menu menu = new Menu();
        addObject (menu, 830, 420);

        EndGameBackground world1 = new EndGameBackground();
        EndGameBackground world2 = new EndGameBackground();
        addObject(world1, getWidth()/2, getHeight()/2);
        addObject(world2, getWidth() + getWidth()/2, getHeight()/2);
    }

}
