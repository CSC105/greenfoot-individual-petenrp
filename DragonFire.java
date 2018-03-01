import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DragonFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DragonFire extends Actor
{
    /**
     * Act - do whatever the DragonFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        firing();
        if (!Flamingo.cheatMode) {
            gameOver();
        }
        if (getY() == getWorld().getHeight() + (getImage().getHeight() / 2)) {
            getWorld().removeObject(this);
        }
    }    
    
    public DragonFire() {
        GreenfootImage fire = getImage();
        fire.scale(fire.getWidth()/20, fire.getHeight()/20); //144.2 * 128.05
    }
    
    public void firing() {
        setLocation(getX() + 3, getY() + 3);
    }
   
    public void gameOver(){
      if( getX() > 366 && getY() > 366 ){
        Actor player = getOneIntersectingObject( Flamingo.class );
        if(player != null && player.getY() > 372 && player.getX() - getX() < -2){
          displayGameOver();
        }
      }
    }
    
    private void displayGameOver() {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }

}
