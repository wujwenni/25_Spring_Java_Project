import ui.*;
import manager.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UImanager uiManager = new UImanager();
        uiManager.start();
        Runtime.getRuntime().addShutdownHook(new Thread(Savemanager::saveUsersToFile));
	}

}
