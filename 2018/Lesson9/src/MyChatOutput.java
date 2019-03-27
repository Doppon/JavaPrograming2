import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MyChatOutput {
	public static void main(String[] args) {
		Frame frame = new Frame("チャット(出力)");
		frame.setSize(400, 650);
		frame.setLayout(null);
		TextArea txtArea = new TextArea("");
		txtArea.setSize(300, 550);
		txtArea.setLocation(50, 50);
		frame.add(txtArea);
		frame.setVisible(true);

		try {
			Class.forName("org.posgresql.Driver");
			Connection chatConnect = DriverManager.getConnection("jdbc:postgresql://akita.data.ise.shibaura-it.ac.jp:5432/firstdb",
				"shibaura",
				"Toyosu");
			Statement state = chatConnect.createStatement();
			String sql = "SELECT * FROM T_LOG ORDER BY WEITTENDATE DESC";

			while(true) {
				ResultSet chatResult = state.executeQuery(sql);
				for(int i=0; i<20; i++) {
					chatResult.next();
					String Name = chatResult.getString("NAME");
					String Message = chatResult.getString("MESSAGE");
					txtArea.append(" - (" + chatResult.getTimestamp("WRITTENDATE") + "(" + Name + "))" + Message + "\n");
				}
				Thread.sleep(10000);
				txtArea.setText("");
			}
		} catch(Exception ei) {
			ei.printStackTrace();
		}
	}
}
