package org.example;

/**
 * Класс, описывающий ладью
 * @autor Евгений Лещенко
 * @version 0.0.1
 */
public class Rook extends ChessPiece{
    /**
     * Конструктор класса
     * @param color - поле цвета фигуры
     */
    public Rook(String color) {
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
     * Если фигура сдвинулась, не выпала с доски, походила строго по горизонтали или вертикали -
     * возвращает true
     * иначе возращает false - движение невозможно
     * @param chessBoard - объект (доска)
     * @param line - позиция старта (строка)
     * @param column - позиция старта (колонка)
     * @param toLine - позиция перемещения (строка)
     * @param toColumn - позиция перемещения (колонка)
     * @return может ли фигура перемещаться в указанное место доски
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return !((line == toLine) && (column == toColumn))
                &&((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && ((toColumn==column) || (toLine==line));
    }

    /**
     * метод, возвращающий букву фигуры
     * @return в нашем случае R - Ладья
     */
    @Override
    public String getSymbol() {
        return "R";
    }
}
