package org.example;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return line != toLine
                && ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && (Math.abs(line - toLine) == Math.abs(column - toColumn));
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
