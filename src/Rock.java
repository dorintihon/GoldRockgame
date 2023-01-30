//Dorin Tihon
import java.awt.*;

/**
 Rock class to define the rock object that has an attribute for color that is set to black.
 */
public class Rock {


    //Variables
    private Color color;

    //Default constructor
    public Rock() {
        color = Color.BLACK;
    }

    //Parameter constructor
    public Rock(Color color) {
        this.color = color;
    }

    //getColor() method that returns the color variable
    public Color getColor() {
        return color;
    }

    //setColor() method that sets the color variable to the given parameter
    public void setColor(Color color) {
        this.color = color;
    }


    //toString method to print the Rock object information
    @Override
    public String toString() {
        return "Rock color=" + color;
    }
}