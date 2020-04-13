import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

class Model {
   private static BufferedReader bufferedReader;

  static  ArrayList list = new ArrayList();

    static String createQuiz(){

        SourceFile sourceFile = new SourceFile();

        bufferedReader = sourceFile.getFile("source.txt");

        try {
             return bufferedReader.readLine();
        }catch (IOException e){
            return "Sorry, there's a technical problem";
        }
    }
    static ArrayList<ArrayList> getAQuestion(){
        ArrayList listOfAnswers = new ArrayList();
        ArrayList<Integer> listOfPoints = new ArrayList<>();
        String question = "";

        try{
            String readLine = bufferedReader.readLine();
            if (readLine!=null) {
            question = readLine;
            int na = 0;
            int np = 0;
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    listOfAnswers.add(na, bufferedReader.readLine());
                    na++;
                }
                if (i % 2 == 1) {
                    listOfPoints.add(np, Integer.parseInt(bufferedReader.readLine()));
                    np++;
                }
            }
       }else{
           Controller.endGame();
           bufferedReader.close();
        }
        }catch(IOException e){
            e.printStackTrace();
        }

        list.add(0, listOfAnswers);
        list.add(1, listOfPoints);
        list.add(2, question);
        return list;
    }
    static void fileOverwritten(ArrayList<ArrayList> list){
               try {
                   FileWriter fileWriter = new FileWriter("C://Users//joaja//Documents//Quiz//src//source.txt");

                   BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

                   bufferWriter.write(((JTextField) list.get(0).get(0)).getText());
                   bufferWriter.newLine();
                   for(int i = 1; i<list.size(); i++){
                       for(int j = 0; j<11; j++){
                           bufferWriter.write( ((JTextField) list.get(i).get(j)).getText());
                           bufferWriter.newLine();
                       }
                   }
                   bufferWriter.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }

    }



