package shapemaker.shape;

public class Triangle extends Shape {

    public Triangle(int size) {
        super(size);
    }

    @Override
    public String printShape() {
        int n = getSize();
        String s = "";

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                s = s + "* ";
            }
            s = s + "\n";
        }

        return s;
    }

    @Override
    public String toString() {
        return "T_" + getSize();
    }
}
