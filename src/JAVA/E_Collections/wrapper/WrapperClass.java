package JAVA.E_Collections.wrapper;

public class WrapperClass {
    public static void main(String[] args) {

        // Using Integer.valueOf()
        Integer num1 = Integer.valueOf(10);

        // Autoboxing (Compiler automatically converts int -> Integer)
        Integer num2 = 100;

        // 2. Manual Boxing
        // Converting primitive int -> Integer object manually

        int n1 = 100;

        // Explicit conversion using valueOf()
        Integer n2 = Integer.valueOf(n1);

        // 3. Auto Boxing
        // Compiler automatically converts primitive to wrapper object

        Integer age = 25;     // Compiler converts to Integer.valueOf(25)


        // 4. Manual Unboxing
        // Converting Integer object -> primitive int manually

        Integer obj = Integer.valueOf(150);

        // Explicit conversion using intValue()
        int num = obj.intValue();


        // 5. Auto Unboxing
        // Compiler automatically converts Integer -> int

        Integer a = 101;
        Integer b = 100;

        // Both Integer objects are automatically converted to int
        int sum = a + b;


        // Output

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Manual Boxing (n2) = " + n2);

        System.out.println("Auto Boxing (age) = " + age);

        System.out.println("Manual Unboxing (num) = " + num);

        System.out.println("Auto Unboxing (sum) = " + sum);
    }
}