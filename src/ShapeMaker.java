import java.io.*;
import java.util.Scanner;


public class ShapeMaker {

    private static Shape shape = new Shape();




    public static void main(String[] args) {
        new ShapeMaker();
        prompt();
    }

    private static void prompt() {

        try {
            readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ShapeEnum se = null;

        String input = "0";
        int size = 0;
        boolean pass = false;
        boolean rec = false;
        int num = 0;
        Scanner scanner = new Scanner(System.in);

       while(true) {

           while(!pass(1, 4, num)) {

               System.out.print("What shape would you like? " +
                       "\n 1 : Triangle " +
                       "\n 2 : Rectangle " +
                       "\n 3 : Diamond " +
                       "\n 4 : Previous shapes " +
                       "\n 5 : EXIT PROGRAM\n\n >>> ");

               input = scanner.next();

               System.out.println();

               try {
                   num = Integer.parseInt(input);
               } catch (NumberFormatException ex) {
                    // error
               }

               if(num == 4) {
                   recall();
                   rec = true;

               }

               if(num == 5) {

                   System.out.println("/////////// EXITING PROGRAM /////////");
                   System.exit(0);
               }


           }

            if(!rec) {
                input = "0"; // reset input IMPORTANT!


                while (!pass(1, 100, size)) {

                    System.out.print("\nPlease input a height be1tween 1 and 100: \n\n >>> ");

                    input = scanner.next();

                    System.out.println();

                    try {
                        size = Integer.parseInt(input);
                    } catch (NumberFormatException ex) {
                        // error
                    }

                }
            }

            if(!rec) {

                //////////////////////////////////
                //////// CALL THE SHAPE //////////
                //////////////////////////////////
                if (num == 1)
                    se = ShapeEnum.TRIANGLE;

                if (num == 2)
                    se = ShapeEnum.RECTANGLE;

                if (num == 3)
                    se = ShapeEnum.DIAMOND;


                shape.printShape(se, size); // CALL FOR SHAPE TO BE PRINTED
            }

           //resets values
           input = "0";
           size = 0;
           num = 0;
           rec = false;

       }

    }

    private static boolean pass(int low, int high, int n) {
        if(n >= low && n <= high) { return true; }
        else { return false; }
    }

    private static void recall() {
        int listSize = shape.getArraySize();
        Scanner scanner = new Scanner(System.in);
        String input = "0";
        int num = 0;

        if(listSize > 0 && num < listSize) {

            while(!pass(1, listSize, num)) {

                System.out.print("There are " + listSize + " shapes in memory. Please choose which you would like to recall (1 being the most recent).\n\n >>> ");

                input = scanner.next();

                System.out.println();

                try {
                    num = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    // error
                }
            }

        }else {
            System.out.println("there are no previous shapes saved.\n");
        }

        if(listSize > 0)
            shape.printPreviousShape(listSize - num);

    }

    private static void readFile() throws FileNotFoundException {

        String line = "";
        String str = "";
        BufferedReader textSource = new BufferedReader(new FileReader("text.txt"));

        try {
            while ((line = textSource.readLine()) != null) {

                if(line == "\n") {
                    shape.addToArray(str);
                    str = "";
                }else{
                    str = str + line + "\n";
                }

            }
        } catch(IOException e){
            System.out.println("ERROR : @readFile()");
        }
    }

    public static void writeToFile(String line) {

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("text.txt", true));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                writer.append(line);
                writer.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}

