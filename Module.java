import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Module {
    public static void main (String[] args){
        StartWindow.view();
    }

    private static Scanner scanner;

  static  ArrayList list = new ArrayList();
  static String joke = "";

    static String createQuiz(){
        File file = new File("src/source.txt");
        try {
            scanner = new Scanner(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        joke = scanner.nextLine();
        return joke;
    }
    static ArrayList<ArrayList> getAQuestion() {
        ArrayList listOfAnswers = new ArrayList();
        ArrayList<Integer> listOfPoints = new ArrayList<>();
        String question = "";
        if (scanner.hasNext()) {
            //scanner.nextLine();
            question = scanner.nextLine();
            //if(scanner.nextLine()=="question"){
            int na = 0;
            int np = 0;
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    listOfAnswers.add(na, scanner.nextLine());
                    na++;
                }
                if (i % 2 == 1) {
                    listOfPoints.add(np, Integer.parseInt(scanner.nextLine()));
                    np++;
                }
            }


        }else{
            System.out.println();
            Controller.endGame();
        }
        list.add(0, listOfAnswers);
        list.add(1, listOfPoints);
        list.add(2, question);
        return list;
    }

}
