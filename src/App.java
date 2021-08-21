import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import com.coordinate.EnhancedPoint;
import com.coordinate.Point;

public class App {
    
    // default access modifier for classes, properties and methods is
    // package-private
    public static int variable = 123;

    // main method is always static so the java runtime environment can call it
    // without creating a new object or instance as you see.
    public static void main(String[] args) throws Exception {

        // static properties and methods are bound to class not object.
        // we can not have access to "this" in static methods becuase this refers to the
        // current object and it is not available in the static context
        // we only have access to static methods, the class itself (App) and static
        // variables. we can access to other methods when they are static methods

        // App.useObjectOriented();

        // or in simpler syntax just call them.

        // useObjectOriented();
        // compareObjects();
        // polymorphism();
        useInterface();

        // we can also access static variables

        // System.out.println(variable);

    }

    private static void useInterface() {
        
    }

    public static void polymorphism() {
        // we know that every textboxes and checkboxes are elements
        Element[] elements = { new TextBox(), new CheckBox() };

        // foreach in java
        for (var element : elements) {
            element.render();
        }

    }

    public static void compareObjects() {

        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);

        // returns false, this compares the reference addresses of these objects
        System.out.println(point1 == point2);
        System.out.println(point1.equals(point2));

        var point3 = new EnhancedPoint(1, 2);
        var point4 = new EnhancedPoint(1, 2);

        // returns true, because we overrided the behaviour of equals
        // notice that in java, we don't have operator overloading
        System.out.println(point3.equals(point4));
        System.out.println(point3.hashCode());
        System.out.println(point4.hashCode());

    }

    public static void downUpCasting(Element el) {

        // in upcasting, we can not have access to the child properties but the
        // overrided methods are going to get called like toString(). In order to have
        // access to child properties which is TextBox in here, we should perform a
        // downcasting, an explicit casting to the child class.
        // instanceof : an operator which checks an object whether is the instance of
        // another object or not
        if (el instanceof TextBox) {
            var textBox = (TextBox) el;
            System.out.println("using textbox downcasted : " + textBox);
        }

        System.out.println("using element upcasted : " + el);

    }

    public static void useObjectOriented() {
        // you can access directly to other classes which are inside of the currrent
        // package of your application
        // but if the target class in on another package and it is not private or
        // package-private, you can access
        // to it with importing the class using the notation : import
        // path.to.package.className

        var textBox1 = new TextBox();
        textBox1.setText();
        System.out.println(textBox1);

        // because TextBox is a child of Element, it means that "TextBox is an Element".
        // we can use every child of Element class wherever we have Element parameter
        // and we can give its child which is TextBox as an argument.
        // this is called upcasting. But in the method, you do not have access to the
        // child class fields and methods.
        downUpCasting(textBox1);

    }

    // java features
    public static void usingVar() {
        // how to automatically determine the type of the variable ?
        var number = 123;
        var array = new int[10];
        var string = "salam";

        // it is very shorter and cleaner way to define objects of a class
        // i mean instantiating an object from a class
        var textBox1 = new TextBox();

        System.out.println(string);

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

    public static void referenceTypes() {

        // most of the reference types are needed to be imported
        // e.g. Date, with new operator, an instance of the Date class is created
        Date nowDate = new Date();

        // String is a reference type in the java.lang package
        // java.lang is automatically imported in every java application
        // you don't need to import it. btw it doesn't need to use new either;
        // there is a shorthand syntax which is double quotation
        String message = "this is a string";

        // it is also worth mentioning that Strings in java are immutable types.
        // every methods that modifies String Objects, actually return new Objects.
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
