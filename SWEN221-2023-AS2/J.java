package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class J extends Tetromino {

    public J(int x, int y, Color color) {
        super(x, y, color);
    }

    int orientation;
    
    @Override
    public int x(int i) {
        if (orientation == 0) {
            if (i == 0) return centerX() + xOffset(i);
            if (i == 1) return centerX() + xOffset(i);
            if (i == 2) return centerX() + xOffset(i);
            if (i == 3) return centerX() + xOffset(i);
        }
        if (orientation == 1) {
            if (i == 0) return centerX() + xOffset(i);
            if (i == 1) return centerX() + xOffset(i);
            if (i == 2) return centerX() + xOffset(i);
            if (i == 3) return centerX() + xOffset(i);
        }
        if (orientation == 2) {
            if (i == 0) return centerX() + xOffset(i);
            if (i == 1) return centerX() + xOffset(i);
            if (i == 2) return centerX() + xOffset(i);
            if (i == 3) return centerX() + xOffset(i);
        }
        if (orientation == 3) {
            if (i == 0) return centerX() + xOffset(i);
            if (i == 1) return centerX() + xOffset(i);
            if (i == 2) return centerX() + xOffset(i);
            if (i == 3) return centerX() + xOffset(i);
        }
        return 0;
    }

   
    @Override
    public int y(int i) {
        if (orientation == 0) {
            if (i == 0) return centerY() + yOffset(i);
            if (i == 1) return centerY() + yOffset(i);
            if (i == 2) return centerY() + yOffset(i);
            if (i == 3) return centerY() + yOffset(i);
        }
        if (orientation == 1) {
            if (i == 0) return centerY() + yOffset(i);
            if (i == 1) return centerY() + yOffset(i);
            if (i == 2) return centerY() + yOffset(i);
            if (i == 3) return centerY() + yOffset(i);
        }
        if (orientation == 2) {
            if (i == 0) return centerY() + yOffset(i);
            if (i == 1) return centerY() + yOffset(i);
            if (i == 2) return centerY() + yOffset(i);
            if (i == 3) return centerY() + yOffset(i);
        }
        if (orientation == 3) {
            if (i == 0) return centerY() + yOffset(i);
            if (i == 1) return centerY() + yOffset(i);
            if (i == 2) return centerY() + yOffset(i);
            if (i == 3) return centerY() + yOffset(i);
        }
        return 0;
    }

    
    public int xOffset(int i) {
        if (orientation == 0) {
            if (i == 0) return -1;
            if (i == 1) return 0;
            if (i == 2) return 1;
            if (i == 3) return 1;
        }
        if (orientation == 1) {
            if (i == 0) return 0;
            if (i == 1) return 0;
            if (i == 2) return 0;
            if (i == 3) return -1;
        }
        if (orientation == 2) {
            if (i == 0) return 1;
            if (i == 1) return 0;
            if (i == 2) return -1;
            if (i == 3) return -1;
        }
        if (orientation == 3) {
            if (i == 0) return 0;
            if (i == 1) return 0;
            if (i == 2) return 0;
            if (i == 3) return 1;
        }
        return 0;
    }

    
    public int yOffset(int i) {
        if (orientation == 0) {
            if (i == 0) return 0;
            if (i == 1) return 0;
            if (i == 2) return 0;
            if (i == 3) return -1;
        }
        if (orientation == 1) {
            if (i == 0) return 1;
            if (i == 1) return 0;
            if (i == 2) return -1;
            if (i == 3) return -1;
        }
        if (orientation == 2) {
            if (i == 0) return 0;
            if (i == 1) return 0;
            if (i == 2) return 0;
            if (i == 3) return 1;
        }
        if (orientation == 3) {
            if (i == 0) return -1;
            if (i == 1) return 0;
            if (i == 2) return 1;
            if (i == 3) return 1;
        }
        return 0;
    }

    @Override
    public void rotateRight() {
        orientation = (orientation + 1) % 4;
    }
}

        
