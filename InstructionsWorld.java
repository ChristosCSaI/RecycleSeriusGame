import greenfoot.*;  

public class InstructionsWorld extends World {
    private BackButton backButton;

    public InstructionsWorld() {    
        super(600, 400, 1);

        displayInstructions();
        addBackButton();
    }

    private void displayInstructions() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        setBackground(bg);

    
        String instructions = "Instructions:\n\n" +
                              "1. Use arrow keys to move the player character.\n" +
                              "2. Collect recyclable items to score points:\n" +
                              "   - Plastic: 10 points\n" +
                              "   - Paper: 20 points\n" +
                              "   - Metal: 30 points\n" +
                              "3. Avoid obstacles such as:\n" +
                              "   - Trash cans\n" +
                              "   - Non-recyclable waste\n" +
                              "4. Power-ups:\n" +
                              "   - Speed boost: Increases speed for 10 seconds\n" +
                              "   - Shield: Protects from one obstacle hit\n" +
                              "5. Quizzes:\n" +
                              "   - Answer correctly to gain bonus points\n" +
                              "   - Incorrect answers will not deduct points\n\n" +
                              "Good luck and keep the environment clean!";

       
        GreenfootImage textImage = new GreenfootImage(instructions, 18, Color.BLACK, new Color(0, 0, 0, 0));
        bg.drawImage(textImage, (getWidth() - textImage.getWidth()) / 2, 50);
        setBackground(bg);
    }

    private void addBackButton() {
        backButton = new BackButton();
        addObject(backButton, 50, getHeight() - 50);
    }
}
