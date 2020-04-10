import javax.swing.*;

class RulesWindow {
    void view(){
        JFrame frame = new JFrame();
        JLabel label = new JLabel("Your aim is getting all questions correct. " +  "\r\n"  +"Type your answer into given field, submit and wait for the result.");
        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }
}
