import javax.swing.*;

class JokeWindow {
    static void view(String s){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("   " +s);
        panel.add(label);
        JButton laughter = new JButton("I laughed");
        laughter.addActionListener(e -> {
            Controller.startGame();
            frame.setVisible(false);
        });
        panel.add(laughter);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
