package ui;

import javax.swing.*;

public interface Renderer {
	void initialize();
	void draw(JPanel panel);
	JFrame getFrame();
}
