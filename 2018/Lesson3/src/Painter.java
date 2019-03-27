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
