package lesson7.HW;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel { // почему наследуем Jpanel????????
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    GameMap() {
        setBackground(Color.black); // указываем цвет карты поля

    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) { //режим игры, размеры поля, количество игроков, победная серия
        // метод для того чтобы понять что должен знать класс карты,для того что бы начать игру
        System.out.println("Режим игры = " + mode +
                "\n Размер поля = " + fieldSizeX +
                "\n Количество игрово = " + fieldSizeY +
                "\n Победная серия = " + winLength);

    }
}
