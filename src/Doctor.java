/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pircn0556
 */
public class Doctor {

    private int row;
    private int col;

    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(int newRow, int newCol) {
        int Random = (int) (Math.random() * (12));
        if (newRow == row - 1 || newRow == row + 1 || newCol == col + 1 || newCol == col - 1) {
            row = newRow;
            col = newCol;
        } else if (newRow > row + 1 || newCol > col + 1) {
            row = Random;
            col = Random;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
