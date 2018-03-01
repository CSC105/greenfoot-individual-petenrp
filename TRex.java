import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TRex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TRex extends Actor
{
    private GreenfootImage[] tRex = new GreenfootImage[9];
    private int frame = 1;
    
    /**
     * Act - do whatever the Dinosaur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int ANIMATE_EVERY = 8;
    int frameSinceAnimate = 0;
    public void act() 
    {
        if (frameSinceAnimate == ANIMATE_EVERY) {
            animate();
            frameSinceAnimate = 0;
        }
        frameSinceAnimate++;
        
        setLocation(getX()-6, getY());
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }
    
    public TRex() {
        //GreenfootImage tRex = getImage();
        //tRex.scale(tRex.getWidth()/17, tRex.getHeight()/17);
    }
    
    protected void addedToWorld(World world) {
        for (int i = 1; i <= 8; i++) {
            tRex[i] = new GreenfootImage("Dinosaur" + i + ".png");
            //tRex[i].scale(tRex[i].getWidth()/17, tRex[i].getHeight()/17);
        }
    }

    public void animate() {
        GreenfootImage image = getImage();
        setImage(tRex[frame]);
        if (frame == 8) {
            frame = 1;
            return;
        }
        frame++;
    }
}
