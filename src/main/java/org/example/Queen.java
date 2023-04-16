package org.example;

public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
        && ((toColumn==column) || (toLine==line) || (Math.abs(line - toLine) == Math.abs(column - toColumn)))
                && !((line == toLine) && (column == toColumn));
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
