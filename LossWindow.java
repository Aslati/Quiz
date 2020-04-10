import javax.swing.*;

public class LossWindow {
    static void view(){
        JFrame frame = new JFrame();
        JTextField textField = new JTextField("You lost");
        textField.setEditable(false);
        frame.add(textField);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
