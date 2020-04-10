import java.util.ArrayList;

class Controller {
    static void showJoke(){
            JokeWindow.view(Module.createQuiz());
    }
    static void startGame(){
        Module.createQuiz();
        QuizWindow.view();
    }
    private static ArrayList list;
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfIncorrectAnswers = 0;
    private static ArrayList  listOfPoints = new ArrayList();

    private static int points = 0;

    private static void preparePointsList(){
        if(Module.list.get(1) instanceof ArrayList){
            listOfPoints =(ArrayList) Module.list.get(1);
        }

    }
    static  void check(String a){
        if(list.contains(a)){
            preparePointsList();
            SimpleAudioPlayer.SimpleAudioPlayer("src/correct_sound.wav");
            if(list.indexOf(a)==0){
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
            }
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
        if(!QuizWindow.answerOne.getText().equals("")&&!QuizWindow.answerTwo.getText().equals("")&&!QuizWindow.answerThree.getText().equals("")&&!QuizWindow.answerFour.getText().equals("")&&!QuizWindow.answerFive.getText().equals("")){
            QuizWindow.answerOne.setText("");
            QuizWindow.answerTwo.setText("");
            QuizWindow.answerThree.setText("");
            QuizWindow.answerFour.setText("");
            QuizWindow.answerFive.setText("");
            QuizWindow.pointsOne.setText("");
            QuizWindow.pointsTwo.setText("");
            QuizWindow.pointsThree.setText("");
            QuizWindow.pointsFour.setText("");
            QuizWindow.pointsFive.setText("");

            QuizWindow.pointsNumber.setText("Points number: " + points + "      ");

            Controller.prepareAQuiz(QuizWindow.showATask());

        }
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
