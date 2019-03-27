import java.awt.*;
import java.awt.event.*;

class MyCount{

	public static void main(String[] args){

		Frame frame=new Frame("ƒJƒEƒ“ƒ^");
		frame.setSize(400,300);
		frame.setLayout(null); 

		Button button=new Button("‰Ÿ‚¹!");
		button.setLocation(200,150);
		button.setSize(100,40);
		
		TextField txt=new TextField("0");
		txt.setLocation(100,90);
		txt.setSize(200,50);

		button.addActionListener(new OseActionListener(txt));
		frame.add(button);
		frame.add(txt);
		frame.setVisible(true);
	}
}

class OseActionListener implements ActionListener{

	TextField txt;

	OseActionListener(TextField txt){
		this.txt=txt;
	}

	public void actionPerformed(ActionEvent e){
		String tmp=this.txt.getText();
		int cnt=Integer.parseInt(tmp);
		this.txt.setText(String.valueOf(cnt+1));
	}

}
