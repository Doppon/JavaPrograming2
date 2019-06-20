import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Painter{

	public static void main(String[] args){

		Frame frame=new Frame("‚¨ŠG‚©‚«ƒ\ƒtƒg");
		frame.setSize(400,300);

		DrawTool dt=new DrawTool();
		frame.add(dt);

		frame.setVisible(true);
	}
}

class DrawTool extends Canvas implements MouseListener{

	int ix=0; int iy=0; int ox=0; int oy=0;

	Vector points =new Vector();
	Point p = new Point(0,0);

	DrawTool(){
		addMouseListener(this);
	}

	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		if(points.size()>1){
			for(int i=1; i< points.size(); i++){
				Point a = (Point)points.elementAt(i-1);
				Point b = (Point)points.elementAt(i);			
				g.drawLine(a.x, a.y, b.x, b.y);
			}
		}
	}

	public void mouseClicked(MouseEvent e){
		Point p = new Point(e.getX(),e.getY());
		points.add(p);
		repaint(); //Ä•`‰æ
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
}

class Point{
	public int x;
	public int y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
