package org.example;

public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && ((Math.abs(line - toLine) + Math.abs(column - toColumn) == 1)
                || (Math.abs(line - toLine) + Math.abs(column - toColumn) == 2))
                && !((line == toLine) && (column == toColumn));
    }
    @Override
    public String getSymbol() {
        return "K";
    }
}
