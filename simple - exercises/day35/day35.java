package day35;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day35 {

    public static void main(String[] args) {

        System.out.println(GopherEscapePlan("day35/day-35_sample_1_valid.txt"));
        System.out.println(GopherEscapePlan("day35/day-35_sample_2_valid.txt"));
        System.out.println(GopherEscapePlan("day35/day-35_sample_3_invalid.txt"));
        System.out.println(GopherEscapePlan("day35/day-35_sample_4_invalid.txt"));
    }

    public static List<String> GopherEscapePlan (String filePath) {

        final String errorMessage = "BAD FILE!";
        final String scapeMessage = "The gopher cannot escape.";
        final String cantScapeMessage = "The gopher can escape through the hole at";

        List<String> message = new ArrayList<>();
        List<String> lines;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            lines = reader.lines().toList();

            System.out.println(lines);

            for (String line : lines) {
                String[] lineArray = line.split(" ");

                if (lineArray[0].equals("")) {
                    message.add(errorMessage);
                    return message;
                } else {

                }
            }

            reader.close();
        } catch (IOException e) {
            message.add(errorMessage);
            return message;
        }

        return message;
    }

}
