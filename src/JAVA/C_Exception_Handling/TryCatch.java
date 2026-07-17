package JAVA.C_Exception_Handling;

public class TryCatch {
    public static void main(String[] args) {
        try{
            int i = 10/0;
        }
        catch(ArithmeticException e){

        }
        catch (Exception e) {
           System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("Process Compleate");
    }
}

class mak extends RuntimeException{

}
