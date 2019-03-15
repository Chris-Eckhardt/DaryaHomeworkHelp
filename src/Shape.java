import com.sun.tools.classfile.Annotation;

import java.util.ArrayList;

public class Shape {

    //data structure to store
    ArrayList<String> list = new ArrayList<>();

    //constructor
    public Shape() {}

    //printShape(enum, int)
    public void printShape(ShapeEnum e, int n) {
        //get shape from enum
<<<<<<< HEAD
        switch (e) {
=======
        if() {
>>>>>>> 6a9968e710632f15eb2c802424a364b8ae944013

        }

        //add returned string to list
        
    }

    //Diamond(int) prints rectangle of size n and adds to array
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
    

    //Rectangle(int) prints diamond of size n and adds to array
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
             s = s + "* ";
            for (int j = 0; j < i; j++) {
                  s = s + "\n";

            }
        }
        System.out.println(s);

        return s;
    }
           
}
