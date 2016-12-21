package PartA; /**
 * Created by Shlomi Alon on 19/12/2016.
 */

public class ShapeContainer {

    public static final int INIT_SIZE = 10;
    public static final int RESIZE = 10;

    public Rectangle[] rectangleArr;
    public Triangle[] triangleArr;
    private int rMone, tMone;

    public ShapeContainer() {
        rectangleArr = new Rectangle[INIT_SIZE];
        triangleArr = new Triangle[INIT_SIZE];
        rMone = tMone = 0;
    }

    public ShapeContainer(ShapeContainer shapeContainer) {
        rectangleArr = new Rectangle[shapeContainer.rectangleArr.length];
        triangleArr = new Triangle[shapeContainer.triangleArr.length];

        for (int i = 0; i < rectangleArr.length; i++) {
            if (shapeContainer.rectangleArr[i] != null) {
                rectangleArr[i] = new Rectangle(shapeContainer.rectangleArr[i]);
            } else {
                rectangleArr[i] = null;
            }
        }
        for (int i = 0; i < triangleArr.length; i++) {
            if (shapeContainer.triangleArr[i] != null) {
                triangleArr[i] = new Triangle(shapeContainer.triangleArr[i]);
            } else {
                triangleArr[i] = null;
            }
        }

        rMone = shapeContainer.rMone;
        tMone = shapeContainer.tMone;
    }

    public int T_size() {
        return tMone;
    }

    public int R_size() {
        return rMone;
    }

    public int size() {
        return T_size() + R_size();
    }

    public void add(Rectangle r) {
        if (r != null) {
            if (rMone >= rectangleArr.length) {
                R_resize();
            }
            rectangleArr[rMone] = r;
            rMone++;
        }
    }

    public void add(Triangle t) {
        if (t != null) {
            if (tMone >= triangleArr.length) {
                T_resize();
            }
            triangleArr[tMone] = t;
            tMone++;
        }
    }

    private void R_resize() {
        Rectangle[] arr = new Rectangle[rectangleArr.length + RESIZE];
        System.arraycopy(rectangleArr, 0, arr, 0, R_size());
        rectangleArr = arr;
    }

    private void T_resize() {
        Triangle[] arr = new Triangle[triangleArr.length + RESIZE];
        System.arraycopy(triangleArr, 0, arr, 0, T_size());
        triangleArr = arr;
    }

    public void remove(Point p) {
        if (p != null) {

            for (int i = 0; i < R_size(); i++) {
                if (rectangleArr[i].contains(p)) {
                    rectangleArr[i] = null;
                    rMone--;
                    i--;
                    for (int j = i + 1; j < rectangleArr.length; j++) {
                        if (rectangleArr[j] != null) {
                            rectangleArr[j - 1] = rectangleArr[j];
                            rectangleArr[j] = null;
                        }
                    }
                }
            }

            for (int i = 0; i < T_size(); i++) {
                if (triangleArr[i].contains(p)) {
                    triangleArr[i] = null;
                    tMone--;
                    i--;
                    for (int j = i + 1; j < triangleArr.length; j++) {
                        if (triangleArr[j] != null) {
                            triangleArr[j - 1] = triangleArr[j];
                            triangleArr[j] = null;
                        }
                    }
                }
            }

        }
    }

    public Triangle T_at(int p) {
        Triangle t = null;
        if (p < T_size()) {
            t = new Triangle(triangleArr[p]);
        }
        return t;
    }

    public Rectangle R_at(int p) {
        Rectangle r = null;
        if (p < R_size()) {
            r = new Rectangle(rectangleArr[p]);
        }
        return r;
    }

    public double sumArea() {
        double sum = 0;
        for (int i = 0; i < R_size(); i++) {
            Rectangle rectangle = rectangleArr[i];
            sum += rectangle.area();
        }
        for (int i = 0; i < T_size(); i++) {
            Triangle triangle = triangleArr[i];
            sum += triangle.area();
        }
        return sum;
    }

    public void translate(Point p) {
        if (p != null) {
            for (int i = 0; i < R_size(); i++) {
                Rectangle rectangle = rectangleArr[i];
                rectangle.translate(p);
            }

            for (int i = 0; i < T_size(); i++) {
                Triangle triangle = triangleArr[i];
                triangle.translate(p);
            }
        }
    }

}

