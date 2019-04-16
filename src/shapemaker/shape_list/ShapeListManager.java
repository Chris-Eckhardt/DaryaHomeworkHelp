package shapemaker.shape_list;

import shapemaker.shape.Diamond;
import shapemaker.shape.Rectangle;
import shapemaker.shape.Shape;
import shapemaker.shape.Triangle;

import java.io.*;
import java.util.ArrayList;

public class ShapeListManager implements ShapeListInterface {

    private ArrayList<Shape> shapeList = new ArrayList<>();
    private File file;
    private int index;

    public ShapeListManager(){

        // find data.txt. If it doesn't exist, create one.
        try {

            file = new File("src/data.txt");

            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // if there is saved data, retrieve from file
        try {
            readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addShape(Shape shape) {
        if(shape.getSize() > 0) {
            shapeList.add(shape);
        }
    }

    @Override
    public Shape traverseList(ITERATE direction) {

        switch (direction) {
            case FORWARD:
                if( index < (shapeList.size() - 1) ) { index++; }
                break;
            case BACK:
                if( index > 0 ) { index--; }
                break;
        }

        return shapeList.get(index);
    }

    public String getPositionInList() {

        return (index+1) + " / " + (shapeList.size());
    }


    ////// READ FROM / WRITE TOO FILE //////

    private void readFromFile() throws FileNotFoundException {
        BufferedReader source = new BufferedReader(new FileReader(file));
        String line;

        try {
            while ((line = source.readLine()) != null) {
                shapeList.add(interpret(line));

            }
        } catch (IOException e) {
            System.out.println("ERROR : @readFile()");
        }

        index = shapeList.size() - 1;

    }

    private Shape interpret(String line) {
        String[] attributes;
        Shape shape;
        int size = 0;

        // delimit line
        attributes = line.split("_");

        // change size to int
        try {
            size = Integer.parseInt(attributes[1]);
        } catch (NumberFormatException ex) {
            System.out.println("ERROR @ parseInt");
        }

        // create shape
        switch(attributes[0]) {
            case "D":
                shape = new Diamond(size);
                break;
            case "T":
                shape = new Triangle(size);
                break;
            case "R":
                shape = new Rectangle(size);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + attributes[0]);
        }
        
        return shape;
        
    }


    public void writeToFile(String line) {
        index = shapeList.size() - 1;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.append(line); // adds to file, does not overwrite
            writer.append("\n"); // this is for delimiting while reading the file back
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
