import java.util.ArrayList;

public class Shape {

    //data structure to store
    ArrayList<String> list = new ArrayList<>();

    //constructor
    public Shape() {}

    //printShape(enum, int)
    public void printShape(Enum e, int n) {
        //get shape from enum

        //add returned string to list
        
    }

    //Diamond(int) prints rectangle of size n and adds to array
    private String diamond(int n) {
        String shapeString = "";

        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                shapeString = shapeString + " ";
            }

            for (int j = 0; j < n; j++) {
                shapeString = shapeString + "* ";
            }
            shapeString = shapeString + "\n";
        }
        System.out.println(shapeString);

        return shapeString;
    }
    

    //Rectangle(int) prints diamond of size n and adds to array
    private String rectangle(int n){

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
            return null;
        }

    //triangle(int) prints triangle of size n and adds to array
    private String triangle(int n) {
        System.out.println("");
        for (int i = 1; i <= n; i++) {
            System.out.println("");
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
        }
        System.out.println("");

        return null;
    }
           
}
