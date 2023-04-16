package org.example;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (color.equals("White") && (column == toColumn) && (line == 1) && (toLine-line == 2)){
            return true;
        } else if (color.equals("Black") && (line == 6) && (column == toColumn) && (line - toLine == 2)) {
            return true;
        } else if ((column == toColumn) && (toLine-line == 1)
                && color.equals("White")) {
            return true;
        } else return ((column == toColumn) && (line - toLine == 1)
                && color.equals("Black"));
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
