package PartA; /**
 * Created by Shlomi Alon on 19/12/2016.
 */

public class ShapeContainer {

    public static final int INIT_SIZE = 10;
    public static final int RESIZE = 10;

    public Drawable[] drawables;
    private int size;

    public ShapeContainer() {
        drawables = new Drawable[INIT_SIZE];
        size = 0;
    }

    public ShapeContainer(ShapeContainer other) {

        if (other == null) return;

        drawables = new Drawable[other.drawables.length];

        for (int i = 0; i < drawables.length; i++) {
            if (other.drawables[i] != null) {
                if (other.drawables[i] instanceof Rectangle) {
                    drawables[i] = new Rectangle((Rectangle) other.drawables[i]);
                    size++;
                } else {
                    drawables[i] = new Triangle((Triangle) other.drawables[i]);
                    size++;
                }
            }
        }
    }

    public int T_size() {
        int tMone = 0;
        for (int i = 0; i < drawables.length ; i++) {
            if(drawables[i] instanceof Triangle && drawables[i] != null)
                tMone++;
        }
        return tMone;
    }

    public int R_size() {
        int rMone = 0;
        for (int i = 0; i < drawables.length ; i++) {
            if(drawables[i] instanceof Rectangle && drawables[i] != null)
                rMone++;
        }
        return rMone;
    }

    public int size() {
        return size;
    }

    public void add(Drawable d) {
        if (d != null) {
            if (d instanceof Rectangle) {
                if (size() >= drawables.length) {
                    R_resize();
                }
                drawables[size()] =  d;
                size++;
            }
            else{
                if (size() >= drawables.length) {
                    T_resize();
                }
                drawables[size()] = d;
                size++;
            }
        }
    }

    private void R_resize() {
        Drawable[] arr = new Drawable[drawables.length + RESIZE];
        System.arraycopy(drawables, 0, arr, 0, R_size());
        drawables = arr;
    }

    private void T_resize() {
        Drawable[] arr = new Drawable[drawables.length + RESIZE];
        System.arraycopy(drawables, 0, arr, 0, T_size());
        drawables = arr;
    }

    public void remove(Point p) {
        if (p != null) {

            for (int i = 0; i < size(); i++) {
                if (drawables[i] != null){
                    if (drawables[i].contains(p)) {
                            size--;
                        }
                        for (int j = i; j < drawables.length-1; j++) {
                            drawables[j] = drawables[j+1];
                        }
                            i--;
                        }
                    }
                }
            }

    public Triangle T_at(int p) {
        Triangle t = null;
        if (p < size() && drawables[p] != null) {
            if (drawables[p] instanceof Triangle) {
                return t = (Triangle) drawables[p];
            }
        }
        return null;
    }

    public Rectangle R_at(int p) {
        Rectangle r = null;
        if (p < size() && drawables[p] != null) {
            if (drawables[p] instanceof Rectangle) {
               return r = ((Rectangle) drawables[p]);
            }
        }
        return null;
    }

    public double sumArea() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            if(drawables[i] != null)
            sum += drawables[i].area();
        }
        return sum;
    }

    public void translate(Point p) {
        if (p != null) {
            for (int i = 0; i < size(); i++) {
               if(drawables[i] !=null)
                drawables[i].translate(p);
            }
        }
    }

}

