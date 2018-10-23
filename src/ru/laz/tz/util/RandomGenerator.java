package ru.laz.tz.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static float getRandomFloat(){
        return random.nextFloat();
    }

    public static float getRandomFloat(float min, float max){
        return random.nextFloat()*(max-min)+min;
    }

    public static LocalDateTime getRandomDate(LocalDateTime fromDateTime, LocalDateTime toDateTime) {

        LocalDateTime tempDate = LocalDateTime.from(fromDateTime);
        long secondsDifference = tempDate.until(toDateTime, ChronoUnit.SECONDS);
        secondsDifference = random.nextLong(secondsDifference);
        tempDate = tempDate.plus(secondsDifference, ChronoUnit.SECONDS);
        return tempDate;
    }


    public static int genInt() {
        return random.nextInt();
    }

    public static int genInt(int bound) {
        return random.nextInt(bound);
    }


    public static long genLong(long min, long max) {
        return random.nextLong(max-min) + min;
    }
}

