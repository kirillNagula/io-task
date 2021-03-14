package by.nagula.service;

import by.nagula.entity.Line;
import by.nagula.fileOperation.FilerOperation;
import by.nagula.fileOperation.FilerOperationImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileService {
    private  final String PATH_FROM;
    private  final String PATH_TO;

    public FileService(String PATH_FROM, String PATH_TO) {
        this.PATH_FROM = PATH_FROM;
        this.PATH_TO = PATH_TO;
    }

    public void start() {
        FilerOperation  filerOperation = new FilerOperationImpl(PATH_FROM, PATH_TO);
        List<Line> lines = filerOperation.read();
        List<Line> sortList = sort(lines);
        filerOperation.write(sortList);
    }

    private List<Line> sort(List<Line> lines){
        List<Line> sortList = new ArrayList<>();
        lines.stream().sorted(new LineComparator()).forEach(sortList::add);
       return sortList;
    }
}
