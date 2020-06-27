package chapter2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.StringReader;

public class Exercise13 {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new StringReader("3, Pavel, 20.0\n5, Nea, 1.0\n228"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            System.out.println(String.join(", ", nextLine));
        }
    }
}
