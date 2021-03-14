package by.nagula.service;

import by.nagula.entity.Line;

import java.util.Comparator;

public class LineComparator implements Comparator<Line> {

    @Override
    public int compare(Line o1, Line o2) {
        for (int i = 0; i < o1.getColumns().size(); i++){
            if (o1.getColumns().isEmpty() | o2.getColumns().isEmpty()) return -1;
            try {
                double num1 = Double.parseDouble(o1.getColumns().get(i));
                double num2 = Double.parseDouble(o2.getColumns().get(i));
                if ((int) (num1- num2) != 0){
                    return (int) (num1 - num2);
                }
            } catch (NumberFormatException ex){
                if (o1.getColumns().get(i).compareTo(o2.getColumns().get(i)) != 0){
                    return o1.getColumns().get(i).compareTo(o2.getColumns().get(i));
                }
            }
        }
        return 0;
    }


}
