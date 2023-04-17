package org.example;

/**
 * Класс, описывающий ферзя
 * @autor Евгений Лещенко
 * @version 0.0.2
 */
public class Queen extends ChessPiece{

    /**
     * Конструктор класса
     * @param color - цвет фигуры
     */
    public Queen(String color) {
        super(color);
    }

    /**
     * Метод - вернуть цвет фигуры
     * @return цвет фигуры
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * метод, определяющий, может ли фигура перемещаться в указанное место доски
     * Если ферзь двигается по диагонали и не падает с доски, ячейка назначения пуста, на его пути нет своих фигур,
     * ферзь вообще присутствует - выдает true, иначе false
     * @param chessBoard - объект (доска)
     * @param line - позиция старта (строка)
     * @param column - позиция старта (колонка)
     * @param toLine - позиция перемещения (строка)
     * @param toColumn - позиция перемещения (колонка)
     * @return может ли фигура перемещаться в указанное место доски
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn &&
                Math.max(line, toLine) - Math.min(line, toLine) == Math.max(column, toColumn) - Math.min(column, toColumn) &&
                checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }
            if ((column == Math.min(column, toColumn) && line == Math.max(line, toLine)) ||
                    (toColumn == Math.min(column, toColumn) && toLine == Math.max(line, toLine))) {
                int fromL = Math.max(line, toLine);
                int fromC = Math.min(column, toColumn);
                int toL = Math.min(line, toLine);
                int toC = Math.max(column, toColumn);
                int[][] positions = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++) {
                    if (chessBoard.board[fromL + i][fromC + i] == null) {
                        positions[i - 1] = new int[]{fromC + i, fromC + i};
                    } else if (!chessBoard.board[fromL + i][fromC + i].color.equals(this.color) && fromL + i == toLine) {
                        positions[i - 1] = new int[]{fromL + i, fromC + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
            else {
                int fromL = Math.min(line, toColumn);
                int fromC = Math.max(column, toColumn);
                int toL = Math.max(line, toLine);
                int toC = Math.max(column, toColumn);
                int[][] positions = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++){
                    if (chessBoard.board[fromL + i][fromC + i] == null) {
                        positions[i - 1] = new int[] {fromL + i, fromC + i};
                    } else if (!chessBoard.board[fromL + i][fromC + i].color.equals(this.color) && fromL + i == toLine) {
                        positions[i - 1] = new int[]{fromL + i, fromC + i};
                    } else return false;
                }
                return true;
            }
        } else if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            if (column == toColumn) {
                for (int i = Math.min(line, toLine); i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        if (chessBoard.board[i][column] == this && i == Math.max(line, toLine)) return false;
                        else if (chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return false;
                        else if (!chessBoard.board[i][column].getColor().equals(this.color) && i == toLine)
                            return true;
                        else if (i != toLine && i != line) return false;
                    }
                }

                if (chessBoard.board[toLine][column] != null) {
                    if (chessBoard.board[toLine][column].getColor().equals(this.color) && chessBoard.board[toLine][column] != this)
                        return false;
                    else return true;
                } else return true;
            } else if (line == toLine) {
                for (int i = Math.min(toColumn, column); i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        if (chessBoard.board[line][i] == this && i == Math.max(column, toColumn)) return false;
                        else if (chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return false;
                        else if (!chessBoard.board[line][i].getColor().equals(this.color) && i == toColumn)
                            return true;
                        else if (i != toLine && i != column) return false;
                    }
                }

                if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.color) || chessBoard.board[toLine][toColumn] == this;
                } else return true;
            } else return false;
        } else return false;
    }
    /**
     * метод, возвращающий букву фигуры
     * @return в нашем случае Q - Ферзь
     */
    @Override
    public String getSymbol() {
        return "Q";
    }

    /**
     * Метод-проверка на вываливание с доски
     * @param pos - куда перемещается фигура
     * @return проверка на вываливание с доски
     */
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
