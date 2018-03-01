import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.Font;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeetrootScore extends Actor
{
    public BeetrootScore() {
        GreenfootImage beetrootScore = new GreenfootImage(90, 50); //frame size
        setImage(beetrootScore);
    }

    public void setBeetrootScore(int score) {
        GreenfootImage score_ = getImage();
        score_.clear();

        Font f = new Font("SF Slapstick Comic Shaded", true, false, 36);
        score_.setFont(f);

        Color c = new Color(0, 0, 0, 0); // fill frame color RGB & alpha value 0-255
        score_.setColor(c);
        
        score_.fill();
        score_.setColor(Color.WHITE);

        score_.drawString("" + Beetroot.beetrootScore, 20, 35); //Draw text ("string", start point low left) 
        setImage(score_);
    } 
    
    public void act() {
        setBeetrootScore(Beetroot.beetrootScore);
    }
    
}
