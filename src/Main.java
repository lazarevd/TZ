import ru.laz.tz.util.RandomGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    private List<String> readDataFromFile(String inputFileName) {

        List<String> retList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))){
            String line = br.readLine();
            while (line != null) {
                retList.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File {} not found",inputFileName));
        } catch (IOException e) {
            System.out.println(String.format("File {} reading error",inputFileName));
        }
        return retList;
    }
 

    private float genOperationSum(float min, float max) {
        return RandomGenerator.getRandomFloat(min, max);
    }



    public static void main(String[] args) {

        System.out.println(RandomGenerator.getRandomDate(
                LocalDateTime.of(1986, 12, 16, 7, 45, 55),
                LocalDateTime.of(2018, 12, 16, 7, 46, 55)));
    }
}
