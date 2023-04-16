package org.example;

public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return !((line == toLine) && (column == toColumn))
                &&((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && ((toColumn==column) || (toLine==line));
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
