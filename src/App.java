import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        App.inputScanner();
    }

    public static void primitiveTypes() {
        byte age = 30;
        short height = 123;
        int integerNum = 123456;
        long longNum = 123_456_7L;
        float awshari = 10.55F;
        double doubleNum = 100.123;
        char character = 'A';
        boolean isAuthenticated = true;
    }

    public static void refrenceTypes() {

        // most of the refrence types are needed to be imported
        // e.g. Date, with new operator, an instance of the Date class is created
        Date nowDate = new Date();

        // String is a refrence type in the java.lang package
        // java.lang is automatically imported in every java application
        // you don't need to import it. btw it doesn't need to use new either;
        // there is a shorthand syntax which is double quotation
        String message = "this is a string";

        System.out.println(message);
    }

    public static void constants() {

        final float pi = 3.14F;
        // throws an error
        // pi = 0;
    }

    public static void arrays() {

        // arrays are fixed in length
        // we can add or remove items with Collections

        // standard syntax
        int[] numbers = new int[10];
        numbers[0] = 4;
        numbers[1] = 5;
        System.out.println(Arrays.toString(numbers));

        // short syntax
        int[] newNumbers = { 9, 5, 3, 6, 2 };
        Arrays.sort(newNumbers);
        System.out.println(Arrays.toString(newNumbers));

        // multi-dimensional arrays standard syntax
        int[][] multiDimArray = new int[3][4];
        multiDimArray[0][1] = 99;
        System.out.println(Arrays.deepToString(multiDimArray));

        // multi-dimensional arrays short syntax
        int[][] newMultiDimArray = { { 0, 0 }, { 1, 1 } };
        System.out.println(Arrays.deepToString(newMultiDimArray));

    }

    public static void stringToNumber() {
        String x = "123";
        String y = "12.22";

        // convert x to integer using wrapper classes
        int number = Integer.parseInt(x);

        double doubleNum = Double.parseDouble(y);

        System.out.println(number);
        System.out.println(doubleNum);
    }

    public static void math() {
        int rounded = Math.round(12.11F);

        int random = (int) (Math.random() * 100);

        System.out.println(random);
    }

    public static void formatNumber() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(1234567.890);
        System.out.println(result);
    }

    public static void inputScanner() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("You are " + input);
        scanner.close();
    }
}
