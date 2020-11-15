package lesson8.HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POSX = 650;
    private static final int WINDOW_POSY = 270;

    private Setting settingWindow;
    private GameMap gameMap;
    

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle("Игра: Крестики-нолики");

        settingWindow = new Setting(this);
        gameMap = new GameMap();

        JButton btnStart = new JButton("Создать новую игру");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow.setVisible(true);
            }
        });

        JButton btnExitGame = new JButton("Закрыть");
        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExitGame);

        add(panelBottom, BorderLayout.SOUTH);
        add(gameMap);

        setResizable(false);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}