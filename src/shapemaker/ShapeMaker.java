package shapemaker;

import shapemaker.shape.*;
import shapemaker.shape_list.ITERATE;
import shapemaker.shape_list.ShapeListManager;

public class ShapeMaker {

    private static UI ui;
    private ShapeListManager shapeListManager;
    private Shape newShape;
    private int size;

    public ShapeMaker() {
        ui = new UI(this);
        shapeListManager = new ShapeListManager();
    }

    public void make(String input, SHAPE_ENUM shapeEnum) {
        // check input
        boolean pass = false;
        try {
            size = Integer.parseInt(input);
            if (size > 0 && size <= 100) {
                pass = true;
            } else {
                ui.badInput(1);
            }
        } catch (NumberFormatException ex) {
            ui.badInput(0);
        }

        if(pass) {

            // make new shape
            switch (shapeEnum) {
                case DIAMOND:
                    newShape = new Diamond(size);
                    shapeListManager.addShape(newShape);
                    shapeListManager.writeToFile(newShape.toString());
                    ui.printShape(newShape.printShape());
                    break;
                case TRIANGLE:
                    newShape = new Triangle(size);
                    shapeListManager.addShape(newShape);
                    shapeListManager.writeToFile(newShape.toString());
                    ui.printShape(newShape.printShape());
                    break;
                case RECTANGLE:
                    newShape = new Rectangle(size);
                    shapeListManager.addShape(newShape);
                    shapeListManager.writeToFile(newShape.toString());
                    ui.printShape(newShape.printShape());
                    break;
            }
        }
    }

    public void diamondCall(String string) {
        make(string, SHAPE_ENUM.DIAMOND);
    }

    public void rectangleCall(String string) {
        make(string, SHAPE_ENUM.RECTANGLE);
    }

    public void triangleCall(String string) {
        make(string, SHAPE_ENUM.TRIANGLE);
    }

    public void previousCall() {
        ui.printShape(shapeListManager.traverseList(ITERATE.BACK).printShape());
    }

    public void forwardCall() {
        ui.printShape(shapeListManager.traverseList(ITERATE.FORWARD).printShape());
    }

    public String getPosition() {
        return shapeListManager.getPositionInList();
    }

}

