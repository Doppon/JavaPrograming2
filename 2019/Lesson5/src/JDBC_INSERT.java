import java.sql.*;

class JDBC_INSERT {

  public static void main(String[] args) {

    try {
      // ドライバクラスをロード
      Class.forName("org.postgresql.Driver"); // PostgreSQLの場合

      // データベースへ接続
      Connection con =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/test1",
                                    "oops",
                                    "pass"); // PostgreSQLの場合

      // ステートメントオブジェクトを生成
      Statement stmt = con.createStatement();
      String sql = "INSERT INTO TEST_TABLE VALUES ('A5','静御前',21,'京都府京都市')";
      
      // 更新処理を実行
      stmt.executeUpdate(sql);

      // データベースから切断
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}