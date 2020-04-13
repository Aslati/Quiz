import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

class QuizWindow {
    private static JLabel showQuestion = new JLabel();

    static ArrayList<ArrayList> list = new ArrayList<>();


    private static JPanel center = new JPanel();

    private static JPanel west = new JPanel();
    static JLabel pointsNumber = new JLabel();


    static JFrame frame = new JFrame();

    static void view(){

        JPanel panel= new JPanel();

        panel.setLayout(new GridLayout(4,2));


        center.setLayout(new FlowLayout(FlowLayout.LEFT));


        JPanel south = new JPanel();
        south.setLayout((new BoxLayout(south, BoxLayout.X_AXIS)));

        JPanel north = new JPanel();
        north.setLayout((new BoxLayout(north, BoxLayout.Y_AXIS)));

        north.setPreferredSize(new Dimension(600, 75));
        north.setMaximumSize(north.getPreferredSize());

        showQuestion.setPreferredSize(new Dimension(600, 75));
        showQuestion.setMaximumSize(showQuestion.getPreferredSize());
        showQuestion.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
        showQuestion.setAutoscrolls(true);

        north.add(showQuestion);
        north.add(pointsNumber);

        west.setLayout(new BoxLayout(west, BoxLayout.X_AXIS));


        JTextField insertAnswer = new JTextField("");
        insertAnswer.setPreferredSize(new Dimension(450, 80));
        insertAnswer.setMaximumSize(insertAnswer.getPreferredSize());
        Border border = new LineBorder(Color.BLACK, 5);
        Border margin = new EmptyBorder(10,10,10,10);
        Border insideBorder = new CompoundBorder(border, margin);
        insertAnswer.setBorder(new CompoundBorder(margin, insideBorder));


        JButton check = new JButton("submit");
        check.addActionListener(e -> {
            Controller.check(insertAnswer.getText());
            insertAnswer.setText("");
        });
        check.setPreferredSize(new Dimension(100, 440));
        check.setMinimumSize(new Dimension(150, 440));
        frame.getRootPane().setDefaultButton(check);

        south.add(insertAnswer);
        south.add(check);

        showQuestion.setPreferredSize(new Dimension(500, 100));

        for(int i = 0; i<5; i++){
            PointsAndAnswerContainer pointsAndAnswerContainer = new PointsAndAnswerContainer();
            center.add(pointsAndAnswerContainer);
            list.add(i, pointsAndAnswerContainer.array);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
        Controller.prepareAQuiz(showATask());
        panel.add(north);
        center.setVisible(true);
        panel.add(center);
        panel.add(south);
        panel.add(west);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        StartWindow.frame.setVisible(false);
    }

    static ArrayList showATask(){
        ArrayList<ArrayList> list = Model.getAQuestion();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(list.get(2));
        String list2 = stringBuffer.toString();
        showQuestion.setText(" " +  list2);
        return list.get(0);
    }

    static void remove(){

      ImagePanel wrong = new ImagePanel("wrong.png");
        west.add(wrong);
        west.setVisible(false);
        west.setVisible(true);
    }

}
