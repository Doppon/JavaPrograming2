import java.sql.*;

public class JDBC_PSQL {

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
      String sql = "SELECT * FROM TEST_TABLE";

      // クエリーを実行して結果セットを取得
      ResultSet rs = stmt.executeQuery(sql);

      // 検索された行数分ループ
      while(rs.next()){
        // NAMEを取得
        String sName = rs.getString("NAME");
        // AGEを取得
        int  age = rs.getInt("AGE");
        // ADDRESSを取得
        String sAddr = rs.getString("ADDRESS");
        // 表示
        System.out.println(sName + " " + age + " " + sAddr);
      }
      // データベースから切断
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}