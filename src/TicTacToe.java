import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;



public class TicTacToe implements ActionListener{

    // Random object to determine the first player's turn.
    Random random = new Random();
    // JFrame to hold the GUI components.
    JFrame frame = new JFrame();
    // JPanel to hold the title label.
    JPanel title_panel = new JPanel();
    // JPanel to hold the buttons.
    JPanel button_panel = new JPanel();
    // JLabel to display game status.
    JLabel textfield = new JLabel();
    // Array of JButtons to represent the tic-tac-toe grid.
    JButton[] buttons = new JButton[9];
    // Boolean to track player turns.
    boolean player1_turn;

    // Constructor to initialize the game.
    TicTacToe() {

        // Set up the JFrame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Set up the title label.
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        // Set up the title panel.
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        // Set up the button panel.
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        // Create and add buttons to the button panel.
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            // Set initial button background color to purple  (128, 0, 128).
            buttons[i].setBackground(new Color(128, 0, 128));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // Add components to the frame.
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        // Determine the first player's turn.
        firstTurn();
    }

    // ActionListener implementation for button clicks.
    @Override
    public void actionPerformed(ActionEvent e) {

        // Check which button was clicked.
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                // Handle player turns.
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        // Set X symbol and change turn.
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        // Set O symbol and change turn.
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    // Method to determine the first player's turn.
    public void firstTurn() {

        // Delay for 2 seconds before starting the game.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Randomly select the first player's turn.
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    // Method to check for win or stalemate conditions.
    public void check(){
        // check X win conditions
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ){
            xWins(0,1,2);
        }
        // check X win conditions
        if(
                        (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        // check X win conditions
        if(
                        (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        // check X win conditions
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        // check X win conditions
        if(
                        (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        // check X win conditions
        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        // check X win conditions
        if(
                        (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        // check X win conditions
        if(
                        (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }
        // check O win conditions
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        // check O win conditions
        if(
                        (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        // check O win conditions
        if(
                        (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }
        // check O win conditions
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        // check O win conditions
        if(
                        (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        // check O win conditions
        if(
                        (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        // check O win conditions
        if(
                        (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        // check O win conditions
        if(
                        (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }

        // Check stalemate condition

        boolean stalemate = true;

        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                stalemate = false;
                break;
            }
        }

        if (stalemate) {
            textfield.setText("Stalemate");
        }

    }

    // Method to handle X wins.
    public void xWins(int a, int b, int c) {
        // Highlight winning buttons in green.
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        // Disable all buttons.
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        // Display X wins message.
        textfield.setText("X wins");
    }

    // Method to handle O wins.
    public void oWins(int a, int b, int c) {
        // Highlight winning buttons in green.
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        // Disable all buttons.
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        // Display O wins message.
        textfield.setText("O wins");
    }
}
