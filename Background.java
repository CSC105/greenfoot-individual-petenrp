import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    public Background(){
      image = new GreenfootImage("background.png");
      image.scale(900, 506);
      setImage(image);
    }
    public void act()
    {
       setLocation( getX()-2, getY() );
       if( getX() < -image.getWidth()/2 ) {
           setLocation( image.getWidth() + image.getWidth()/2 - (-getX() - image.getWidth()/2), image.getHeight()/2);
        }
    }    
}
