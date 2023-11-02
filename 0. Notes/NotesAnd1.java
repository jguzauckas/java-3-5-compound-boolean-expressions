public class NotesAnd1 {
    public static void main(String[] args) {
        boolean isStudent = true;
        boolean hasMoney = false;

        if (isStudent && hasMoney) {
            System.out.println("This person can just pay for college");
        } else if (isStudent) {
            System.out.println("This person is going to college and will need a loan to pay for it");
        } else if (hasMoney) {
            System.out.println("This person can pay for it, but is not going to college and doesn't need to pay for it");
        } else {
            System.out.println("This person is not going to college, and doesn't need to worry about whether or not they can pay for it");
        }
    }
}
