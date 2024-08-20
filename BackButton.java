import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BackButton extends Actor {
    public BackButton() {
        setImage(new GreenfootImage("back-button.jpg")); // Ensure you have back_button.png in your images folder
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new InitialScreen());
        }
    }
}
