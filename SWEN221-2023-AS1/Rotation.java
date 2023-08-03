// This program is copyright VUW.

// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;

import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	/**
	 * Location of cell which is to be rotated.
	 */
	private final Location location;
	/**
	 * Number of steps to rotate (in a clockwise direction) where each step is a
	 * 90degree rotation.
	 */
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc   Location of cell to be rotated.
	 * @param steps Number of rotations to apply.
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param board Board where rotation is being applied.
	 */
	@Override
	public void apply(Board board) {
		// FIXME: need to do something here!

		Cell c = board.getCellAt(location);
		if (c != null) {
			int w = c.getWidth();
			int[] i = c.getImage();
			int[][] c2D = con2D(i,w); //1d to 2d
			int[][] r2D = rot2D(c2D,w,steps); //rotate 2d 
			int[] c1D = con1D(r2D,w); //2d to 1d
			board.setCellAt(location,new Cell(c1D,w)); //updates cell
		}
}

	public int[] con1D (int[][] array2d, int width) {
			int c = 0;
			int [] compArray = new int[width*width];
			for (int i = 0; i < width; i++) {
				for (int y = 0; y < width; y++) {
					compArray[c] = array2d[i][y];
					c++;
				}
			}
			return compArray;
	}

	public int [][] con2D (int[] Array, int width){
			int[][] nArray = new int[width][width];
			int c = 0;
			for (int i = 0; i < width; i++) {
				for (int y = 0; y < width; y++){
					nArray[i][y] = Array[c];
					c++;
				}
			}
			return nArray;
	}

	public int[][] rot2D (int[][] cell2D, int width, int steps){

		for (int x = 0; x < steps; x++) {
			for (int i = 0; i < width; i++) {
				for (int y = i; y < width; y++) {
					int t = cell2D[i][y];
					cell2D[i][y] = cell2D[y][i];
					cell2D[y][i] = t;
				}
			}
		for (int i = 0; i < width; i++) {
			for (int y = 0; y <width/2; y++) {
				int t = cell2D[i][y];
				cell2D[i][y] = cell2D[i][width-y-1];
				cell2D[i][width-y-1] = t;
			}
		}
		}
		return cell2D;
	}

}
