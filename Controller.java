import javax.swing.*;
import java.util.ArrayList;

class Controller {
    static void startGame(){
        QuizWindow.view();
    }
    private static ArrayList list;
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfIncorrectAnswers = 0;
    private static ArrayList  listOfPoints = new ArrayList();
    private static ArrayList listOfUsed = new ArrayList();
    static private boolean isLabel;
    private static int points = 0;

    private static void preparePointsList(){
        if(Model.list.get(1) instanceof ArrayList){
            listOfPoints =(ArrayList) Model.list.get(1);
        }

    }
    private static SimpleAudioPlayer simpleAudioPlayer = new SimpleAudioPlayer();
    static  void check(String a){
        if(list.contains(a)){

            isLabel =  QuizWindow.list.get(list.indexOf(a)).get(0) instanceof JLabel;
            boolean isLabelPoints = QuizWindow.list.get(list.indexOf(a)).get(1) instanceof JLabel;
            preparePointsList();

            if(isLabel && isLabelPoints && listOfUsed.contains(a)==false){
                listOfUsed.add(a);
                ((JLabel) QuizWindow.list.get(list.indexOf(a)).get(0)).setText(a);
                ((JLabel) QuizWindow.list.get(list.indexOf(a)).get(1)).setText(listOfPoints.get(list.indexOf(a)).toString());
                numberOfCorrectAnswers++;
                points+=Integer.parseInt(listOfPoints.get(list.indexOf(a)).toString());
                simpleAudioPlayer.SimpleAudioPlayer("correct_sound.wav");
            }else if(listOfUsed.contains(a)){
                numberOfIncorrectAnswers++;
                if(numberOfIncorrectAnswers>=1){
                    simpleAudioPlayer.SimpleAudioPlayer("wrong_sound.wav");
                    QuizWindow.remove();
                }
            }

        }else{
            numberOfIncorrectAnswers++;
            if(numberOfIncorrectAnswers>=1){
                simpleAudioPlayer.SimpleAudioPlayer("wrong_sound.wav");
                QuizWindow.remove();
            }
        }
        if(numberOfCorrectAnswers==5){
            isDone();
            numberOfCorrectAnswers=0;
        }
        if(numberOfIncorrectAnswers==3){
            lost();
        }
    }
    static void prepareAQuiz(ArrayList gottenList){
        listOfUsed.clear();
        list=gottenList;
    }

    private static void isDone(){
        int i = 0;
        while(i<5){
            isLabel =  QuizWindow.list.get(i).get(0) instanceof JLabel;
             if(!QuizWindow.list.get(i).get(0).equals("")) {
                 ((JLabel) QuizWindow.list.get(i).get(0)).setText("");
                 ((JLabel) QuizWindow.list.get(i).get(1)).setText("");
                 i++;
             }
        }
        QuizWindow.pointsNumber.setText(" Points number: " + points);
        prepareAQuiz(QuizWindow.showATask());
    }
    private static void lost(){
        QuizWindow.frame.setVisible(false);
        SimpleTextWindow simpleTextWindow = new SimpleTextWindow("You lose", true, false);
        simpleTextWindow.setVisible(true);
    }
    static void endGame(){
        SimpleTextWindow simpleTextWindow = new SimpleTextWindow("Your score: " +points, true, false);
    }

}
