package org.example;

/**
 * Класс, описывающий пешку
 * @autor Евгений Лещенко
 * @version 0.0.1
 */
public class Pawn extends ChessPiece{
    /**
     * Конструктор класса
     * @param color - цвет фигуры
     */
    public Pawn(String color) {
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
     * Если белая пешка походила на 2 клетки (первый ход) или на одну вперед, или аналогично сделала черная
     * пешка - возвращаем true, иначе - false.
     * @param chessBoard - объект (доска)
     * @param line - позиция старта (строка)
     * @param column - позиция старта (колонка)
     * @param toLine - позиция перемещения (строка)
     * @param toColumn - позиция перемещения (колонка)
     * @return может ли фигура перемещаться в указанное место доски
     */
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (color.equals("White") && (column == toColumn) && (line == 1) && (toLine-line == 2)){
            return true;
        } else if (color.equals("Black") && (line == 6) && (column == toColumn) && (line - toLine == 2)) {
            return true;
        } else if ((column == toColumn) && (toLine-line == 1)
                && color.equals("White")) {
            return true;
        } else return ((column == toColumn) && (line - toLine == 1)
                && color.equals("Black"));
    }
    /**
     * метод, возвращающий букву фигуры
     * @return в нашем случае P - пешка
     */
    @Override
    public String getSymbol() {
        return "P";
    }
}
