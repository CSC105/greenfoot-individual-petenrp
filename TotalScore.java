import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.Font;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class TotalScore extends Actor
{
    //public static int totalscore = Score. + (beetrootScore*5);

    int score = 0;
    
    public TotalScore(int score) {
        this.score = score;
        GreenfootImage totalscore = new GreenfootImage(250, 100); //frame size
        setImage(totalscore);
        setScore(score);
    }

    public void setScore(int score) {
        GreenfootImage score_ = getImage();
        score_.clear();

        Font f = new Font("Crayon Hand Regular 2016 Demo", true, false, 108);
        score_.setFont(f);

        Color c = new Color(0, 0, 0, 0); // fill frame color RGB & alpha value 0-255
        score_.setColor(c);
        
        score_.fill();
        score_.setColor(Color.YELLOW);

        score_.drawString("" + score, 10, 85); //Draw text ("string", start point low left) 
        setImage(score_);
        
        System.out.println(score);
    } 
}
