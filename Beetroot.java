import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Beetroot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beetroot extends Actor
{
    public static int beetrootScore = 0;
    
    /**
     * Act - do whatever the Beetroot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-2, getY());
        if (getOneIntersectingObject(Flamingo.class) != null)
        {
            beetrootScore++;
            getWorld().removeObject(this);
        }
    }    
    public Beetroot() {
        GreenfootImage beetroot = getImage();
        beetroot.scale(beetroot.getWidth()/25, beetroot.getHeight()/25);
    }
    public static void resetScore() {
        beetrootScore = 0;
    }
}
