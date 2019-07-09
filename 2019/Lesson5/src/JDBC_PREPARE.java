import java.sql.*;

class JDBC_PREPARE {

  public static void main(String[] args) {

    try {
      // �h���C�o�N���X�����[�h
      Class.forName("org.postgresql.Driver"); // PostgreSQL�̏ꍇ

      // �f�[�^�x�[�X�֐ڑ�
      Connection con =
        DriverManager.getConnection("jdbc:postgresql://localhost:5432/test1",
                                    "oops",
                                    "pass"); // PostgreSQL�̏ꍇ

      // PrepareStatement�I�u�W�F�N�g�𐶐�
      PreparedStatement prestmt;
      // �v���R���p�C���p��SQL���쐬(?�ɒl������j
      String sql = "INSERT INTO TEST_TABLE VALUES (?,?,?,?)";

      prestmt = con.prepareStatement(sql);

	String[] ID = {"6", "7", "8"};
	String[] name = {"���򏃈�Y", "��{���n", "�O�����"};
	int[] age = {62,75,61};
	String[] address = {"�_�ސ쌧���{��s", "���m�����m�s", "��ʌ��z�J�s"};

	for(int i = 0; i < 3; i++) {
	     // �l���Z�b�g
	     prestmt.setString(1, ID[i]);
	     prestmt.setString(2, name[i]);
	     prestmt.setInt(3, age[i]);
	     prestmt.setString(4, address[i]);
      	     // �X�V���������s
	     prestmt.executeUpdate();
	}
      // �f�[�^�x�[�X����ؒf
      prestmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}