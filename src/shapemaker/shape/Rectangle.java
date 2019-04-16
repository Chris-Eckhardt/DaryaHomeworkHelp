package shapemaker.shape;

public class Rectangle extends Shape {

    public Rectangle(int size) {
        super(size);
    }

    @Override
    public String printShape() {
        int n = this.getSize();
        String s = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s = s + "* ";
            }
            s = s + "\n";
        }

        return s;
    }

    @Override
    public String toString() {
        return "R_" + getSize();
    }
}
