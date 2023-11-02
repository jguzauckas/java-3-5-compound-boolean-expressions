public class NotesOr1 {
    public static void main(String[] args) {
        boolean friendsOnline = true;
        boolean gameToPlay = false;

        if (friendsOnline || gameToPlay) {
            System.out.print("I should hop on my computer ");
            if (friendsOnline && gameToPlay) {
                System.out.println("because I have my friends to play my game with");
            } else if (friendsOnline) {
                System.out.println("because my friends are online");
            } else {
                System.out.println("because I have a game I want to play");
            }
        } else {
            System.out.println("This person is not going to college, and doesn't need to worry about whether or not they can pay for it");
        }
    }
}
