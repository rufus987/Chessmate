package org.example;

public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && (((Math.max(line, toLine) - Math.min(line, toLine) == 2) &&
                (Math.max(column, toColumn) - Math.min(column, toColumn) == 1))
                || (((Math.max(line, toLine) - Math.min(line, toLine) == 1) &&
                (Math.max(column, toColumn) - Math.min(column, toColumn) == 2))));
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
