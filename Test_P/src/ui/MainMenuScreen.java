package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuScreen extends Screen {

	
	public MainMenuScreen(UImanager uiManager) {
        super(uiManager);
    }

    @Override
    public JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JButton btn1 = new JButton("미니게임 시작");
        JButton btn2 = new JButton("메시지 보기");
        JButton btn3 = new JButton("종료");

        btn1.addActionListener(e -> uiManager.openPopup(PopupType.MINIGAME));
        btn2.addActionListener(e -> uiManager.openPopup(PopupType.ALERT));
        btn3.addActionListener(e -> System.exit(0));

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        return panel;
    }

}
