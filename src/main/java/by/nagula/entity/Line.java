package by.nagula.entity;

import java.util.List;

public class Line {
    private List<String> columns;

    public Line(List<String> columns) {
        this.columns = columns;
    }

    public Line() {
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Line{" +
                "columns=" + columns +
                '}';
    }
}
