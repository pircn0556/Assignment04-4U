/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pircn0556
 */
public class Dalek {

    private int row;
    private int col;
    private boolean hasCrashed;

    //finds what row/col Dalek is on
    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    //see if Dalek has crashed
    public boolean hasCrashed() {
        return hasCrashed;
    }

    //constructor
    public Dalek(int row, int col) {
        this.hasCrashed = false;
        this.row = row;
        this.col = col;
    }

    public void advanceTowards(Doctor doc) {
        if (this.hasCrashed == false) {
            if (doc.getRow() > row) {
                row = row + 1;
            } else if (doc.getRow() < row) {
                row = row - 1;
            }
            if (doc.getCol() > col) {
                col = col + 1;
            } else {
                col = col - 1;
            }
        }
    }

    //if Daleks crash
    public void crash() {
        this.hasCrashed = true;
    }
}