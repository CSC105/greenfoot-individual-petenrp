import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    public static GreenfootSound grape = new GreenfootSound ("Grape.mp3");

    public void act(){
        Sound();
    }

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public void Sound(){
        grape.play();
        
    }

    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 506, 1); 

        Start start = new Start();
        addObject (start, 195, 355);

        Logo logo = new Logo();
        addObject (logo, 185, 155);
    }

}
