import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
import greenfoot.Font;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public Score() {
        GreenfootImage newImage = new GreenfootImage(120, 50); //frame size
        setImage(newImage);
    }

    public void setScore(int score) {
        GreenfootImage score_ = getImage();
        score_.clear();

        Font f = new Font("SF Slapstick Comic Shaded", true, false, 36);
        score_.setFont(f);

        Color c = new Color(0, 0, 0, 0); // fill frame color RGB & alpha value 0-255
        score_.setColor(c);
        
        score_.fill();
        score_.setColor(Color.PINK);

        score_.drawString("" + score, 20, 35); //Draw text ("string", start point low left) 
        setImage(score_);
    } 
}
