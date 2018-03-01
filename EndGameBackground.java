import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGameBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGameBackground extends Actor
{
    private GreenfootImage image = new GreenfootImage("blurbackground.png");
    
    public void act() { 
       setLocation( getX()-3, getY() );
       if( getX() < -image.getWidth()/2 ) {
           setLocation( image.getWidth() + image.getWidth()/2 - (-getX() - image.getWidth()/2), image.getHeight()/2);
        }
    }    
}    

