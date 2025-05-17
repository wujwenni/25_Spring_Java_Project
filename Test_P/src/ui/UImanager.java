package ui;

import javax.swing.*;
import java.util.Stack;

public class UImanager {
	private Renderer renderer;
    private Stack<Screen> screenStack;

    public UImanager() {
        this.renderer = new SwingRenderer(this);
        this.screenStack = new Stack<>();
        this.renderer.initialize();
    }

    public void start() {
        pushScreen(new LoginScreen(this));
    }

    public void pushScreen(Screen screen) {
        screenStack.push(screen);
        renderer.draw(screen.getPanel());
    }

    public void popScreen() {
        if (!screenStack.isEmpty()) {
            screenStack.pop();
            if (!screenStack.isEmpty()) {
                renderer.draw(screenStack.peek().getPanel());
            }
        }
    }
    
    public boolean openPopup(PopupType type) {
        int result;
        switch (type) {
            case MINIGAME:
                result = JOptionPane.showConfirmDialog(
                    renderer.getFrame(),
                    "미니게임을 시작할까요?",
                    "미니게임 시작",
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "미니게임 시작!");
                    return true;
                    // TODO: 미니게임 화면으로 전환하는 코드 작성
                } else {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "미니게임 시작을 취소했습니다.");
                    return false;
                }
                

            case ALERT:
                result = JOptionPane.showConfirmDialog(
                    renderer.getFrame(),
                    "알림을 확인했습니까?",
                    "알림",
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    // 알림 확인 후 처리
                    JOptionPane.showMessageDialog(renderer.getFrame(), "알림을 확인했습니다.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "알림 확인이 취소되었습니다.");
                    return false;
                }
                

            case LOGIN:
                result = JOptionPane.showConfirmDialog(
                    renderer.getFrame(),
                    "로그인 하시겠습니까?",
                    "로그인",
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    // 로그인 처리
                    JOptionPane.showMessageDialog(renderer.getFrame(), "로그인 진행 중...");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "로그인이 취소되었습니다.");
                    return false;
                }
                

            case PLANT_SELECTION:
                result = JOptionPane.showConfirmDialog(
                    renderer.getFrame(),
                    "식물을 선택하시겠습니까?",
                    "식물 선택",
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "식물 선택 완료!");
                    return true;
                    // TODO: 식물 선택 후 처리
                } else {
                    JOptionPane.showMessageDialog(renderer.getFrame(), "식물 선택을 취소했습니다.");
                    return false;
                }
                

            case EXIT:
                result = JOptionPane.showConfirmDialog(
                    renderer.getFrame(),
                    "종료하시겠습니까? 저장하시겠습니까?",
                    "프로그램 종료",
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    // 저장 후 종료
                    JOptionPane.showMessageDialog(renderer.getFrame(), "저장 후 종료합니다.");
                    System.exit(0);
                } 
                else {
                    // 취소 - 아무 작업 안 함
                    JOptionPane.showMessageDialog(renderer.getFrame(), "종료가 취소되었습니다.");
                }
                break;

            default:
                JOptionPane.showMessageDialog(renderer.getFrame(), "알 수 없는 팝업 유형입니다.");
                return false;
        }
        return false;
    }


}
