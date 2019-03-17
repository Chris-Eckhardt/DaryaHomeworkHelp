import java.io.*;
import java.util.Scanner;


public class ShapeMaker {

    private static Shape shape = new Shape();

    public static void main(String[] args) {
        new ShapeMaker();
        prompt();
    }

    private static void prompt() { //this method is responsible for getting user input and giving data to shapes class

        try {
            readFile(); //this reads previous shapes from text.txt and loads them into an Arraylist in shapes class
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ShapeEnum se = null; //init shapeenum

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

               if(num == 4) { // check for recall argument
                   recall();
                   rec = true;

               }

               if(num == 5) { // exit program argument

                   System.out.println("/////////// EXITING PROGRAM /////////");
                   System.exit(0);
               }


           }

            if(!rec) { // skip this block if recall() is called
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

            if(!rec) {// skip this block if recall() is called

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

    private static boolean pass(int low, int high, int n) { // checks for correct input, returns boolean value
        if(n >= low && n <= high) { return true; }
        else { return false; }
    }

    private static void recall() { // checks shapes arraylist and give the user chance to recall previously made shapes
        int listSize = shape.getArraySize();
        Scanner scanner = new Scanner(System.in);
        String input = "0";
        int num = 0;

        if(listSize > 0 && num < listSize) {

            while(!pass(1, listSize, num)) {

                System.out.print("There are " + listSize +
                        " shapes in memory. Please choose which you would like to recall (1 being the most recent).\n\n >>> ");

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

    private static void readFile() throws FileNotFoundException { // gets previous shapes from text.txt

        String line = "";
        String str = "";
        BufferedReader textSource = new BufferedReader(new FileReader("text.txt"));

            try {
                while ((line = textSource.readLine()) != null) {

                    if (line.equals("#")) { // checks for delimiter
                        shape.addToArray(str);
                        str = ""; // resets str
                    } else {
                        str = str + line + "\n";
                    }
                }
            } catch (IOException e) {
                System.out.println("ERROR : @readFile()");
            }
        }


    public static void writeToFile(String line) { // adds a shape to the text.txt every time a shape is created

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("text.txt", true));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                writer.append(line); // adds to file, does not overwrite
                writer.append("#\n"); // this is for delimiting while reading the file back
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

