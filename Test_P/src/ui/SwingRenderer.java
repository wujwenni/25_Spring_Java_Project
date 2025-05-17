package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingRenderer implements Renderer {
	
	private JFrame frame;
	private UImanager uiManager;
	
	public static JButton createStyledButton(String text, Color bg, Color fg) {
		JButton button = new JButton(text);
		button.setBackground(bg);
		button.setOpaque(true);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setForeground(fg);
		return button;
	}
	
	public SwingRenderer(UImanager uiManager) {
        this.uiManager = uiManager;
    }
	
    @Override
    public void initialize() {
        frame = new JFrame("반려 식물 키우기");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 여기서 종료 팝업 띄우기
                uiManager.openPopup(PopupType.EXIT);
            }
        });
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
