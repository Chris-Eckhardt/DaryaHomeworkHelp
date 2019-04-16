package shapemaker.shape;

public class Diamond extends Shape {

    public Diamond(int size) {
        super(size);
    }

    @Override
    public String printShape() {
        int n = this.getSize();
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

        return s;
    }

    @Override
    public String toString() {
        return "D_" + getSize();
    }
}
