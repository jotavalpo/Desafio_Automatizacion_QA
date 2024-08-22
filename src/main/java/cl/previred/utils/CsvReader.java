package cl.previred.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class CsvReader {

    public static List<String[]> readCsv(String filePath) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> records = reader.readAll();
        reader.close();
        return records;
    }
}