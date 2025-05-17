package manager;

import model.User;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Savemanager {
	public static final String USER_FILE_PATH = "users.txt"; // 저장할 파일 경로

    public static void saveUsersToFile() {
        HashMap<String, User> users = User.getAllUsers();
        try (FileWriter writer = new FileWriter(USER_FILE_PATH)) {
            for (Map.Entry<String, User> entry : users.entrySet()) {
                String id = entry.getKey();
                User user = entry.getValue();
                writer.write(id + "," + user.getPassword() + "\n"); // ID와 비밀번호를 쉼표로 구분하여 저장
            }
            System.out.println("사용자 정보가 " + USER_FILE_PATH + "에 저장되었습니다.");
        } catch (IOException e) {
            System.err.println("사용자 정보 저장에 실패했습니다: " + e.getMessage());
        }
    }
}
