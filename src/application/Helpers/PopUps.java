package application.Helpers;

import javax.swing.JOptionPane;

public class PopUps {
	public static void errorMessage(String errMessage) {
		try {
			JOptionPane.showMessageDialog(null, errMessage, "Error", 0, null);
		} catch (Exception e) {
			// Error muss ausgegeben werden
			e.printStackTrace();
		}
	}
}
