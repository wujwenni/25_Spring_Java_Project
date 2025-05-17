package ui;

import java.awt.*;
import javax.swing.*;
import model.User;

public class SignInScreen extends AuthScreen {

	private final User userManager;
	
	public SignInScreen(UImanager uiManager) {
        super(uiManager);
        this.userManager = User.getInstance(); 
    }

	@Override
	protected String getTitleText() {
		// TODO Auto-generated method stub
		return "Your Green Friend Awaits - register";
	}

	@Override
	protected String getPrimaryButtonText() {
		// TODO Auto-generated method stub
		return "회원가입";
	}

	@Override
	protected String getSecondaryButtonText() {
		// TODO Auto-generated method stub
		return "뒤로가기";
	}

	@Override
	protected void onPrimaryButtonClicked() {
		// TODO Auto-generated method stub
		String id = tfId.getText().trim();
        String pw = new String(pfPw.getPassword());

        if (id.isEmpty() || pw.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID와 비밀번호를 모두 입력하세요.");
            return;
        }

        if (userManager.userExists(id)) {
            JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
            return;
        }

        if (userManager.register(id, pw)) {
            manager.Savemanager.saveUsersToFile();
            JOptionPane.showMessageDialog(null, "회원가입 성공! 이제 로그인할 수 있습니다.");
            uiManager.popScreen();
        } else {
            JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
        }
	}

	@Override
	protected void onSecondaryButtonClicked() {
		// TODO Auto-generated method stub
		uiManager.popScreen();
	}
	
	

}
