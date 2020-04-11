import javax.swing.*;
import java.util.ArrayList;

class Controller {
    /*static void showJoke(){
            JokeWindow.view(Model.createQuiz());
    }*/
    static void startGame(){
        Model.createQuiz();
        StartWindow.start.setText("again");
        QuizWindow.view();
    }
    static int i = 0;
    private static ArrayList list;
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfIncorrectAnswers = 0;
    private static ArrayList  listOfPoints = new ArrayList();
    static boolean isLabel;
    private static int points = 0;

    private static void preparePointsList(){
        if(Model.list.get(1) instanceof ArrayList){
            listOfPoints =(ArrayList) Model.list.get(1);
        }

    }
    static  void check(String a){
        isLabel =  QuizWindow.list.get(list.indexOf(a)).get(0) instanceof JLabel;
        if(list.contains(a)){
            preparePointsList();
            SimpleAudioPlayer.SimpleAudioPlayer("src/correct_sound.wav");
            if(isLabel){

                ((JLabel) QuizWindow.list.get(list.indexOf(a)).get(0)).setText(a);
               // QuizWindow.center.setVisible(false);
                //QuizWindow.center.setVisible(true);
            }
            /*if(list.indexOf(a)==0){
                QuizWindow.answerOne.setText(a);
                QuizWindow.pointsOne.setText(listOfPoints.get(0).toString());
            }
            if(list.indexOf(a)==1){
                QuizWindow.answerTwo.setText(a);
                QuizWindow.pointsTwo.setText(listOfPoints.get(1).toString());
            }
            if(list.indexOf(a)==2){
                QuizWindow.answerThree.setText(a);
                QuizWindow.pointsThree.setText(listOfPoints.get(2).toString());
            }
            if(list.indexOf(a)==3){
                QuizWindow.answerFour.setText(a);
                QuizWindow.pointsFour.setText(listOfPoints.get(3).toString());
            }
            if(list.indexOf(a)==4){
                QuizWindow.answerFive.setText(a);
                QuizWindow.pointsFive.setText(listOfPoints.get(4).toString());
            }*/
            numberOfCorrectAnswers++;
            points+=Integer.parseInt(listOfPoints.get(list.indexOf(a)).toString());
        }else{
            numberOfIncorrectAnswers++;
            if(numberOfIncorrectAnswers>=1){
                SimpleAudioPlayer.SimpleAudioPlayer("src/wrong_sound.wav");
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
        list=gottenList;
    }

    private static void isDone(){
        for(i = 0; i<5; i++){
            isLabel =  QuizWindow.list.get(i).get(0) instanceof JLabel;
             if(!QuizWindow.list.get(i).get(0).equals("")/*!QuizWindow.answerOne.getText().equals("")&&!QuizWindow.answerTwo.getText().equals("")&&!QuizWindow.answerThree.getText().equals("")&&!QuizWindow.answerFour.getText().equals("")&&!QuizWindow.answerFive.getText().equals("")*/) {
                 /*QuizWindow.answerOne.setText("");
                 QuizWindow.answerTwo.setText("");
                 QuizWindow.answerThree.setText("");
                 QuizWindow.answerFour.setText("");
                 QuizWindow.answerFive.setText("");
                 QuizWindow.pointsOne.setText("");
                 QuizWindow.pointsTwo.setText("");
                 QuizWindow.pointsThree.setText("");
                 QuizWindow.pointsFour.setText("");
                 QuizWindow.pointsFive.setText("");*/
                 ((JLabel) QuizWindow.list.get(i).get(0)).setText("");
             }
        }
        QuizWindow.showATask();
    }
    private static void lost(){
        QuizWindow.frame.setVisible(false);
        LossWindow.view();
    }
    static void endGame(){
        GameEndWindow.view(points);
        QuizWindow.frame.setVisible(false);
    }

}
