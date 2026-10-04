import java.util.Scanner;

public class todo {
    public static void welcome() {
        table(new String[][] {{"Welcome TO Your TODO List"}});
    }

    public static int lcol(String[][] data, int index) {
        int r = data.length;
        int l = data[0][index].length();
        for (int i = 1; i < r; i++) {
            if (data[i][index].length() > l) {
                l = data[i][index].length();
            }
        }

        return l;
    }

    public static String spacecount(String text, int lenfill) {
        int textlen = text.length();
        int space = (lenfill - textlen) / 2;
        String spacesstr = "";
        for (int i = 0; i < lenfill; i++) {
            if (space > 0) {
                spacesstr += " ";
                space--;
            } else {
                spacesstr += text;
                i += textlen;
                spacesstr += " ";
                space = (lenfill - textlen) / 2;
            }
        }

        return spacesstr;
    }

    public static void table(String[][] data) {
        int r = data.length;
        int c = data[0].length;

        for (int i = 0; i < r; i++) {
            if (i == 0) {
                System.out.printf("┌");
            } else {
                System.out.printf("├");
            }

            for (int j = 0; j < c; j++) {
                int coll = lcol(data, j) + 4;
                for (int k = 0; k < coll; k++) {
                    System.out.printf("─");
                }
                if (j == c - 1) {
                    System.out.println("┐");
                } else {
                    System.out.printf("┬");

                }

            }
            System.out.printf("│");
            for (int j = 0; j < c; j++) {
                int coll = lcol(data, j) + 4;
                String spacedstr = spacecount(data[i][j], coll);
                System.out.printf(spacedstr);
                System.out.printf("│");

            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        welcome();
        table(new String[][] {
                { "Action", "Choice" },
                { "Create New Table", "New (N)" },
                { "View all tasks", "Show (S)" },
                { "Mark Complete by ID", "Mark (M)" },
                { "Delete a Task by ID", "Del (D)" },

        });
        while (true) {

            System.out.println("Enter your input ('Q/q' to quit):");
            String uIn = scan.nextLine();

            if (uIn.equals("Q") || uIn.equals("q")) {
                System.out.println("Saving the Data and Exiting");
                break;
            } else if (uIn.equals("N")) {

            }
        }

        scan.close();
    }

}
