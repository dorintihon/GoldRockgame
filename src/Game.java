//Dorin Tihon
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 Game class which contains the GUI and game logic by creating a JFrame and implementing
 the ActionListener which also has methods to Start and to Reset the game.
 */

class Game extends JFrame implements ActionListener {

    //Variables
    JButton[] buttons = new JButton[3];
    Rock[] rocks = new Rock[3];
    int tries;
    int goldButton;
    JFrame frame;
    JLabel textField;

    //Method to handle button clicks and perform game logic
    public void actionPerformed(ActionEvent e) {

        //If loop to perform if there are tries left
        if (tries > 0) {

            //Loop through all buttons
            for (int i = 0; i < 3; i++) {

                //If the clicked button is found
                if (e.getSource() == buttons[i]) {

                    //Change the color of the button to show it's type when it is clicked
                    buttons[i].setBackground(rocks[i].getColor());

                    //If the button is the gold rock
                    if (i == goldButton) {

                        //Show a dialog asking to play again or exit
                        JOptionPane winner = new JOptionPane();
                        int result = JOptionPane.showConfirmDialog(winner, "Congratulation you found the gold rock. \nPlay again?", "Game over", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            resetGame();
                        } else System.exit(0);
                    }

                    //If the button is not the gold rock
                    else {

                        //Show a dialog saying the button is not the gold rock
                        JOptionPane.showMessageDialog(this, "Sorry, this is not the gold rock. Try again.", "Try again", JOptionPane.INFORMATION_MESSAGE);

                        //Decrease the number of clicks remaining
                        tries--;

                        //Update the textField with the number of clicks remaining
                        textField.setText("Tries left: " + tries);
                    }
                }

            }

            //If there are no clicks remaining
            if (tries == 0) {

                // Show a dialog asking to play again or exit
                JOptionPane winner = new JOptionPane();
                int result = JOptionPane.showConfirmDialog(winner, "Game over. \nThanks for playing. Play again?", "Game over", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    resetGame();
                } else System.exit(0);
            }
        }
    }

    //Start the game by creating the JFrame
    public void startGame() {

        //Initialize the tries by setting it to 2
        tries = 2;


        //Create the JFrame and set its size
        frame = new JFrame("Gold Rock Game");
        frame.setSize(550, 550);

        //Create a JPanel and set its layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        //Create a JLabel to display the number of tries left
        textField = new JLabel();
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tries left: " + tries);
        textField.setForeground(new Color(24, 38, 89));
        textField.setFont(new Font("Arial", Font.BOLD, 50));
        frame.add(textField, BorderLayout.NORTH);


        //Create three buttons
        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton(){

                //Override the paintComponent method to draw a circle
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(getBackground());
                    g.fillOval(0, 0, 100, 100 );
                    super.paintComponent(g);
                }
            };

            //Set the preferred size of the button
            buttons[i].setPreferredSize(new Dimension(100, 100));
            buttons[i].setContentAreaFilled(false);

            //Create a new Rock object
            rocks[i] = new Rock();

            //Set the background color of the button to BLUE
            buttons[i].setBackground(Color.BLUE);


            buttons[i].addActionListener(this);
            buttons[i].setBorderPainted(false);

            //Add the button to the panel
            panel.add(buttons[i]);
        }


        //Randomly choose one button to hold the gold rock
        goldButton = (int)(Math.random() * 3);
        rocks[goldButton] = new GoldRock();

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Method that resets the game by disposing the current frame and starting a new game.
    public void resetGame() {
        frame.dispose();
        startGame();
    }

    //Main method that creates a new Game object and starts the game.
    public static void main(String[] args) {
        Game g = new Game();
        g.startGame();
    }
}




