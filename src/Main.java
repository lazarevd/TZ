import ru.laz.tz.util.RandomGenerator;
import ru.laz.tz.util.Ruble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    private static final int YEARS = 1;
    private static final long MIN_SUM = 10000;
    private static final long MAX_SUM = 100000;

    private static List<String> readDataFromFile(String inputFileName) {

        List<String> retList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))){
            String line = br.readLine();
            while (line != null) {
                retList.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File "+inputFileName+" not found");
        } catch (IOException e) {
            System.out.println("File "+inputFileName+" reading error");
        }
        return retList;
    }


    private static String genOffice(List<String> offices) {
        int idx = RandomGenerator.genInt(offices.size());
        return offices.get(idx);
    }


    private static String genSum(long min, long max) {
        return new Ruble(RandomGenerator.genLong(min*100, max*100), Ruble.Currency.CENT).toString();
    }


    private static String genDate() {

        int currentYear = LocalDateTime.now().getYear();
        LocalDateTime fromDate = LocalDateTime.of(currentYear-1, 1, 1, 0, 00, 00);
        return RandomGenerator.getRandomDate(fromDate, fromDate.plus(YEARS, ChronoUnit.YEARS)).toString();
    }


    private static int genId() {
        return RandomGenerator.genInt(Integer.MAX_VALUE);
    }
    
    
    
    private static void generateFile(List<String> offices, int rowCount, String operationsFile) {
    	
    	try (PrintStream ps = new PrintStream(new FileOutputStream(operationsFile))) {
    		
            for (int i=0; i<rowCount;i++) {
            	ps.println(genDate() + "\t" + genOffice(offices) + "\t" + genId() + "\t" + genSum(MIN_SUM, MAX_SUM));
             }
    		
    	} catch (FileNotFoundException e) {
			System.out.println("Can not write file " + operationsFile);
		}
    	
    	
    	

    }
    

    public static void main(String[] args) {



        List<String> offices = readDataFromFile(System.getProperty("user.dir") +"/etc/offices.txt");
             
        generateFile(offices, 50000, System.getProperty("user.dir") +"/etc/operations.txt");
    }
}
