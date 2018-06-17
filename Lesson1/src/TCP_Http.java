import java.io.*;
import java.net.*;

class TCP_Http {
  public static void main(String[] args) {

    String serverName;

    serverName = "orion.data.ise.shibaura-it.ac.jp";
    
    int portNo = 80;

    InetAddress sAdr;
    StringBuffer sBuff = new StringBuffer();

    try {
      // ホスト名からIPアドレスに変換
      sAdr = InetAddress.getByName(serverName);

      //Socketの生成
      Socket skt = new Socket(sAdr, portNo);

      // サーバーへのデータ送信用ライター
      BufferedWriter outS
        = new BufferedWriter(
          new OutputStreamWriter(skt.getOutputStream())
        );

      BufferedReader inS
        = new BufferedReader(
          new InputStreamReader(skt.getInputStream())
        );

      String[] msg = {"GET /index.html HTTP/1.0\r\n", "\r\n"};

      for(int i=0; i<msg.length; i++){
        outS.write(msg[i]);
      }
      outS.flush();

      String tmpString;

      while((tmpString = inS.readLine()) != null){
        sBuff.append(tmpString + "\n");
      }

      System.out.println(sBuff.toString());
      outS.close();
      inS.close();
      skt.close();
    } catch(UnknownHostException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
