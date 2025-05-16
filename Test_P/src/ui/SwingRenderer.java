package ui;

import javax.swing.*;
import java.awt.*;

public class SwingRenderer implements Renderer {
	
	private JFrame frame;

    @Override
    public void initialize() {
        frame = new JFrame("반려 식물 키우기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void draw(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    @Override
    public JFrame getFrame() {
        return frame;
    }

}
