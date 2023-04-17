package org.example;

/**
 * Класс, описывающий коня
 * @autor Евгений Лещенко
 * @version 0.0.1
 */
public class Horse extends ChessPiece{
    /**
     * Конструктор класса
     * @param color - цвет фигуры
     */
    public Horse(String color) {
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
     * Если конь не вывалился с доски и походил буквой Г - возвращет true
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
        return ((0 <= toLine) && (toLine < 8) && (0 <= toColumn) && (toColumn < 8))
                && (((Math.max(line, toLine) - Math.min(line, toLine) == 2) &&
                (Math.max(column, toColumn) - Math.min(column, toColumn) == 1))
                || (((Math.max(line, toLine) - Math.min(line, toLine) == 1) &&
                (Math.max(column, toColumn) - Math.min(column, toColumn) == 2))));
    }

    /**
     * метод, возвращающий букву фигуры
     * @return в нашем случае H - конь
     */
    @Override
    public String getSymbol() {
        return "H";
    }
}
