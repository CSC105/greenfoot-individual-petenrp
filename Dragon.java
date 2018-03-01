import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer = 60;
    private int frame = 1;
    private GreenfootImage[] dra = new GreenfootImage[7];
    
    final int ANIMATE_EVERY = 8;
    int frameSinceAnimate = 0;
    public void act() 
    {
        if (frameSinceAnimate == ANIMATE_EVERY) {
            animate();
            frameSinceAnimate = 0;
        }
        frameSinceAnimate++;

    }  
    
    public Dragon() {
        GreenfootImage dra = getImage();
        dra.scale(dra.getWidth()*3/5, dra.getHeight()*3/5);
    }
    
    protected void addedToWorld(World world) {
        for (int i = 1; i <= 6; i++) {
            dra[i] = new GreenfootImage("dragon" + i + ".png");
            dra[i].scale(dra[i].getWidth()*3/5, dra[i].getHeight()*3/5);
        }
    }

    public void animate() {
        GreenfootImage image = getImage();
        setImage(dra[frame]);
        if (frame == 6) {
            frame = 1;
            return;
        }
        frame++;
    }
}
