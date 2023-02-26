package utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;

@UtilityClass
public class RandomUtil {

    public static String getRandomEmail() {
        return format("test_%s@mail.com", new Random().nextInt());
    }

    public static String getRandomPhoneString() {
        var random = new Random();
        var lowerBound = 100;
        var upperBound = 999;
        var firstPair = random.nextInt(upperBound - lowerBound) + lowerBound;
        var secondPair = random.nextInt(upperBound - lowerBound) + lowerBound;
        var thirdPair = random.nextInt(9999 - 1000) + 1000;

        return valueOf(firstPair) + secondPair + thirdPair;
    }

    public static String getRandomLastName() {
        var unixTime = valueOf(currentTimeMillis() / 1000L);

        return unixTime + new Random().nextInt(100);
    }

    public static String getRandomFistName() {
        return "automation" + new Random().nextInt(100);
    }

    public static String getRandomPassword() {
        return "Test!2345" + new Random().nextInt(100);
    }
}
