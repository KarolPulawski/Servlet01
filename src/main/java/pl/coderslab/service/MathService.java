package pl.coderslab.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathService {
    public static String equation(double a, double b, double c) {


        Double numberA = a;
        Double numberB = b;
        Double numberC = c;

        //sqrt of quadratic equation:  -b - delta / 2a | -b + delta / 2a
        final double delta = numberB * numberB - 4 * numberA * numberC;
        final double deltaSqrt = Math.sqrt(delta);

        if(delta < 0) {
            return "There is no any sqrt result";
        } else if(deltaSqrt == 0) {
            final double oneResult = - numberB / 2 / numberA;
            return "There is only one sqrt result: " + oneResult;
        } else {
            final double sqrt1 = (-numberB - deltaSqrt) / 2 / numberA;
            final double sqrt2 = (-numberB + deltaSqrt) / 2 / numberA;
            return "The first sqrt result is: " + sqrt1 + " the second sqrt result is: " + sqrt2;
        }
    }

    public static List<Double> receiveDouble(String[] params) {
        List<Double> result = new ArrayList<>();
        for(String param : params) {
            try {
                Double number = Double.parseDouble(param);
                result.add(number);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(result);
        return result;
    }

    public static double tempartureCelToFahr(double startTemp) {
        return 32 + 9.0/5 * startTemp;
    }

    public static double tempartureFahrToCelc(double startTemp) {
        return 5.0/9*(startTemp - 32);
    }
}
