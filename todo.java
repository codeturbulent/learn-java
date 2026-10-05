import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class todo {
    public static void welcome() {
        table(new String[][] { { "Welcome TO Your TODO List" } });
    }

    public static void showoptions() {
        table(new String[][] {
                { "Action", "Choice" },
                { "Create New Table", "New (N)" },
                { "View all tasks", "Show (S)" },
                { "Mark Complete by ID", "Mark (M)" },
                { "Delete a Task by ID", "Del (D)" },

        });
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
                    if (i == 0) {
                        System.out.println("┐");
                    } else {
                        System.out.println("┤");
                    }
                } else {

                    if (i == 0) {
                        System.out.printf("┬");
                    } else {
                        System.out.printf("┼");
                    }
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
            if (i == r - 1) {
                System.out.printf("└");
                for (int j = 0; j < c; j++) {
                    int coll = lcol(data, j) + 4;
                    for (int k = 0; k < coll; k++) {
                        System.out.printf("─");
                    }
                    if (j == c - 1) {
                        if (i == r - 1) {
                            System.out.println("┘");
                        } else {
                            System.out.println("┐");
                        }
                    } else {
                        System.out.printf("┴");
                    }
                }
            }
        }
    }

    public static int createtask(Path fp,String task) throws IOException {
        //reading to know number of ids present
        String content = Files.readString(fp);
        String[] data = content.split("\n");
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Path fp =  Path.of("tasks.txt");

        Scanner scan = new Scanner(System.in);
        welcome();
        showoptions();

        while (true) {

            System.out.print("Enter your input ('Q/q' to quit):");
            String uIn = scan.nextLine();

            if (uIn.equals("Q") || uIn.equals("q") || uIn.equals("Quit") || uIn.equals("quit")) {
                System.out.println("Saving the Data and Exiting");
                break;
            } else if (uIn.equals("N") || uIn.equals("n") || uIn.equals("New") || uIn.equals("new")) {
                System.out.print("What is Your New Task :");
                String taskinp = scan.nextLine();
                System.out.println(taskinp);
                int taskid = createtask(fp,taskinp);
                System.out.printf("Task Created with id %d \n" , taskid);
            }else if (uIn.equals("S") || uIn.equals("s") || uIn.equals("Show") || uIn.equals("show")) {
                
            }else{
                 System.out.println("Choose a Valid Option.");
            }
        }
        scan.close();

    }

}
