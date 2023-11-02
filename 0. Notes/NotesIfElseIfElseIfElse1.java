public class NotesIfElseIfElseIfElse1 {
    public static void main(String[] args) {
        int age = 53; // Mr. G's father's age
        double interestRate = -1.0;
        if (age > 60) {
            interestRate = 1.0;
        } else if (age > 50) {
            interestRate = 1.5;
        } else if (age > 40) {
            interestRate = 2.0;
        } else if (age > 30) {
            interestRate = 2.5;
        } else if (age > 20) {
            interestRate = 3.0;
        } else {
            System.out.println("You cannot have a loan.");
        }

        if (interestRate > 0) {
            System.out.println("You can have the " + interestRate + "% interest rate.");
        }
    }
}
