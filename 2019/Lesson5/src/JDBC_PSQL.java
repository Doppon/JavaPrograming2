import java.sql.*;

public class JDBC_PSQL {

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
      String sql = "SELECT * FROM TEST_TABLE";

      // �N�G���[�����s���Č��ʃZ�b�g���擾
      ResultSet rs = stmt.executeQuery(sql);

      // �������ꂽ�s�������[�v
      while(rs.next()){
        // NAME���擾
        String sName = rs.getString("NAME");
        // AGE���擾
        int  age = rs.getInt("AGE");
        // ADDRESS���擾
        String sAddr = rs.getString("ADDRESS");
        // �\��
        System.out.println(sName + " " + age + " " + sAddr);
      }
      // �f�[�^�x�[�X����ؒf
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}