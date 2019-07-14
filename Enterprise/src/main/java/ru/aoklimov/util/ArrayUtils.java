package ru.aoklimov.util;

import ru.aoklimov.organization.CSV;

public class ArrayUtils {

    static public String concatWithSeparatorToCSV(String separator, Object... array) {
        StringBuilder result = new StringBuilder();
        for (Object obj : array) {
            if (obj instanceof Object[]){
                result.append(concatWithSeparatorToCSV(separator, (Object[]) obj));
            } else if (obj instanceof CSV) {
                result.append(((CSV) obj).toCSV()).append(separator);
            } else {
                result.append(obj.toString()).append(separator);
            }
        }
        return result.toString();
    }
}
