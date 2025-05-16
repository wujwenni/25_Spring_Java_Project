package ui;

import javax.swing.*;

public abstract class Screen {
	
	protected UImanager uiManager;
	
	public Screen(UImanager uiManager) {
		this.uiManager = uiManager;
	}
	
	public abstract JPanel getPanel();
}
