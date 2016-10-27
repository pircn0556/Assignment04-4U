
import java.awt.Color;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pircn0556
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the game board
        Board board = new Board(12, 12);   

        //create doctor
        Doctor doctor = new Doctor(2, 9);

        //create daleks
        Dalek dalek1 = new Dalek(1, 1);
        Dalek dalek2 = new Dalek(10, 1);
        Dalek dalek3 = new Dalek(1, 10);
  
        //place doctor
        board.putPeg(Color.WHITE, doctor.getRow(), doctor.getCol());
      
        //place daleks
        board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

        //put a message on the board
        board.displayMessage("CLICK THE BOARD TO MOVE.");

        while (true) {
            //get click
            Coordinate c = board.getClick();

            //get row,col of where doctor is
            int row = c.getRow();
            int col = c.getCol();

            //remove the peg of the daleks and doctors old position
            board.removePeg(doctor.getRow(), doctor.getCol());
            board.removePeg(dalek1.getRow(), dalek1.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());

            //move the doctor
            doctor.move(row, col);
            
             //if two daleks crash into each other
            if (dalek1.getRow() == dalek2.getRow() && dalek1.getCol() == dalek2.getCol()) {
                board.putPeg(Color.RED, dalek1.getRow(),dalek1.getCol());
                board.putPeg(Color.RED, dalek2.getRow(),dalek2.getCol());        
                dalek1.crash();
                dalek2.crash();
            }
            if (dalek2.getRow() == dalek3.getRow() && dalek2.getCol() == dalek3.getCol()) {
                board.putPeg(Color.RED, dalek2.getRow(),dalek2.getCol());
                board.putPeg(Color.RED, dalek3.getRow(),dalek3.getCol());
                dalek2.crash();
                dalek3.crash();
            }
            if (dalek1.getRow() == dalek3.getRow() && dalek1.getCol() == dalek3.getCol()) {
                board.putPeg(Color.RED, dalek1.getRow(),dalek1.getCol());
                board.putPeg(Color.RED, dalek3.getRow(),dalek3.getCol());
                dalek1.crash();
                dalek3.crash();
            }

             //if doctor has been captured
            if (dalek1.getRow() == doctor.getRow() && dalek1.getCol() == doctor.getCol()
                    || dalek2.getRow() == doctor.getRow() && dalek2.getCol() == doctor.getCol()
                    || dalek3.getRow() == doctor.getRow() && dalek3.getCol() == doctor.getCol()) {
                board.putPeg(Color.YELLOW, doctor.getRow(), doctor.getCol());
                board.setBackground(Color.RED);
                board.displayMessage("THE DOCTOR HAS BEEN CAPTURED. GAME OVER.");
                break;
            }
            
            //if daleks all crash
            if(dalek1.hasCrashed() && dalek2.hasCrashed() && dalek3.hasCrashed()){
                board.putPeg(Color.GREEN, doctor.getCol(), doctor.getRow());
                board.setBackground(Color.GREEN);
                board.displayMessage("DALEKS HAVE CRASHED. DOCTOR WINS.");
                break;
            }
            
            //move daleks towards doctor
            if (dalek1.hasCrashed() == false) {
                dalek1.advanceTowards(doctor);
            }
            if (dalek2.hasCrashed() == false) {
                dalek2.advanceTowards(doctor);
            }
            if (dalek3.hasCrashed() == false) {
                dalek3.advanceTowards(doctor);
            }          

            //stop daleks from moving if crashed
            if (dalek1.hasCrashed()) {
                board.putPeg(Color.RED, dalek1.getRow(), dalek1.getCol());
            }
            if (dalek2.hasCrashed()) {
                board.putPeg(Color.RED, dalek2.getRow(), dalek2.getCol());
            }
            if (dalek3.hasCrashed()) {
                board.putPeg(Color.RED, dalek3.getRow(), dalek3.getCol());
            }

            //put new peg for doctor
            board.putPeg(Color.WHITE, doctor.getRow(), doctor.getCol());

            //Daleks
            board.putPeg(Color.BLACK, dalek1.getRow(), dalek1.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

        }

    }
}
