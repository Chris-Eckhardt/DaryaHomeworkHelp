package shapemaker.shape_list;

import shapemaker.shape.Shape;

public interface ShapeListInterface {

    ////// ADD / REMOVE SHAPE FROM LIST //////

    void addShape( Shape shape );

    Shape traverseList(ITERATE direction);



}
