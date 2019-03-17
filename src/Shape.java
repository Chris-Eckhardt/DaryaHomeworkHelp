import java.util.ArrayList;


public class Shape {

    //data structure to store
    private ArrayList<String> list = new ArrayList<>();

    //constructor
    public Shape() {}

    //printShape(enum, int)
    public void printShape(ShapeEnum e, int n) {
        String str = null;

        //get shape from enum

        switch (e) {
            case DIAMOND:
                str = diamond(n);
                break;
            case TRIANGLE:
                str = triangle(n);
                break;
            case RECTANGLE:
                str = rectangle(n);
                break;
        }

        ShapeMaker.writeToFile(str); // writes new shape to text.txt
        //add returned string to list
        list.add(str);
    }

    public void printPreviousShape(int i) {
        System.out.println(list.get(i));
    } // prints shape in list at index i

    public String getItemFromArray(int i) {
        return list.get(i);
    } // not used

    public int getArraySize() {
        return list.size();
    } // returns size of arraylist

    public void addToArray(String line) {
        list.add(line);
    } // adds shape to arraylist

    //Diamond(int) prints diamond of size n and adds to array
    private String diamond(int n) {
        String s = "";

        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                s = s + " ";
            }

            for (int j = 0; j < n; j++) {
                s = s + "* ";
            }
            s = s + "\n";
        }
        System.out.println(s);

        return s;
    }
    

    //Rectangle(int) prints rectangle of size n and adds to array
    private String rectangle(int n){
            String s = "";

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s = s + "* ";
                }
                s = s + "\n";
            }
            System.out.println(s);

            return s;
    }

    //triangle(int) prints triangle of size n and adds to array
    private String triangle(int n) {
        String s = "";
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                  s = s + "* ";
            }
            s = s + "\n";
        }
        System.out.println(s);

        return s;
    }
           
}
