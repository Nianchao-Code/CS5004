public class Power {
    public static void main(String[] args) {
    int result = (int) Math.pow(2, 31);
    System.out.println(result);
    }
}

/*
Three differences versus the Python version:
1. Java needs to declare the data type for variables (e.g. 'int' for the result) while Python does not need that.
2. Java uses 'Math.pow()' for exponentiation while Python uses '**'.
3. Java needs a 'main' method for execution while Python does not need to execution.
*/