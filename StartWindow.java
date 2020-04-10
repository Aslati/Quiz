import javax.swing.*;
import java.awt.*;

class StartWindow extends JPanel {
    static JFrame frame = new JFrame();

    static void view(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImagePanel panel = new ImagePanel("src/qbkls.png");
        panel.setSize(400, 400);

        //JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setLayout(new BorderLayout());


        JButton start = new JButton("Start");
        start.addActionListener(e -> Controller.startGame());
        start.setPreferredSize(new Dimension(200,20));
        start.setMinimumSize(start.getPreferredSize());

        JButton rules = new JButton("Rules");
        rules.addActionListener(e -> {
            RulesWindow rulesWindow = new RulesWindow();
            rulesWindow.view();
        });
        rules.setPreferredSize(new Dimension(200,20));
        rules.setMinimumSize(rules.getPreferredSize());

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        buttons.setPreferredSize(new Dimension(400,20));
        buttons.setMinimumSize(buttons.getPreferredSize());
        buttons.add(start);
        buttons.add(rules);


        panel.add(buttons, BorderLayout.SOUTH);

        label.add(panel, BorderLayout.CENTER);
        frame.add(label);
        //frame.pack();
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
