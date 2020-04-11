import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class QuizWindow {
    private static JLabel showQuestion = new JLabel();
    /*static AnswerLabel answerOne = new AnswerLabel();
    static JLabel answerTwo = new JLabel();
    static JLabel answerThree = new JLabel();
    static JLabel answerFour = new JLabel();
    static JLabel answerFive = new JLabel();
    static JLabel pointsOne = new JLabel();
    static JLabel pointsTwo = new JLabel();
    static JLabel pointsThree = new JLabel();
    static JLabel pointsFour = new JLabel();
    static JLabel pointsFive = new JLabel();*/
    static ArrayList<ArrayList> list = new ArrayList();


    static JPanel center = new JPanel();

    private static JPanel west = new JPanel();
    static JLabel pointsNumber = new JLabel();


    static JFrame frame = new JFrame();

    static void view(){

        JPanel panel= new JPanel();

        panel.setLayout(new GridLayout(4,2));


        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel south = new JPanel();
        south.setLayout((new BoxLayout(south, BoxLayout.X_AXIS)));

        JPanel north = new JPanel();
        north.setLayout((new BoxLayout(north, BoxLayout.X_AXIS)));

        north.setPreferredSize(new Dimension(600, 75));
        north.setMaximumSize(north.getPreferredSize());

        showQuestion.setPreferredSize(new Dimension(400, 75));
        showQuestion.setMaximumSize(showQuestion.getPreferredSize());

        north.add(showQuestion);
        north.add(pointsNumber);

        west.setLayout(new BoxLayout(west, BoxLayout.X_AXIS));


        JTextField insertAnswer = new JTextField("");
        insertAnswer.setPreferredSize(new Dimension(500, 80));
        insertAnswer.setMaximumSize(insertAnswer.getPreferredSize());

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
            System.out.println("okay");
            list.add(i, pointsAndAnswerContainer.array);
        }

       /* //answerOne.setEditable(false);
        //answerOne.setPreferredSize(new Dimension(400, 25));
       // answerOne.setMaximumSize(answerOne.getPreferredSize());
        //answerTwo.setEditable(false);
        answerTwo.setPreferredSize(new Dimension(400, 25));
        answerTwo.setMaximumSize(answerTwo.getPreferredSize());
        //answerThree.setEditable(false);
        answerThree.setPreferredSize(new Dimension(400, 25));
        answerThree.setMaximumSize(answerThree.getPreferredSize());
        //answerFive.setEditable(false);
        answerFour.setPreferredSize(new Dimension(400, 25));
        answerFour.setMaximumSize(answerFour.getPreferredSize());
        //answerFour.setEditable(false);
        answerFive.setPreferredSize(new Dimension(400, 25));
        answerFive.setMaximumSize(answerFive.getPreferredSize());*/

        /*pointsOne.setEditable(false);
        pointsTwo.setEditable(false);
        pointsThree.setEditable(false);
        pointsFive.setEditable(false);
        pointsFour.setEditable(false);*/

        /*JPanel containerOne = new JPanel();
        containerOne.setLayout((new BoxLayout(containerOne, BoxLayout.X_AXIS)));
        containerOne.add(answerOne);
        containerOne.add(pointsOne);

        JPanel containerTwo = new JPanel();
        containerTwo.setLayout((new BoxLayout(containerTwo, BoxLayout.X_AXIS)));
        containerTwo.add(answerTwo);
        containerTwo.add(pointsTwo);

        JPanel containerThree = new JPanel();
        containerThree.setLayout((new BoxLayout(containerThree, BoxLayout.X_AXIS)));
        containerThree.add(answerThree);
        containerThree.add(pointsThree);

        JPanel containerFour = new JPanel();
        containerFour.setLayout((new BoxLayout(containerFour, BoxLayout.X_AXIS)));
        containerFour.add(answerFour);
        containerFour.add(pointsFour);

        JPanel containerFive = new JPanel();
        containerFive.setLayout((new BoxLayout(containerFive, BoxLayout.X_AXIS)));
        containerFive.add(answerFive);
        containerFive.add(pointsFive);

        center.add(containerOne);
        center.add(containerTwo);
        center.add(containerThree);
        center.add(containerFour);
        center.add(containerFive);*/

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
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
        showQuestion.setText("    " +  list2);
        return list.get(0);
    }

    static void remove(){

      ImagePanel wrong = new ImagePanel("src/wrong.png");
        west.add(wrong);
        west.setVisible(false);
        west.setVisible(true);
    }

}
