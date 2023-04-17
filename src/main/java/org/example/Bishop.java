package org.example;

/**
 * Класс, описывающий слона
 * @autor Евгений Лещенко
 * @version 0.0.1
 */
public class Bishop extends ChessPiece {
    /**
     * Конструктор класса
     * @param color - цвет фигуры
     */
    public Bishop(String color) {
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
     * Если слон походил по диагонали и не выпал с доски - возвращет true
     * иначе - false
     * @param chessBoard - объект (доска)
     * @param line - позиция старта (строка)
     * @param column - позиция старта (колонка)
     * @param toLine - позиция перемещения (строка)
     * @param toColumn - позиция перемещения (колонка)
     * @return может ли фигура перемещаться в указанное место доски
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return line != toLine
                && ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && (Math.abs(line - toLine) == Math.abs(column - toColumn));
    }
    /**
     * метод, возвращающий букву фигуры
     * @return в нашем случае B - слон
     */
    @Override
    public String getSymbol() {
        return "B";
    }
}
