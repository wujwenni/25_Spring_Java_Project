package model;

import manager.Savemanager;
import java.util.HashMap;
import java.io.*;

public class User {
	private String id;
    private String password;
    private static User instance = null;
    // 모든 사용자 정보를 담는 HashMap (id → User)
    private static HashMap<String, User> userMap = new HashMap<>();

    // 현재 로그인된 사용자 (공유 객체)
    private static User currentUser;
    private User() {
    }
    // 생성자는 private → 외부에서 직접 생성 불가
    private User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    // 회원가입: 새 사용자 추가
    public static boolean register(String id, String password) {
        if (userMap.containsKey(id)) {
        	System.out.println("이미 존재하는 ID입니다.");
            return false; // 이미 존재하는 ID
        }
        userMap.put(id, new User(id, password));
        System.out.println(id + "님, 회원가입이 완료되었습니다.");
        Savemanager.saveUsersToFile();
        return true;
    }

    // 로그인
    public static boolean login(String id, String password) {
        User user = userMap.get(id);
        if (user != null && user.password.equals(password)) {
            currentUser = user;
            System.out.println(id + "님, 로그인되었습니다.");
            return true;
        }
        System.out.println("로그인에 실패했습니다. ID 또는 비밀번호를 확인해주세요.");
        return false;
    }

    // 로그아웃
    public static void logout() {
        if (currentUser != null) {
            System.out.println(currentUser.id + "님, 로그아웃되었습니다.");
            currentUser = null;
        } else {
            System.out.println("현재 로그인된 사용자가 없습니다.");
        }
    }

    // 현재 로그인한 사용자 반환
    public static User getCurrentUser() {
        return currentUser;
    }

    // 사용자 등록 여부 확인
    public static boolean userExists(String id) {
        return userMap.containsKey(id);
    }

    // 로그인 상태 확인
    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    // 모든 사용자 가져오기 (for save/load)
    public static HashMap<String, User> getAllUsers() {
        return userMap;
    }

    public static void setAllUsers(HashMap<String, User> loadedUsers) {
        userMap = loadedUsers;
    }
    
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
            instance.loadUsersFromFile();  // 파일에서 사용자 로딩
        }
        return instance;
    }
    
    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Savemanager.USER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String id = parts[0];
                    String password = parts[1];
                    userMap.put(id, new User(id, password));
                }
            }
            System.out.println("사용자 정보가 파일에서 로드되었습니다.");
        } catch (IOException e) {
            System.err.println("사용자 정보 로드에 실패했습니다 (파일이 없을 수 있습니다): " + e.getMessage());
            // 파일이 없는 경우에도 에러 없이 진행하기 위해 예외를 처리합니다.
        }
    }
}
