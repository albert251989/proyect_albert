package SIEV.helpers;

public class Helpers {

	public static void threadSleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public class LoginPageHelpers {
		public static final String USER_VALUE = "64625";
		public static final String WRONG_USER_VALUE = "user";
		public static final String PASS_VALUE = "gold8585";
		public static final String WRONG_PASS_VALUE = "password";
		public static final String REGION_VALUE = "Region 9";
		public static final String USER_TYPE_VALUE = "EMPLEADOS DEUR";
	}
}
