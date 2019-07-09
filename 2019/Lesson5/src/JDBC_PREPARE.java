import java.sql.*;

class JDBC_PREPARE {

  public static void main(String[] args) {

    try {
      // ドライバクラスをロード
      Class.forName("org.postgresql.Driver"); // PostgreSQLの場合

      // データベースへ接続
      Connection con =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/test1",
                                    "oops",
                                    "pass"); // PostgreSQLの場合

      // PrepareStatementオブジェクトを生成
      PreparedStatement prestmt;
      // プリコンパイル用にSQLを作成(?に値が入る）
      String sql = "INSERT INTO TEST_TABLE VALUES (?,?,?,?)";

      prestmt = con.prepareStatement(sql);

	String[] ID = {"6", "7", "8"};
	String[] name = {"小泉純一郎", "坂本竜馬", "三沢光晴"};
	int[] age = {62,75,61};
	String[] address = {"神奈川県横須賀市", "高知県高知市", "埼玉県越谷市"};

	for(int i = 0; i < 3; i++) {
	     // 値をセット
	     prestmt.setString(1, ID[i]);
	     prestmt.setString(2, name[i]);
	     prestmt.setInt(3, age[i]);
	     prestmt.setString(4, address[i]);
      	     // 更新処理を実行
	     prestmt.executeUpdate();
	}
      // データベースから切断
      prestmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}