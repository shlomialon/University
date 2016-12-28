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
        drawables = new Drawable[other.drawables.length];
        if (other == null) return;
        for (int i = 0; i < drawables.length; i++) {
            if (other.drawables[i] != null) {
                if (other.drawables[i] instanceof Rectangle) {
                    drawables[i] = new Rectangle((Rectangle) other.drawables[i]);
                } else {
                    drawables[i] = new Triangle((Triangle) other.drawables[i]);
                }
            }
            size = drawables.length;
        }
    }

    public int T_size() {
        int tMone = 0;
        for (int i = 0; i < size ; i++) {
            if(drawables[i] instanceof Triangle && drawables[i] != null)
                tMone++;
        }
        return tMone;
    }

    public int R_size() {
        int rMone = 0;
        for (int i = 0; i < size ; i++) {
            if(drawables[i] instanceof Rectangle && drawables[i] != null)
                rMone++;
        }
        return rMone;
    }

    public int size() {
        return R_size() + T_size();
    }

    public void add(Drawable d) {
        if (d != null) {
            if (d instanceof Rectangle) {
                if (size() >= drawables.length) {
                    resize();
                }
                drawables[size()] = d;
                size++;
            }
            else{
                if (size() >= drawables.length) {
                    resize();
                }
                drawables[size()] = d;
                size++;
            }
        }
    }

    private void resize() {
        Drawable temp[] = new Drawable[this.size + RESIZE];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.drawables[i];
        }
        this.drawables = temp;
    }

    public void remove(Point p) {
        if (p != null) {
            for (int i = 0; i < size; i++) {
                if (drawables[i] != null && drawables[i].contains(p)){
                        for (int j = i; j < drawables.length-1; j++) {
                            drawables[j] = drawables[j+1];
                        }
                    this.drawables[size-1] = null;
                    this.size--;
                    i--;
                        }
                    }
                }
            }

    public Triangle T_at(int p) {
        int index = 0;
        if (p < size() && drawables[p] != null) {
            for (int i = 0; i < size; i++) {
                if (drawables[i] instanceof Triangle) {
                    if (index == p) {
                        return new Triangle((Triangle) drawables[i]);
                    }
                    index++;
                }
            }
        }
        return null;
    }

    public Rectangle R_at(int p) {
        int index = 0;
        if (p < size() && drawables[p] != null) {
            for (int i = 0; i < size; i++) {
                if (drawables[i] instanceof Rectangle) {
                    if(index == p) {
                        return new Rectangle((Rectangle) drawables[i]);
                    }
                    index++;
                }
            }
        }
        return null;
    }

    public double sumArea() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            if(drawables[i] instanceof Rectangle && drawables[i] != null){
                Drawable drawable = drawables[i];
                sum += drawable.area();
            }else if(drawables[i] instanceof Triangle && drawables[i] != null){
                Drawable drawable = drawables[i];
                sum += drawable.area();
            }
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

