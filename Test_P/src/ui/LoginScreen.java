package ui;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen {
	
	public LoginScreen(UImanager uiManager) {
        super(uiManager);
        this.uiManager = uiManager;
    }
	
	@Override
	public JPanel getPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelId = new JLabel("사용자 ID:");
        JTextField tfId = new JTextField(15);

        JLabel labelPw = new JLabel("비밀번호:");
        JPasswordField pfPw = new JPasswordField(15);

        JButton btnLogin = new JButton("로그인");

        btnLogin.addActionListener(e -> {
            String id = tfId.getText().trim();
            String pw = new String(pfPw.getPassword());

            if (id.isEmpty() || pw.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "ID와 비밀번호를 입력하세요.");
                return;
            }
            JOptionPane.showMessageDialog(panel, id + "님, 환영합니다!");
            uiManager.openPopup(PopupType.LOGIN);
            uiManager.pushScreen(new PlantSelectionScreen(uiManager));
        });

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(labelId, gbc);
        gbc.gridx = 1;
        panel.add(tfId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(labelPw, gbc);
        gbc.gridx = 1;
        panel.add(pfPw, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        return panel;
    }

}
