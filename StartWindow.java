import javax.swing.*;
import java.awt.*;

class StartWindow{
    static JFrame frame = new JFrame();
    static JButton start;
    static void view(){
        ImagePanel panel = new ImagePanel("qbkls.png");
        panel.setSize(400, 400);

        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setLayout(new BorderLayout());


        start = new JButton("Start");
        start.addActionListener(e -> {
            SimpleTextWindow simpleTextWindow = new SimpleTextWindow(Model.createQuiz(), false, true);
        });
        start.setPreferredSize(new Dimension(200,20));
        start.setMinimumSize(start.getPreferredSize());

        JButton rules = new JButton("Rules");
        rules.addActionListener(e -> {
            SimpleTextWindow simpleTextWindow = new SimpleTextWindow("Your aim is getting all questions correct. " +  "\r\n"  +"Type your answer into given field, submit and wait for the result.", false, false);
            simpleTextWindow.setVisible(true);
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
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
