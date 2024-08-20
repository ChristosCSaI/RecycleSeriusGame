import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

public class CharacterSelectionScreen extends MyWorld {

    public CharacterSelectionScreen() {    
        super(800, 600, 1); 
        showText("Choose Your Character", 400, 200);
        showText("Click on the character to select", 400, 250);
        
        addObject(new CharacterOption("character1.jpg"), 300, 400);
        addObject(new CharacterOption("character2.jpg"), 500, 400);
    }
}

class CharacterOption extends Actor {
    private String characterImage;

    public CharacterOption(String characterImage) {
        this.characterImage = characterImage;
        setImage(characterImage);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new RecyclingWorld(characterImage));
        }
    }
}
