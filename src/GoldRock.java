//Dorin Tihon
import java.awt.*;

/**
 Rock class a subclass of Rock class to define the
 gold rock object that has an attribute for color that is set to YELLOW.
 */
class GoldRock extends Rock {

    //Variables
    private Color color;

    //Default constructor
    public GoldRock() {
        this.color = Color.YELLOW;
    }

    //Parameter constructor
    public GoldRock(Color color) {
        this.color = color;
    }

    //Overrided getColor() method that returns the color variable of GoldRock class
    @Override
    public Color getColor() {
        return color;
    }

    //Overrided setColor() method that sets the color variable of GoldRock class to the given parameter
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    //toString method to print the GoldRock object information
    @Override
    public String toString() {
        return super.toString();
    }
}