import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

class FileOverwrittenWindow extends JPanel{

        private static JPanel firstPanel = new JPanel();
        private static JPanel secondPanel = new JPanel();
        private static ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList<JTextField> smallList = new ArrayList<>();
        static JButton secondButton = new JButton("submit");
        static void view(){
                JFrame frame = new JFrame();

                JTextField joke = new JTextField("Insert a joke");
                ArrayList jokeList = new ArrayList();
                jokeList.add(joke);
                list.add(0, jokeList);
                JTextField questionNumber = new JTextField("Insert a number of questions");
                JButton firstButton = new JButton("submit");



                secondButton.addActionListener(e ->{
                        Model.fileOverwritten(list);
                        frame.setVisible(false);
                });

                firstPanel.add(joke);
                firstPanel.add(questionNumber);

                secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));

                firstButton.addActionListener(e -> {
                        firstPanel.setVisible(false);
                        frame.add(secondPanel);
                        for(int i = 0; i<Integer.parseInt(questionNumber.getText()); i++){
                                FileOverwrittenWindow fileOverwrittenWindow = new FileOverwrittenWindow();
                                secondPanel.add(fileOverwrittenWindow);
                                list.add(i+1, fileOverwrittenWindow.smallList);
                        }
                        secondPanel.add(secondButton);
                        frame.pack();
                });



                firstPanel.add(firstButton);

                frame.add(firstPanel);
                frame.pack();
                frame.setVisible(true);
        }
        FileOverwrittenWindow(){
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(5, 2));
                JTextField question = new JTextField("");
                smallList.add(question);
                for(int i = 0; i<10; i++){
                        if(i%2==0) {
                                JTextField answer = new JTextField("answer");
                                smallList.add(i+1, answer);
                                panel.add(answer);

                        }else{
                                JTextField points = new JTextField("points");
                                smallList.add(i+1, points);
                                panel.add(points);
                        }
                }
                this.setBorder(new EmptyBorder(10,10,10,10));
                this.add(question);
                this.add(panel);

        }
}
