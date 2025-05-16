package ui;

import javax.swing.*;
import java.awt.*;

public class PlantManagementScreen extends Screen {

	private String plantName;
    private int growthPercent = 0;
    
    private JLabel growthLabel;
    private JProgressBar growthBar;
    private JLabel moodLabel;
    private JTextArea messageArea;

    public PlantManagementScreen(UImanager uiManager, String plantName) {
        super(uiManager);
        this.plantName = plantName;
    }

    @Override
    public JPanel getPanel() {
    	JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel(plantName + " 관리 화면", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        growthLabel = new JLabel("성장도: " + growthPercent + "%", SwingConstants.CENTER);
        growthBar = new JProgressBar(0, 100);
        growthBar.setValue(growthPercent);
        moodLabel = new JLabel("기분: :) ", SwingConstants.CENTER);
        centerPanel.add(growthLabel);
        centerPanel.add(growthBar);
        centerPanel.add(moodLabel);
        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // 4개 버튼

        JButton btnWater = new JButton("물 주기");
        JButton btnTalk = new JButton("대화하기");
        JButton btnFertilize = new JButton("비료 주기");
        JButton btnMiniGame = new JButton("미니게임 시작");

        btnWater.addActionListener(e -> waterAction());
        btnTalk.addActionListener(e -> talkAction());
        btnFertilize.addActionListener(e -> fertilizeAction());
        btnMiniGame.addActionListener(e -> uiManager.openPopup(PopupType.MINIGAME));  // 팝업 호출

        buttonPanel.add(btnWater);
        buttonPanel.add(btnTalk);
        buttonPanel.add(btnFertilize);
        buttonPanel.add(btnMiniGame);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        messageArea = new JTextArea(4, 20);
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        bottomPanel.add(new JScrollPane(messageArea), BorderLayout.CENTER);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;    }

    // 버튼 눌렀을 때 성장도, 메시지 업데이트 (임시 구현)
    private void waterAction() {
        int inc = 3 + (int)(Math.random() * 3); // 3~5 증가
        updateGrowth(inc);
        addMessage("물을 주었어요! +" + inc + "% 성장");
    }

    private void fertilizeAction() {
        int inc = 3 + (int)(Math.random() * 5); // 3~7 증가
        updateGrowth(inc);
        addMessage("비료를 주었어요! +" + inc + "% 성장");
    }

    private void talkAction() {
        int inc = 1 + (int)(Math.random() * 3); // 1~3 증가
        updateGrowth(inc);

        String[] messages = {
            "반가워~",
            "화이팅!",
            ">_<",
            "반짝반짝 빛나는 하루!",
            "기운내요!",
            "오늘도 잘 부탁해~"
        };
        int idx = (int)(Math.random() * messages.length);
        addMessage("대화했어요: " + messages[idx] + " " + (inc + "% 성장"));
    }

    private void updateGrowth(int inc) {
        growthPercent = Math.min(100, growthPercent + inc);
        growthLabel.setText("성장도: " + growthPercent + "%");
        growthBar.setValue(growthPercent);

        // 감정 이모티콘 갱신 (임시)
        if (growthPercent < 25) moodLabel.setText("기분: 😐 씨앗");
        else if (growthPercent < 50) moodLabel.setText("기분: 🙂 새싹");
        else if (growthPercent < 75) moodLabel.setText("기분: 😃 잎");
        else if (growthPercent < 100) moodLabel.setText("기분: 🤩 꽃봉오리");
        else moodLabel.setText("기분: 🌸 꽃");
    }

    private void addMessage(String msg) {
        messageArea.append(msg + "\n");
    }

}
