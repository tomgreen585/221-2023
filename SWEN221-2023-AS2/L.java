package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class L extends J{
  public L(int x, int y, Color color) {
	  
	  super(x, y, color);
    //throw new Error();
	  
  }
  
  @Override
  public int xOffset(int i) {
      if (orientation == 0) {
          if (i == 0) return 1;
          if (i == 1) return 0;
          if (i == 2) return -1;
          if (i == 3) return -1;
      }
      if (orientation == 1) {
          if (i == 0) return 0;
          if (i == 1) return 0;
          if (i == 2) return 0;
          if (i == 3) return -1;
      }
      if (orientation == 2) {
          if (i == 0) return -1;
          if (i == 1) return 0;
          if (i == 2) return 1;
          if (i == 3) return 1;
      }
      if (orientation == 3) {
          if (i == 0) return 0;
          if (i == 1) return 0;
          if (i == 2) return 0;
          if (i == 3) return 1;
      }
      return 0;
  }
  
  @Override
  public int yOffset(int i) {
      if (orientation == 0) { //put
          if (i == 0) return 0;
          if (i == 1) return 0;
          if (i == 2) return 0;
          if (i == 3) return -1;
      }
      if (orientation == 1) { //t3
          if (i == 0) return -1;
          if (i == 1) return 0;
          if (i == 2) return 1;
          if (i == 3) return 1;
      }
      if (orientation == 2) { //t2
          if (i == 0) return 0;
          if (i == 1) return 0;
          if (i == 2) return 0;
          if (i == 3) return 1;
      }
      if (orientation == 3) { //rotate
          if (i == 0) return 1;
          if (i == 1) return 0;
          if (i == 2) return -1;
          if (i == 3) return -1;
      }
      return 0;
  }
  
}
