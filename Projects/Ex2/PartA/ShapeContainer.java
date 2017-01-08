
/**
 * Created by Shlomi Alon on 19/12/2016.
 */
package PartA;

class ShapeContainer {

    private static final int INIT_SIZE = 10;
    private static final int RESIZE = 10;
    private Drawable[] drawables;
    private int size;

    ShapeContainer() {
        drawables = new Drawable[INIT_SIZE];
        size = 0;
    }

    ShapeContainer(ShapeContainer other) {
        drawables = new Drawable[other.drawables.length];
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

    int T_size() {
        int tMone = 0;
        for (int i = 0; i < size ; i++) {
            if(drawables[i] instanceof Triangle && drawables[i] != null)
                tMone++;
        }
        return tMone;
    }

    int R_size() {
        int rMone = 0;
        for (int i = 0; i < size ; i++) {
            if(drawables[i] instanceof Rectangle && drawables[i] != null)
                rMone++;
        }
        return rMone;
    }

    int size() {
        return R_size() + T_size();
    }

    void add(Drawable d) {
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
        System.arraycopy(this.drawables, 0, temp, 0, this.size);
        this.drawables = temp;
    }

    void remove(Point p) {
        if (p != null) {
            for (int i = 0; i < size; i++) {
                if (drawables[i] != null && drawables[i].contains(p)){
                    System.arraycopy(drawables, i + 1, drawables, i, drawables.length - 1 - i);
                    this.drawables[size-1] = null;
                    this.size--;
                    i--;
                        }
                    }
                }
            }

    Triangle T_at(int p) {
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

    Rectangle R_at(int p) {
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

    double sumArea() {
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

    void translate(Point p) {
        if (p != null) {
            for (int i = 0; i < size(); i++) {
               if(drawables[i] !=null)
                drawables[i].translate(p);
            }
        }
    }


    public void minMaxPerimeter(int num){
        double max=-1;
        double min=-1;
        int comparisons=0;

        if(drawables[0]!=null && drawables[1]!=null){
            max=drawables[0].perimeter();
            min=drawables[1].perimeter();
            comparisons++;
        }
        if(drawables[1].perimeter()>drawables[0].perimeter())
        {
            max=drawables[1].perimeter();
            min=drawables[0].perimeter();
        }
        for (int i = 2;(( i < this.drawables.length-1)&&(drawables[i]!=null&&drawables[i+1]!=null)); i=i+2) {
            comparisons++;
            if(drawables[i].perimeter()>drawables[i+1].perimeter())
            {
                comparisons=comparisons+2;
                if(drawables[i].perimeter()>max){
                    max=drawables[i].perimeter();
                }
                if(drawables[i+1].perimeter()<min){
                    min=drawables[i+1].perimeter();
                }

            }
            else
            {
                comparisons=comparisons+2;
                if(drawables[i+1].perimeter()>max){
                    max=drawables[i+1].perimeter();
                }
                if(drawables[i].perimeter()<min){
                    min=drawables[i].perimeter();
                }
            }
        }
        //if number of elements is odd, we check the last element
        if(this.drawables.length%2!=0 && drawables[drawables.length-1]!=null) //odd
        {
            comparisons++;
            if(drawables[this.drawables.length-1].perimeter()>max)
                max=drawables[this.drawables.length-1].perimeter();
            else
            {
                if(drawables[this.drawables.length-1].perimeter()<min)
                    min=drawables[this.drawables.length-1].perimeter();
                comparisons++;
            }
        }
        System.out.println("number of comparision: " + comparisons);
        System.out.println("max perimeter: " + max);
        System.out.println("min perimeter: " + min);
    }

}

