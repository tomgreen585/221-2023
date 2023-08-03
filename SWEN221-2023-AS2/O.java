package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class O extends Tetromino{
  public O(int x, int y, Color color) {
    
	  super(x, y, color);
    //throw new Error();
    
  } 
  
  //for J
  //? x y
  //0 0 0
  //1 1 0
  //2 2 0
  //3 2 1

  @Override
  public int x(int i) {
   /* x y
    0 0 0
    1 1 0
    2 0 1
    3 1 1*/ 
	  if (i == 0) {return centerX();}
	  if (i == 1) {return centerX() + 1;}
	  if (i == 2) {return centerX();}
	  if (i == 3) {return centerX() + 1;}
	  throw new Error();
	  
  }

  @Override
  public int y(int i) {
    //throw new Error();
	  if (i == 0) {return centerY();}
      if (i == 1) {return centerY();}
      if (i == 2) {return centerY() + 1;}
      if (i == 3) {return centerY() + 1;}
      throw new Error();
	  
  }

  @Override
  public void rotateRight() {
    
  }
 
}
