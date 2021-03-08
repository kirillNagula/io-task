package by.nagula.fileOperation;

import by.nagula.entity.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilerOperationImpl implements FilerOperation {
    private final String PATH_FROM;
    private final String PATH_TO;

    public FilerOperationImpl(String PATH_FROM, String PATH_TO) {
        this.PATH_FROM = PATH_FROM;
        this.PATH_TO = PATH_TO;
    }

    @Override
    public void write(List<Line> lineList){
        File file = new File(PATH_TO);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        flush(lineList);
    }

    private void flush(List<Line> lineList){
        try {
            FileWriter fileWriter = new FileWriter(PATH_TO);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Line line: lineList){
                for (int i = 0; i < line.getColumns().size(); i++) {
                    String str = line.getColumns().get(i).concat("\t");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Line> read() {
        List<Line> lineList= new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH_FROM);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null){
                String[] split = str.split("\t");
                List<String> columns = new ArrayList<>(Arrays.asList(split));
                lineList.add(new Line(columns));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineList;
    }
}
