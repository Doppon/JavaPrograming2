import java.io.*;
import java.net.*;

class TCP_Client {
  public static void main(String[] args) {

    int port=10007;
    
    try {
      Socket skt=new Socket("127.0.0.1",port);
      OutputStreamWriter oSW
        =new OutputStreamWriter(skt.getOutputStream());
      PrintWriter outS=new PrintWriter(oSW,true);
      InputStreamReader iSR
        =new ( B )(skt.getInputStream());
      BufferedReader inS= new BufferedReader(iSR);
      
      if(args.length==0){
        outS.println("");
      }else{
        outS.println(args[0]);
      }
      
      String tmpString="";
      while((tmpString=inS.readLine())!=null){
          System.out.println(tmpString);
      }
      inS.close();
      outS.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
