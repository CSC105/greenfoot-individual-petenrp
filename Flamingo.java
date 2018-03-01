import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Flamingo extends Actor
{
    private int groundLevel = 420;
    private int jumpSpeed;

    private int frame = 1;
    private GreenfootImage[] forward = new GreenfootImage[37];
    private GreenfootImage[] backward = new GreenfootImage[37];

    /**
     * Act - do whatever the Flamingo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public static boolean cheatMode = false;

    public void act() 
    {
        if (!cheatMode) {
            gameOver();
        }
        animateF();
        controlKey();
        onGround();
    }

    public void gameOver() {
        if (getOneIntersectingObject(TRex.class) != null ||
        getOneIntersectingObject(Crystal.class) != null)
        {
            displayGameOver();
        }

    }

    private void displayGameOver() {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }

    public Flamingo() {
        GreenfootImage forward = getImage();
        forward.scale(forward.getWidth()/8, forward.getHeight()/8);
    }

    protected void addedToWorld(World world) {
        for (int i = 1; i <= 36; i++) {
            forward[i] = new GreenfootImage("Flamingo" + i + ".png");
            forward[i].scale(forward[i].getWidth()/8, forward[i].getHeight()/8);

            backward[i] = new GreenfootImage("Flamingo" + i + ".png");
            backward[i].scale(backward[i].getWidth()/8, backward[i].getHeight()/8);
            backward[i].mirrorHorizontally();
        }
    }

    public void animateF() {
        GreenfootImage image = getImage();
        setImage(forward[frame]);
        if (frame == 36) {
            frame = 1;
            return;
        }
        frame++;
    }

    public void animateB() {
        GreenfootImage image = getImage();
        setImage(backward[frame]);
        if (frame == 36) {
            frame = 1;
            return;
        }
        frame++;
    }

    private int speed = 5; 
    boolean jumpPressed = false;
    boolean cheatPressed = false;
    final int MAX_JUMP = 2;
    private int jumpCount;
    public void controlKey() {
        if (Greenfoot.isKeyDown("up")) {
            if (!jumpPressed && jumpCount < MAX_JUMP) {
                jump();
                jumpPressed = true;
                jumpCount++;
            }
        }
        else {
            jumpPressed = false;
        }
        if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth() / 3 * 2) {
            animateF();
            setLocation(getX()+speed, getY());
        }
        if (Greenfoot.isKeyDown("left") && getX() > getWorld().getWidth() / 3) {
            animateB();
            setLocation(getX()-speed, getY());
        }
        if (Greenfoot.isKeyDown("c")) {
            if (!cheatPressed) {
                cheatMode = !cheatMode;
                cheatPressed = true;
            }
        }
        else {
            cheatPressed = false;
        }

        //System.out.println(Greenfoot.isKeyDown("up"));
    }

    public void onGround() {
        boolean onGround = (getY() == groundLevel);

        if (!onGround) { //during jump
            fall();
        }
        else {
            jumpCount = 0;
        }
        /*else if ("space".equals(Greenfoot.getKey())) { // jump key detected
        jump();
        }*/
    }

    public void fall() {
        jumpSpeed++; // add gravity
        setLocation (getX(), getY() + jumpSpeed); // falling faster
        if (getY() >= groundLevel) { // landed (reached ground level)
            setLocation(getX(), groundLevel); // set on ground
            //Greenfoot.getKey(); // clears any key pressed during jump
        }
    }

    public void jump() {
        jumpSpeed = -20; // add jump speed
        setLocation(getX(), getY() + jumpSpeed); // leave ground
    }
}