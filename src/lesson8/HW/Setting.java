package lesson8.HW;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Setting extends JFrame {

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля : ";
    private static final String WIN_LENGTH_PREFIX = "Победная серия : ";

    private MainWindow mainWindow;

    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;


    Setting(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Настройки новой игры!");
        setLayout(new GridLayout(10, 1));

        addGameModeSetup();
        addFieldMapControl();

        JButton btnPlay = new JButton("Начать игру!");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayGameClick();
            }
        });

        add(btnPlay);
        setVisible(false);

    }

    private void addGameModeSetup() {
        add(new JLabel("Выберите режим Игры"));
        humVSAI = new JRadioButton("Человек против Компьютера", true);
        humVSHum = new JRadioButton("Человек против Человека");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVSHum);
        add(humVSAI);
        add(humVSHum);
    }

    private void addFieldMapControl() {
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });

        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(new JLabel("Выберите размер поля"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Выберите победную серию"));
        add(lbWinLength);
        add(slideWinLen);
    }

    private void btnPlayGameClick() {
        int gameMode;

        if (humVSAI.isSelected()) {
            gameMode = GameMap.MODE_HVA;
        } else if (humVSHum.isSelected()) {
            gameMode = GameMap.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();

        mainWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);

        setVisible(false);

    }
}
