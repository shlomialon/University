package PartA;

import java.awt.*;
import java.awt.event.*;

/**
* this class is a simple the graphic frame including a paint method, 
* used for Ex2a debug process;
*/

 class MyFrame extends Frame	{ 
  // *** private data ***
  	private ShapeContainer _draws;
	// *** text area ***
  public MyFrame() {
  	this.setTitle(Const.APPLICATION_TITLE);
  	this.setSize(Const.MAX_X,Const.MAX_Y);
   	_draws = new ShapeContainer();
  	addWindowListener(new WindowAdapter() { public void
    windowClosing(WindowEvent e) { System.exit(0); } } );
}

  public void add(Triangle t) {_draws.add(t);}
  public void add(PartA.Rectangle r) {_draws.add(r);}
  
  public void paint(Graphics g) {
  	 g.setColor(Color.PINK);
  	  for(int i=0;i<_draws.R_size();i++) {
  	  	PartA.Rectangle r = _draws.R_at(i);
  	  	Point p1 = r.p1();
		  Point p2 = r.p2();
		  g.drawRect((int)p1.get_x(), (int)p1.get_y(), (int)r.dx(), (int)r.dy());
  	  }
  	  for(int i=0;i<_draws.T_size();i++) {	
	  	Triangle t = _draws.T_at(i);
	  	Point p1 = t.p1();
		  Point p2 = t.p2();
		  Point p3 = t.p3();
		  int[] xx = new int[3], yy = new int[3];
	  	xx[0] = (int)p1.get_x(); xx[1] = (int)p2.get_x(); xx[2] = (int)p3.get_x();
	  	yy[0] = (int)p1.get_y(); yy[1] = (int)p2.get_y(); yy[2] = (int)p3.get_y();
	  	g.drawPolygon(xx,yy,3);	 
  	  } // for
  }
	public void start() {	
		this.show();
		repaint(); 
	}
}