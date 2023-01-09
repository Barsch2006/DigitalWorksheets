package application.Tests;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {
		Test[] testFiles = {
				new CryptTest()
		};
		
		for (Test testFile : testFiles) {
			try {
				Method testMethod = testFile.getClass().getMethod("test");
				if ((boolean) testMethod.invoke(testFile, null)) {
					System.out.println(testFile.getClass().getName() + ": SUCCESSFULL");
				} else {
					System.out.println(testFile.getClass().getName() + ": FAILED");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
