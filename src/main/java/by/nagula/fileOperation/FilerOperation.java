package by.nagula.fileOperation;

import by.nagula.entity.Line;

import java.util.List;

public interface FilerOperation {
    void write(List<Line> lineList);
    List<Line> read();
}
