import javax.swing.*;

class GameEndWindow {
    static void view(int a){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Your score :" + a);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
