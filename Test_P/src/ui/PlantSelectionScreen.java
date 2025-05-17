package ui;

import javax.swing.*;
import java.awt.*;

public class PlantSelectionScreen extends Screen {

	public PlantSelectionScreen(UImanager uiManager) {
        super(uiManager);
    }

    @Override
    public JPanel getPanel() {
        
    	BackGroundPanel panel = new BackGroundPanel("/images/bgi.png");
    	panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel label = new JLabel("키울 식물을 선택하세요", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(label);

        JButton btnRose = SwingRenderer.createStyledButton("장미", Color.WHITE, Color.BLACK);
        JButton btnTulip = SwingRenderer.createStyledButton("튤립", Color.WHITE, Color.BLACK);
        JButton btnSunflower = SwingRenderer.createStyledButton("해바라기", Color.WHITE, Color.BLACK);

        btnRose.addActionListener(e -> selectPlant("Rose"));
        btnTulip.addActionListener(e -> selectPlant("Tulip"));
        btnSunflower.addActionListener(e -> selectPlant("Sunflower"));

        panel.add(btnRose);
        panel.add(btnTulip);
        panel.add(btnSunflower);

        return panel;
    }

    private void selectPlant(String plantName) {
        // 실제 식물 객체 생성은 식물 로직 담당자와 연동 예정
        // 여기서는 plantName 문자열만 넘겨서 PlantManagementScreen에서 처리한다고 가정
    	//JOptionPane.showMessageDialog(null, plantName + "을(를) 선택했습니다!");
    	
    	if(uiManager.openPopup(PopupType.PLANT_SELECTION)) {
    		uiManager.pushScreen(new PlantManagementScreen(uiManager, plantName));    		
    	}
    }
}
