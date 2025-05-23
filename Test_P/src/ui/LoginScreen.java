package ui;

import javax.swing.*;
import java.awt.*;
import model.User;

public class LoginScreen extends AuthScreen {
	
	private final User userManager;
	
	public LoginScreen(UImanager uiManager) {
        super(uiManager);
        this.userManager = User.getInstance(); 
    }
	
	
	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return "Your Green Friend Awaits - Sign in or register";
	}

	@Override
	protected String getPrimaryButtonText() {
		// TODO Auto-generated method stub
		return "로그인";
	}

	@Override
	protected String getSecondaryButtonText() {
		// TODO Auto-generated method stub
		return "회원 가입";
	}

	@Override
	protected void onPrimaryButtonClicked() {
		// TODO Auto-generated method stub
		String id = tfId.getText().trim();
        String pw = new String(pfPw.getPassword());

        if (id.isEmpty() || pw.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID와 비밀번호를 입력하세요.");
            return;
        }

        if (userManager.login(id, pw)) {
            JOptionPane.showMessageDialog(null, id + "님, 환영합니다!");
            uiManager.pushScreen(new PlantSelectionScreen(uiManager));
        } else {
            JOptionPane.showMessageDialog(null, "ID 또는 비밀번호가 틀렸습니다.");
        }
	}

	@Override
	protected void onSecondaryButtonClicked() {
		// TODO Auto-generated method stub
		uiManager.pushScreen(new SignInScreen(uiManager));
	}

}
