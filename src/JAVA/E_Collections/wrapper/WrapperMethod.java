package JAVA.E_Collections.wrapper;

import static java.lang.Integer.compare;

public class WrapperMethod {
    public static void main(String[] args) {
        //Method
        /***
         * 1. compare(a,b) -> compare two value
         * 2. Max(a,b)  -> return max value
         * 3. Min(a,b)  -> return min value
         * toString()  -> convert in to String
         */

        Integer a = 300;
        Integer b = 200;
        System.out.println(compare(a,b));

        /** Output
         * if a > b then +1
         * if a < b then -1
         * if a == b then 0
         */
        String  string = a.toString(); // convert Integer into String


        /* --( == )------------------------------------ */
        /**
         * In primitive ( == ) is compare value because we do not have any reference.
         *And
         *In Classes ( == ) is compare reference and if we want to compare value then we use [ .equal() ]
         */

        Integer num = 50;
        Integer num2 = 50;

        System.out.println(num == num2); // true
        System.out.println(num.equals(num2)); // true

        Integer n1 = 500;
        Integer n2 = 500;
        System.out.println(n1 == n2); // false
        System.out.println(n1.equals(n2)); // true


        /**
         * Output difference
         * In Integer store -128 to 128 int value in same object.
         * So when we use ( == ) its compare reference so it's true.
         * if we want to compare value then we need to use .equal()
         */

    }
}
