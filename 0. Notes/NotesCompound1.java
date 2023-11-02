public class NotesCompound1 {
    public static void main(String[] args) {
        int age = 25;
        double cash = 100.0;

        if (age >= 18 && cash >= 250.0) {
            System.out.println("You can rent a car!");
        } else if (age >= 18) {
            System.out.println("You are old enough to rent a car, but cannot afford it.");
        } else if (cash >= 250.0) {
            System.out.println("You can afford to rent a car, but are not old enough to rent one.");
        } else {
            System.out.println("You are not old enough to rent a car and could not afford it anyways.");
        }
    }
}
