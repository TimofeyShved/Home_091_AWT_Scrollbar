package com.AWT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main() { // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args) {
        Main myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showScrollbarDemo(); // и вызываемый метод showScrollbarDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Scrollbar");  // инициализация фрэйма
        mainFrame.setSize(400, 400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent) { // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350, 100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в showScrollbarDemo
    private void showScrollbarDemo(){
        headerLabel.setText("Контрол в действии: Scrollbar");

        // прокрутка - создание
        final Scrollbar horizontalScroller = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 300);
        final Scrollbar verticalScroller = new Scrollbar();
        verticalScroller.setOrientation(Scrollbar.VERTICAL);

        horizontalScroller.setMaximum (100); // максимум значение
        horizontalScroller.setMinimum (1);// минимум
        verticalScroller.setMaximum (100);
        verticalScroller.setMinimum (1);

        horizontalScroller.setMinimumSize(new Dimension(1000,1000)); // размеры (Т.Т)
        horizontalScroller.setMaximumSize(new Dimension(1000,1000));
        horizontalScroller.setSize(1000,1000);
        horizontalScroller.revalidate();

        // ------------------------ действие при прокурутки Scrollbar
        horizontalScroller.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) { // изменение значений
                statusLabel.setText("Горизонтальное: "
                        +horizontalScroller.getValue() // вывод значения
                        +" ,Вертикальное: "
                        + verticalScroller.getValue());
            }
        });

        verticalScroller.addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) { // изменение значений
                statusLabel.setText("Горизонтальное: "
                        +horizontalScroller.getValue() // вывод значения
                        +" ,Вертикальное: "
                        + verticalScroller.getValue());
            }
        });

        // добавление объектов на форму
        controlPanel.add(horizontalScroller);
        controlPanel.add(verticalScroller);

        // видимость формы true
        mainFrame.setVisible(true);
    }
}