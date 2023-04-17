/**
 * Класс шахматных фигур.
 * @autor Евгений Лещенко
 * @version 0.0.3
 */

package org.example;

public abstract class ChessPiece {
    /** поле цвет фигуры */
    String color;
    /** поле присутствия фигуры */
    boolean check = true;

    /**
     * Конструктор - создание нового объекта.
     * @param color - цвет фигуры
     */
    public ChessPiece(String color) {
        this.color = color;
    }

    /**
     * Метод - вернуть цвет фигуры
     * @return цвет фигуры
     */
    abstract public String getColor();

    /**
     * метод, определяющий, может ли фигура перемещаться в указанное место доски
     * @param chessBoard - объект (доска)
     * @param line - позиция старта (строка)
     * @param column - позиция старта (колонка)
     * @param toLine - позиция перемещения (строка)
     * @param toColumn - позиция перемещения (колонка)
     * @return возвращает значение, может ли фигура переместиться
     */
    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                              int column, int toLine, int toColumn);
    /** метод, возвращающий букву фигуры */
    abstract public String getSymbol();
}
