package ui;

import javax.swing.*;
import java.awt.*;

public abstract class AuthScreen extends Screen {
	
	protected JTextField tfId;
    protected JPasswordField pfPw;
	
    public AuthScreen(UImanager uiManager) {
    	super(uiManager);
    }
    
	@Override
	public JPanel getPanel() {
		JPanel panel = new BackGroundPanel("/images/bgi.png");
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelTitle = new JLabel(getTitleText(), SwingConstants.CENTER);
        labelTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        labelTitle.setForeground(Color.black);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(labelTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("사용자 ID:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        tfId = new JTextField(15);
        panel.add(tfId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(new JLabel("비밀번호:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        pfPw = new JPasswordField(15);
        panel.add(pfPw, gbc);

        JButton btnPrimary = SwingRenderer.createStyledButton(getPrimaryButtonText(), Color.WHITE, Color.BLACK);
        JButton btnSecondary = SwingRenderer.createStyledButton(getSecondaryButtonText(), Color.WHITE, Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(btnSecondary, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(btnPrimary, gbc);

        btnPrimary.addActionListener(e -> onPrimaryButtonClicked());
        btnSecondary.addActionListener(e -> onSecondaryButtonClicked());

        return panel;
	}
	
	 	protected abstract String getTitleText();

	    // 메인 버튼 텍스트 (로그인, 회원가입 등)
	    protected abstract String getPrimaryButtonText();

	    // 보조 버튼 텍스트 (회원가입, 뒤로가기 등)
	    protected abstract String getSecondaryButtonText();

	    // 메인 버튼 클릭 시 행동
	    protected abstract void onPrimaryButtonClicked();

	    // 보조 버튼 클릭 시 행동
	    protected abstract void onSecondaryButtonClicked();

}
