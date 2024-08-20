import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InstructionButton extends Actor {
    public InstructionButton() {
        setImage(new GreenfootImage("instructions-button.jpg")); // Ensure you have instructions_button.png in your images folder
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new InstructionsWorld());
        }
    }
}
