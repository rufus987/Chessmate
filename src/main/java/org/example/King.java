package org.example;

/**
 * Класс, описывающий короля
 * @autor Евгений Лещенко
 * @version 0.0.2
 */
public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) &&checkPos(toColumn)){
            if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;

            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;

            if (chessBoard.board[toLine][toColumn] != null){
                return  !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }

            return true;
        }return false;
    }
    @Override
    public String getSymbol() {
        return "K";
    }

    /**
     * Метод, проверяющий короля на шах
     * @param chessBoard - объект доски
     * @param line - позиция короля по горизонтали
     * @param column - позиция короля по вертикали
     * @return - возвращает шах(?)
     */
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
        if (checkPos(line) && checkPos(column)){
            for (int i = 0; i < 7; i++){
                 for (int j = 0; j < 7; j++){
                     if (chessBoard.board[i][j] != null) {
                         if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                             return true;
                         }
                     }
                 }
            }
        }
        return false;
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
