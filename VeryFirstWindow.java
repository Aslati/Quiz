import javax.swing.*;

public class VeryFirstWindow{
    public static void main (String[] args){
        VeryFirstWindow.view();
    }
    static void view(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JButton game  = new JButton("Play");
        game.addActionListener(e -> StartWindow.view());

        JButton create  = new JButton("Create quiz");
        create.addActionListener(e -> FileOverwrittenWindow.view());

        panel.add(game);
        panel.add(create);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
