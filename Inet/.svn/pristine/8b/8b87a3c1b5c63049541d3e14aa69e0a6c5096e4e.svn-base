import java.net.*;
import java.io.*;
/**
 * @author Administrator
 *InetAddress클래스 를 이용해서
 *자신의 컴터 ip주소와 이름을 알아보자. 
 */
public class InetEx {

 public InetEx(){
  inputHostName();
 }
 private void inputHostName(){
  
  System.out.println("알고 싶은 Host PC 이름을 입력하세요[자신의 PC는 엔터]");
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//사용자 입력값을 가져오기위해 BufferedReader객체를 만든다.  
  try{
   InetAddress inet = null;
   String name = reader.readLine();
   if(name.equals("")){
    inet = InetAddress.getLocalHost();
   }else{
    inet = InetAddress.getByName(name);
   }
   System.out.println("컴퓨터이름:" + inet.getHostName());
   System.out.println("컴퓨터IP:" + inet.getHostAddress());
   reader.close();
  }catch(IOException e){
   System.out.print("지정된 이름을 찾을수 없습니다.");
   e.printStackTrace();
  }
 }
 public static void main(String[] args) {
  new InetEx();
  }
}
