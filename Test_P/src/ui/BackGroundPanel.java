package ui;

import javax.swing.*;
import java.awt.*;

public class BackGroundPanel extends JPanel {
	private Image backgroundImage;
	
	public BackGroundPanel(String imagePath) {
		this.backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 이미지 크기를 패널에 맞춰서 그리기
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
