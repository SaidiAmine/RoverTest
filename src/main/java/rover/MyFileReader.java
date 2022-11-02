package rover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MyFileReader {

    private final String FILE_PATH = "C:\\Users\\amine\\Downloads\\rover2.txt";
    private File file;

    private BufferedReader br;
    private List<String> commandLines;

//    private String line;
//
    public MyFileReader() throws IOException {
        file = new File(FILE_PATH);
        br = new BufferedReader(new FileReader(file));
        readLines();
    }

    private void readLines() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            commandLines.add(line);
            System.out.println(line);
        }
    }

    public List<String> getCommandLines() {
        return commandLines;
    }
}
