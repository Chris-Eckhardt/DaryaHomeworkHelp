import java.util.Scanner;

public class Main {

    enum Shape {
        TRIANGLE,
        RECTANGLE,
        DIAMOND
    }

    public static void main(String[] args) {
        prompt();
    }

    private static void prompt() {
        
         String input = "";
        int in = 0;
        int n = 0;
        Scanner scanner = new Scanner(System.in);

        while(true) {


            while(!pass) {

                System.out.print("What shape would you like? " +
                        "\n 1 : Triangle " +
                        "\n 2 : Rectangle " +
                        "\n 3 : Diamond " +
                        "\n 4 : EXIT PROGRAM\n\n");

                input = scanner.next();




                    try {
                        num = Integer.parseInt(input);
                        pass = true;
                    } catch (NumberFormatException ex) {
                        pass = false;
                    }

                if(in == 4) {
                    System.exit(0);
                }

            }

            while (n > 100 || n < 1) {

                System.out.print("\nPlease input a height be1tween 1 and 100: ");

                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                }

            }

            System.out.println(" ");

            switch (in) {
                case 1:
                    Triangle x = new Triangle();
                    x.printShape(n);
                    break;
                case 2:
                    Rectangle t = new Rectangle();
                    t.printShape(n);
                    break;
                case 3:
                    Diamond s = new Diamond();
                    s.printShape(n);
                    break;
                default:
                    // blank
                    break;
            }

            System.out.println(" ");

            //resets values
            input = "0";
            in = 0;
            n = 0;

    }

}
