package lesson8.HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class GameMap extends JPanel {
    private static final Random RANDOM = new Random();

    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_PADDING = 5;

    private int stateGameOver;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private boolean isGameOver;
    private boolean initMap;

    private int[][] field;// переменная поле
    private int fieldSizeX; //размер поля
    private int fieldSizeY; // размер поля
    private int winLength; // длинна выйгрыша
    private int cellWidth;
    private int cellHeight;

    GameMap() {
        setBackground(Color.white);
        addMouseListener(new MouseAdapter() { //метод останавливает действие мышки после клика(увод)(зажали и отпустили)
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e); // говорим нашему окошку что делать при каждом нажатии мышки
            }
        });
        initMap = false;
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeY = fieldSizeY;                    //передали параметры классу
        this.fieldSizeX = fieldSizeX;                    //передали параметры классу
        this.winLength = winLength;                      //передали параметры классу
        this.field = new int[fieldSizeY][fieldSizeX];     //передали параметры классу
        isGameOver = false;
        initMap = true;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) { // метод отвечающий за перерисовку окна
        super.paintComponent(g); //вызов конструктора родителя
        render(g); // метод для отрисовки
    }

    private void setGameOver(int gameOverState) {
        isGameOver = true;
        stateGameOver = gameOverState;
        repaint();
    }


    void update(MouseEvent e) {
        if(!initMap){
            return;
        }
        if(isGameOver){
            return;
        }
        int cellX = e.getX() / cellWidth; // узнаём по какой координате пришелся клик / после деления узнаём по какой ячейке
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        field[cellY][cellX] = DOT_HUMAN;
        if (checkWin(DOT_HUMAN)) {
            setGameOver(STATE_WIN_HUMAN);
            return;
        }
        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }
        aiTurn();
        repaint();
        if (checkWin(DOT_AI)) {
            setGameOver(STATE_WIN_AI);
            return;
        }
        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }
    }

    private void render(Graphics g) { // метод для отрисоки игрового поля
        if (!initMap){
            return;
        }
        int width = getWidth(); // узнаем параметры нашей панели
        int height = getHeight(); // узнаем параметры нашей панели
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellHeight;
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) {
                    continue;
                }
                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(new Color(1, 1, 255));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);

                } else if (field[y][x] == DOT_AI) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException(String.format("Невозможно перерисовать [%d][%d]: %d", y, x, field[y][x]));
                }
            }

        }
        if (isGameOver) {
            showMessageGameOver(g);
        }
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.yellow);
        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Неясно кто выйграл" + stateGameOver);
        }

    }

    public void aiTurn() {
        if (turnAIWinCell()) { // проверим, не выиграет-ли игрок на следующем ходу
            return;
        }
        if (turnHumanWinCell()) { // проверим, не выиграет-ли комп на следующем ходу
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_AI;               // поставим нолик в каждую клетку поля по очереди
                    if (checkWin(DOT_AI)) {
                        return true;    // если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    }
                    field[i][j] = DOT_EMPTY;            // если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }

    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = DOT_HUMAN;            // поставим крестик в каждую клетку по очереди
                    if (checkWin(DOT_HUMAN)) {            // если игрок победит
                        field[i][j] = DOT_AI;            // поставить на то место нолик
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;            // в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int labelPlayer) {
        for (int i = 0; i < fieldSizeX; i++) {            // ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, labelPlayer)) {
                    return true;    // проверим линию по х
                }
                if (checkLine(i, j, 1, 1, winLength, labelPlayer)) {
                    return true;    // проверим по диагонали х у
                }
                if (checkLine(i, j, 0, 1, winLength, labelPlayer)) {
                    return true;    // проверим линию по у
                }
                if (checkLine(i, j, 1, -1, winLength, labelPlayer)) {
                    return true;    // проверим по диагонали х -у
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int lablePlayer) {
        final int farX = x + (len - 1) * vx;            // посчитаем конец проверяемой линии
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;    // проверим не выйдет-ли проверяемая линия за пределы поля
        }
        for (int i = 0; i < len; i++) {                    // ползём по проверяемой линии
            if (field[y + i * vy][x + i * vx] != lablePlayer) {
                return false;    // проверим одинаковые-ли символы в ячейках
            }
        }
        return true;
    }

    public boolean isFullMap() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

}
