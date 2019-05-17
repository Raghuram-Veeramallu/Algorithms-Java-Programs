package KnightsTour;

/*
 *      PROBLEM 3
 *  KNIGHTS TOUR PROBLEM
 *
 *  Hari Sai Raghuram Veeramallu
 *      1610110145
 */


// Developed on Netbeans MacOS

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;

public class Problem3{
    
    // Initalise global variables
    private JFrame mainFrame;
    private int boardSize;
    private JButton[][] boardButtonsList;   // List of buttons on the chess board
    
    // Define some constants
    private final int BUTTON_DIMEN = 40;
    private final int BUTTON_SPACE = 45;
    private final int FRAME_PADDING = 160;
    
    // Create ChessBoard GUI
    public void createChessBoard(){
        
        // Take input and check its validity
        try{
            boardSize = Integer.valueOf(JOptionPane.showInputDialog(mainFrame, "Enter chessboard size:"));
        }catch(Exception e){
            // Throw an error if input is not valid
            showMessageDialog(null, "Error:"+e.getMessage());
            createChessBoard();
            return;
        }
        
        // Create the main frame
        mainFrame = new JFrame("Knights Tour");
        
        // Content panel to hold the chessboard and optionsPanel to hold option buttons
        JPanel content = new JPanel();
        JPanel optionsPanel = new JPanel();
        
        // Button to reset the board to solve the Knights Tour Problem again
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Function to reset the chessboard
                clearEnableButtons();
            }
        });
        
        // Button to create a new board
        JButton reset_board = new JButton("New Board");
        reset_board.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose this frame and create a new board
                mainFrame.dispose();
                createChessBoard();
            }
        });
        
        // Add the reset and reset_board buttons to the options panel
        optionsPanel.add(reset);
        optionsPanel.add(reset_board);
        
        // Create a grid layout to place the buttons of the chessboard
        JPanel board = new JPanel(new GridLayout(boardSize,boardSize));
        // Set the layout absolute
        board.setLayout(null);
        // Set the default size of the chessboard
        board.setPreferredSize(new Dimension((boardSize * BUTTON_SPACE), (boardSize * BUTTON_SPACE)));
        
        JButton b;
        // Create the buttons list
        boardButtonsList = new JButton[boardSize][boardSize];
        for (int x = 0; x < boardSize; x++){
            for (int y = 0; y < boardSize; y++){
                // Create a new button
                b = new JButton();
                // Set the size and coordinates of the buttons
                b.setBounds((x*BUTTON_DIMEN), (y*BUTTON_DIMEN), BUTTON_DIMEN, BUTTON_DIMEN);
                if ((x+y)%2 == 0){
                    // Colour the button BLACK
                    b.setBackground(Color.black);
                }else{
                    // Colour the button WHITE
                    b.setBackground(Color.white);
                }
                // Action Listener for each button
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evnt) {
                        Rectangle dim = ((JButton)evnt.getSource()).getBounds();
                        // Perform action on click
                        onButtonClickAction(dim);
                    }
                });
                
                // Add the created button to the board
                board.add(b);
                // Add the button to button list for later reference
                boardButtonsList[x][y] = b;
            }
        }
        
        // Add the board to content layout
        content.add(board);
        
        // Split pane to divide the frame into two parts
        JSplitPane boardPane = new JSplitPane(SwingConstants.HORIZONTAL, content, optionsPanel); 
        // Disable the resize ability of the split frame
        boardPane.setEnabled(false);
        
        // Add the split frame which contains the board and optionsPanel to the Main Frame
        mainFrame.add(boardPane);

        // Set the default close action of the frame
        // Stop the program on frame cllose
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the main frame
        mainFrame.setSize(((boardSize * BUTTON_SPACE) + FRAME_PADDING),((boardSize * BUTTON_SPACE) + FRAME_PADDING));
        
        // Set the main frame visible
        mainFrame.setVisible(true);
    }
    
    // Solve Knigts tour problem on button click
    public void onButtonClickAction(Rectangle dim){
        findPossibleMoves(boardSize, (int)(dim.x/BUTTON_DIMEN), (int)(dim.y/BUTTON_DIMEN));
    }
    
    // Function to clear text on buttons and enable them again for click event
    public void clearEnableButtons(){
        for (int x = 0; x < boardSize ; x++){
            for (int y = 0; y < boardSize; y++){
                // Clear text on buttons
                boardButtonsList[x][y].setText("");
                boardButtonsList[x][y].setEnabled(true);
            }
        }
    }
    
    // Function to disable the buttons on chess board after solving Knights Tour
    public void disableButtons(){
        for (int x = 0; x < boardSize ; x++){
            for (int y = 0; y < boardSize; y++){
                boardButtonsList[x][y].setEnabled(false);       
            }
        }
    }
    
    // Function to Solve Knights Tour Problem
    public boolean findPossibleMoves(int boardSize, int posX, int posY){ 
        
        // 2 Dimensional Array to store the solution of Knights Tour Problem
        int[][] solution = new int[boardSize][boardSize]; 
        
        // Initilaising the solution array to -1
        // -1 states that the square is not occupied
        for (int x = 0; x < boardSize; x++){
            for (int y = 0; y < boardSize; y++){
                solution[x][y] = -1;
            }
        }
                
        // Define the movement of the knight
        // xMovement defines the x coordinate of the move
        // yMovement defines the y coordinate of the move
        int xMovement[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMovement[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
  
        
        // Initially the knight is at the clicked square
        // posX, posY is the grid coordinate of the clicked square
        solution[posX][posY] = 0;
  
        // Check if the knights tour has a solution
        if (solveKnightTour(posX, posY, 1, solution, xMovement, yMovement)) {
            // Display solution if solution exists
            displaySolution(solution);
            // Disable buttons adter execution
            disableButtons();
        }else{
            // Show message that there is no solution
            showMessageDialog(null, "No Solution");
            return false;
        }
        return true; 
    }
    
    // Function to solve Knights Tour Problem
    public boolean solveKnightTour(int posX, int posY, int moveNum, int[][] solution, int xMovement[], int yMovement[]){ 
        
        // Return true if all the squares have been explored
        if (moveNum == (boardSize * boardSize)){
            return true;
        }
        
        // Next movement coordinates
        int nextPosX, nextPosY;
        
        // Check all possible moves from the current position
        // Maximum possible moves from a certain position is 8
        for (int k = 0; k < 8; k++){
            nextPosX = posX + xMovement[k]; 
            nextPosY = posY + yMovement[k];
            // If the next possible move is possible make it solution
            if (isSquareValid(nextPosX, nextPosY, solution)) { 
                // Assign the move number to the sqaure
                solution[nextPosX][nextPosY] = moveNum;
                // Check further solution
                if (solveKnightTour(nextPosX, nextPosY, (moveNum + 1), solution, xMovement, yMovement))
                    // Possible move
                    return true;
                else{
                    // If the further solution is not possible then backtrack
                    // -1 to make free the square and backtrack
                    solution[nextPosX][nextPosY] = -1;
                }
            } 
        } 
        // Return false if no solution is found
        return false;
    }
    
    // Function to check if the next square is valid
    // Check if next position square is unoccupied and within the chessboard
    public boolean isSquareValid(int posX, int posY, int[][] sol) { 
        return ((posX >= 0) && (posY >= 0) && (posX < boardSize) && (posY < boardSize) && (sol[posX][posY] == -1));
    }
    
    // Display the solution on the buttons
    public void displaySolution(int[][] solution){
        for (int x = 0; x < boardSize ; x++){
            for (int y = 0; y < boardSize; y++){
                // Set the output on the buttons
                boardButtonsList[x][y].setText(Integer.toString(solution[x][y]+1));
            }
        }
    }
       
    // Main function for this class
    public static void main(String[] args){
        // Create an instance of this class
        Problem3 knight = new Problem3();
        // Entry point to the program
        knight.createChessBoard();
    }
    
}