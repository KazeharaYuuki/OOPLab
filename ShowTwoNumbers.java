package hajime;

import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: \n";

        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showInputDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
