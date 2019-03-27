import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class MyChatInput {
	public static void main(String[] args) {
		Frame frame = new Frame("チャット (入力) ");
		frame.setSize(400, 650);
		frame.setLayout(null);

		Button button = new Button("発言");
		button.setLocation(150, 150);
		button.setSize(100, 40);

		TextField txt = new TextField("");
		OneActionListener Isnr = new OneActionListener(txt);
		button.addActionListener(Isnr);
		txt.setLocation(100, 30);
		txt.setSize(200, 50);
		frame.add(button);
		frame.add(txt);
		frame.setVisible(true);
	}
}

class OneActionListener implements ActionListener {
	TextField txt;
	OneActionListener(TextField txt) {
		this.txt = txt;
	}
	public void actionPerformed(ActionEvent e) {
		String msg  = this.txt.getText();
		try {
			Class.forName("org.posgresql.Driver");
			Connection chatConnect = DriverManager.getConnection("jdbc:postgresql://akita.data.ise.shibaura-it.ac.jp:5432/firstdb",
				"shibaura",
				"Toyosu");
			PreparedStatement preState;
			String sql = "INSERT INTO T_LOG VALUES (?,?,?,?)";
			preState = chatConnect.prepareStatement(sql);
			String ID = "al16060";
			String NAME = "Doppo Sekino";
			String MESSAGE = msg;
			preState.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			preState.setString(1, ID);
			preState.setString(2, NAME);
			preState.setString(3, MESSAGE);
			preState.executeUpdate();

			chatConnect.close();
			preState.close();
		} catch(Exception er) {
			er.printStackTrace();
		}
		this.txt.setText("");
	}
}
