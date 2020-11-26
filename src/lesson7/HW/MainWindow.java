package lesson7.HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame { // JFrame позволяет создавать окно
    private static final int WINDOW_WIDTH = 507; // высота окна
    private static final int WINDOW_HEIGHT = 555; // ширина окна
    private static final int WINDOW_POS_X = 650; // ширина от верхнего правого угла идеи
    private static final int WINDOW_POS_Y = 270; // Высота от верхнего правого угла идеи

    private Setting settingWindow;// дали узнать окну Мэйн о том что существует окно Настройки
    private GameMap gameMap; // дали узнать окну Мэйн о то что существует Игровое поле

    MainWindow() {   // конструктор главного окна
        setTitle("Игра:Крестики-Нолики"); // Название шапки окна(тайтл)
        setVisible(true);     // делает окно видимым
        setResizable(false); // Запрещает менять размеры окна

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Метод который принимает в себя высоту и ширину окна
        setLocation(WINDOW_POS_X, WINDOW_POS_Y); //Метод позиции окна на экране,принимает в себя переменные Х.У

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //заставляет кнопку закрытия(Х) работать

        JButton btnStart = new JButton("Старт игры");// Метод который добавляют кнопку "СТАРТ" в наше ОКНО(!)

        btnStart.addActionListener(new ActionListener() { // метод который задаёт своство кнопке и указывает что конкретно она будет делать(событие)
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true); // по нажатию на кнопку Старт игры,открывается окно настроек
            }
        });
        JButton btnClose = new JButton("Закрыть игру"); // Метод который добавляет кнопку "ЗАКРЫТЬ" в наше ОКНО(!)
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // установили для кнопки Закрыть игру,закрытие программы
            }
        });
        //стр 29(аналог) add(btnStart);    // Добавляет кнопку "СТАРТ" на ЭКРАН(!)
        //стр 30(аналог) add(btnClose);   // Добавляет кнопку "ЗАКРЫТЬ" на ЭКРАН(!)

        JPanel panelBottom = new JPanel();// Панель для расположения кнопок
        panelBottom.setLayout(new GridLayout(1, 2)); // setLayout позволняет добавить компановщик размещения,в данном случае это GridLayout(строки \столбцы)
        panelBottom.add(btnStart); // добавляем на панель кнопку старт
        panelBottom.add(btnClose); //добавляем на панель кнопку закрыть

        add(panelBottom, BorderLayout.SOUTH); //добавили панель на ЮГ(вниз) экрана

        settingWindow = new Setting(this); // Добавляем окно настроек в окно Мэйн,с помощью this передаём его,самому себе.Необходимо об этом указать в конструкторе окна Настроек.
        gameMap = new GameMap(); // добавили игровое поле в окно мэйн
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) { // метод для передачи главному окну информацию об игре и ее условиях
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);  //из нашего класса игровое поле достём метод старта игры

    }

}
