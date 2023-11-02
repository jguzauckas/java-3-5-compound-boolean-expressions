public class NotesNestedIf1 {
    public static void main(String[] args) {
        int x = 10;

        if (x > 5) {
            if (x < 15) {
                System.out.println("x is greater than 5 and less than 15");
            } else {
                System.out.println("x is greater than 5, but not less than 15");
            }
        } else {
            System.out.println("x is not greater than 5, which means it must be less than 15");
        }
    }
}
