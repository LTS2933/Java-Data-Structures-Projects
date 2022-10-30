package arraystackadt;

public class PrimeFactorizationDemoClass {

    public static void main(String[] args) {
        
        ArrayStackDataStrucClass<Integer> factors = new ArrayStackDataStrucClass<>(50);
        int element = 3960;
        for (int i = 2; element != 1; i++) {
            while (element % i == 0) {
                try {
                    factors.push(i);
                } catch (StackOverflowException exc) { //push() only throws overflow error
                    System.out.println("Stack overflow error");
                }
                element = element / i;
            }
        }
        System.out.print("Factorization of 3960: " + factors);
        System.out.println();
        element = 1234;
        factors.initializeStack();
        for (int i = 2; element != 1; i++) {
            while (element % i == 0) {
                try {
                    factors.push(i);
                } catch (StackOverflowException exc) {
                    System.out.println("Stack overflow error");
                }
                element = element / i;
            }
        }
        System.out.print("Factorization of 1234: " + factors);
        System.out.println();
        element = 222222;
        factors.initializeStack();
        for (int i = 2; element != 1; i++) {
            while (element % i == 0) {
                try {
                    factors.push(i);
                } catch (StackOverflowException exc) {
                    System.out.println("Stack overflow error");
                }
                element = element / i;
            }
        }
        System.out.print("Factorization of 222222: " + factors);
        System.out.println();
        element = 13780;
        factors.initializeStack();
        for (int i = 2; element != 1; i++) {
            while (element % i == 0) {
                try {
                    factors.push(i);
                } catch (StackOverflowException exc) {
                    System.out.println("Stack overflow error");
                }
                element = element / i;
            }
        }
        System.out.print("Factorization of 13780: " + factors);
        System.out.println();
    }
}
