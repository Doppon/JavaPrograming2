import java.sql.*;

class JDBC_INSERT {

  public static void main(String[] args) {

    try {
      // �h���C�o�N���X�����[�h
      Class.forName("org.postgresql.Driver"); // PostgreSQL�̏ꍇ

      // �f�[�^�x�[�X�֐ڑ�
      Connection con =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/test1",
                                    "oops",
                                    "pass"); // PostgreSQL�̏ꍇ

      // �X�e�[�g�����g�I�u�W�F�N�g�𐶐�
      Statement stmt = con.createStatement();
      String sql = "INSERT INTO TEST_TABLE VALUES ('A5','�Ì�O',21,'���s�{���s�s')";
      
      // �X�V���������s
      stmt.executeUpdate(sql);

      // �f�[�^�x�[�X����ؒf
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}