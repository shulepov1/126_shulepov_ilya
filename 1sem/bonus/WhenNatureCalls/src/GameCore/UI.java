package GameCore;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UI {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, coinLabel, coinNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font pixel;
    Font titlePixel;
    String text;
    int i = 0;

    public void createUI(Game.ChoiceHandler cHandler) {
        try {
            pixel = Font.createFont(Font.TRUETYPE_FONT, new File("NineteenNinetyThree-L1Ay.ttf")).deriveFont(22f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("NineteenNinetyThree-L1Ay.ttf")));

            titlePixel = Font.createFont(Font.TRUETYPE_FONT, new File("NineteenNinetyThree-L1Ay.ttf")).deriveFont(40f);
            GraphicsEnvironment gen = GraphicsEnvironment.getLocalGraphicsEnvironment();
            gen.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("NineteenNinetyThree-L1Ay.ttf")));

        } catch (IOException | FontFormatException e) {

        }
        //WINDOW
        window = new JFrame();
        window.setSize(1000, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        window.setLocation(size.width/2 - window.getWidth()/2, size.height/2 - window.getHeight()/2);


        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 800, 500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("When_Nature_Calls");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titlePixel);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(200, 400, 600, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(pixel);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 150, 800, 550);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 150, 800, 350);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(pixel);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(300, 750, 400, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(pixel);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(pixel);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(pixel);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(pixel);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 800, 100);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(3, 2));
        window.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(pixel);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(pixel);
        hpNumberLabel.setForeground(Color.green);
        playerPanel.add(hpNumberLabel);

        coinLabel = new JLabel("Монет:");
        coinLabel.setFont(pixel);
        coinLabel.setForeground(Color.white);
        playerPanel.add(coinLabel);

        coinNameLabel = new JLabel();
        coinNameLabel.setFont(pixel);
        coinNameLabel.setForeground(Color.yellow);
        playerPanel.add(coinNameLabel);

        weaponLabel = new JLabel("Оружие: ");
        weaponLabel.setFont(pixel);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(pixel);
        weaponNameLabel.setForeground(Color.magenta);
        playerPanel.add(weaponNameLabel);


        window.setVisible(true);

    }
}
