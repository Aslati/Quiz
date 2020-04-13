import java.io.*;
import java.net.URL;

public class SourceFile{

    BufferedReader getFile(String path){
        try {
            URL file = getClass().getClassLoader().getResource(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.openStream()));
            return bufferedReader;
        }catch (IOException e){
            return null;
        }

    }

}
