package lesson7.HW;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends JFrame { //Окно настроек игры

    private static final int WINDOW_WIDTH = 350; // высота окна
    private static final int WINDOW_HEIGHT = 270; // ширина окна

    private static final int MIN_WIN_LENGTH = 3; // минимальня победная серия
    private static final int MIN_FIELD_SIZE = 3; // минимальный размер поля
    private static final int MAX_FIELD_SIZE = 10; // максмальный размер поля
    private static final String FIELD_SIZE_PREFIX = "Размер поля ";
    private static final String WIN_LENGTH_PREFIX = "Серия побед ";

    private MainWindow mainWindow;
    private JRadioButton humVsAI; // кнопка (батн) для выбора режима человек против компа
    private JRadioButton humVsHum;// кнопка (батн) для выбора режима человек против человека
    private JSlider slideWinLen; // слайдер для выбора победной серии
    private JSlider slideFieldSize; // слайдер для выбора размера поля

    Setting(MainWindow mainWindow) { //Даём понять что окну настроек что он находится в окне Мэйн
        this.mainWindow = mainWindow;  // ?????????
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); //Размер окна
        Rectangle gameWindowBounds = mainWindow.getBounds(); // наше окно прямоугольник,создаём его и в него передаем все данные с нашего окна
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2; // узнаем центр окна по высоте
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2; // узнаем центр окна по ширине
        setLocation(posX, posY); // устанавливаем окно настроек по этим координатам
        setResizable(false); // запрещаем юзеру изменять размер
        setTitle("Настройки игры"); // название окна настроек
        setLayout(new GridLayout(10, 1)); // устанавливаем табличный компановщик для выбора настроек игры(10 строк 1 столбик)

        addGameModeSetup(); // добавляем метод для выбора режима игры
        addFieldMapControl(); // добавляем метод для контроля размера карты

        JButton btnPlay = new JButton("Начать игру!!"); // Кнопка для начала игры!

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayGameClick(); // метод для начала игры!
            }
        });

        add(btnPlay); //кнопка в настройках для начала игры

        setVisible(false); // указываем чтобы окно настроек не открывалось при старте программы(тк мы указали действие мыши в главном окне)
    }

    private void addGameModeSetup() { // метод для режима игры
        add(new JLabel("Выбери режим игры: ")); // устанавливаем лейбл для режима игры

        humVsAI = new JRadioButton("Человек против компьютера", true); // создаем кнопку выбора режима ЧпК (добавили тру чтобы выбирать игру ЧпК по умолчанию)
        humVsHum = new JRadioButton("Человек против человека"); // создаём копку высбора режима ЧпЧ
        ButtonGroup gameMode = new ButtonGroup(); // добавляем группу для баттонов,чтобы они понимали что работают друг с другом
        gameMode.add(humVsAI); // добавляем В группу ЧпК
        gameMode.add(humVsHum); // добавляем В грппу ЧпЧ
        add(humVsAI); // добавляем на панель нашу созданную кнопку ЧпК
        add(humVsHum); // добавляем на панель нашу созданную кнопку ЧпЧ


    }

    private void addFieldMapControl() { // метод для выбора размера карты
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE); // создаём лейбл с размерами
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH); // создаём лейбл с победной серией

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE); // создаём слайдер для выбора размера поля игры.указываем разбег и значение по умолчанию
        slideFieldSize.addChangeListener(new ChangeListener() {    // добавляем событие для слайдера
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue(); // переменная текущего значения у слайдера
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue); //изменяем текст нашего лейбла
                slideWinLen.setMaximum(currentValue); // уменьшает победную серию в зависимости от размера поля

            }
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE); // создаём слайдер для выбора размера победной серии
        slideWinLen.addChangeListener(new ChangeListener() {  // добавляем событие для слайдера
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue()); // изменяем текст нашего лейбла используя положение нашего ползунка
            }
        });

        add(new JLabel("Выберите размер игрового поля ")); // лейбл для интерактивности размеров поля
        add(lbFieldSize); // добавляем в окно  лейбл размеров поля
        add(slideFieldSize); // добавляем слайдер размера поля в окно
        add(new JLabel("Выберите размер победной серии ")); // лейбл для интрективности победной серии
        add(lbWinLength); // добавляем в окно лейбл с размером победной серии
        add(slideWinLen); // добавляем слайдер размера победной серии в окно


    }

    private void btnPlayGameClick() {
        int gameMode;

        if (humVsAI.isSelected()) { // если выбран режим ЧпК
            gameMode = GameMap.MODE_HVA; // вытаскиваем из класса ГеймМап значение ЧпК
        } else if (humVsHum.isSelected()) { // если выбран режим ЧпЧ
            gameMode = GameMap.MODE_HVH; // вытаскиваем из класса ГеймМап значени ЧпЧ
        } else {
            throw new RuntimeException("Неизвестный игровой режим!"); // подсказка на будущее для разработки,для добавления новых режимов
        }

        int fieldSize = slideFieldSize.getValue(); // забираем информацию о размере поля с помощью геттера из слайдера в настройках игры
        int winLength = slideWinLen.getValue();// забираем значени с помощью геттера из слайдера о размере победной серии

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
    }
}
