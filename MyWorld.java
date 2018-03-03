import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int trashCanCounter = 0;
    private int tRexCounter = 0;
    private int fireCounter = 0;
    public int score = 0;
    Score scoreObj = null;
    private int timeCounter = 0;
    BeetrootScore beetrootscoreObj = null;
    
    public static GreenfootSound galaxy = new GreenfootSound ("Galaxy.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 506, 1, false); 
        //super(1200, 675, 1, false); 
        Beetroot.resetScore();

        // Set paint order (Bottom to Top)
        setPaintOrder (GameOver.class, Score.class, BeetrootScore.class, BeetrootP.class,
            DragonFire.class, Dragon.class, Crystal.class,
            Flamingo.class, Beetroot.class,TRex.class);

        Flamingo fla = new Flamingo();
        addObject (fla, 426, 50);

        Dragon dragon = new Dragon();
        addObject (dragon, 30, 120);

        BeetrootP beetrootp = new BeetrootP();
        addObject (beetrootp, 730, 22);

        // Creat a Score object
        scoreObj = new Score();
        addObject(scoreObj, 825, 45);
        scoreObj.setScore(0);

        beetrootscoreObj = new BeetrootScore();
        addObject(beetrootscoreObj, 715, 45);
        beetrootscoreObj.setBeetrootScore(0);

        Background world = new Background();
        Background world2 = new Background();
        addObject( world, getWidth()/2, getHeight()/2);
        addObject( world2, getWidth() + getWidth()/2, getHeight()/2);
    }

    public void act() {
        TRex();
        Fire();
        Crystal();
        Beetroot();
        Score();
        Sound();
    }

    public void Score() {
        if (timeCounter % 5 == 0) {
            score++;
            scoreObj.setScore(score);
        }
        timeCounter++;
    }

    public void TRex() {
        tRexCounter++;
        if (tRexCounter == 430) {
            TRex tRex = new TRex();
            addObject(tRex, getWidth(), 418);
            tRexCounter = 0;
        }
    }

    public void Fire() {
        fireCounter++;
        if (fireCounter == 630) {
            DragonFire dragonfire = new DragonFire();
            addObject(dragonfire, 188, 185);
            fireCounter = 0;
        }
    } 

    public void Beetroot() {
        if(Greenfoot.getRandomNumber(100)<1) {
            Beetroot beetroot = new Beetroot();
            addObject(beetroot, getWidth(), 240);
        }
    }

    public void Crystal() {
        if(Greenfoot.getRandomNumber(300)<1) {
            Crystal crystal = new Crystal();
            addObject(crystal, Greenfoot.getRandomNumber(300) + 300, 0);
        }
        if(Greenfoot.getRandomNumber(300)<1) {
            Crystal crystal = new Crystal();
            addObject(crystal, Greenfoot.getRandomNumber(300) + 600, 0);
        }
        //System.out.println(Greenfoot.getRandomNumber(300) + 300);
    }

    public void gameOver() {
        int totalScore = score + (Beetroot.beetrootScore*50);
        Greenfoot.setWorld(new EndGame(totalScore));
    }

    public void Sound() {
        galaxy.play();
    }
}
