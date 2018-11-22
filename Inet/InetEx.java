import java.net.*;
import java.io.*;
/**
 * @author Administrator
 *InetAddressŬ���� �� �̿��ؼ�
 *�ڽ��� ���� ip�ּҿ� �̸��� �˾ƺ���. 
 */
public class InetEx {

 public InetEx(){
  inputHostName();
 }
 private void inputHostName(){
  
  System.out.println("�˰� ���� Host PC �̸��� �Է��ϼ���[�ڽ��� PC�� ����]");
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//����� �Է°��� ������������ BufferedReader��ü�� �����.  
  try{
   InetAddress inet = null;
   String name = reader.readLine();
   if(name.equals("")){
    inet = InetAddress.getLocalHost();
   }else{
    inet = InetAddress.getByName(name);
   }
   System.out.println("��ǻ���̸�:" + inet.getHostName());
   System.out.println("��ǻ��IP:" + inet.getHostAddress());
   reader.close();
  }catch(IOException e){
   System.out.print("������ �̸��� ã���� �����ϴ�.");
   e.printStackTrace();
  }
 }
 public static void main(String[] args) {
  new InetEx();
  }
}
