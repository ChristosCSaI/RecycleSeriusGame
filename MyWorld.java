import greenfoot.*;  

/**
 * MyWorld is a base class for all other game worlds.
 */
public class MyWorld extends World {

    /**
     * Default constructor for objects of class MyWorld.
     */
    public MyWorld() {
       
        super(600, 400, 1);
    }

    /**
     * Constructor for objects of class MyWorld with custom size.
     */
    public MyWorld(int width, int height, int cellSize) {
        super(width, height, cellSize);
    }
}
