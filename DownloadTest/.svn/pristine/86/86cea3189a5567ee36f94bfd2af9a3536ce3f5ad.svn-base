import java.io.*;
import java.net.*;
import java.util.*;


/*
 * client.bat파일
   java DownClient %1 %2
   
JSP 사용법은 http://ip:port/Download.jsp?src=파일절대경로
이렇게 하시면 되구요.
JAVA로 하실땐
서버측에서 java DownServer {port} {파일절대경로}
클라이언트측에서 java DownClient {ip} {port}
이렇게 하시면 됩니다.
 */
public class DownClient {


    private Socket socket=null;
    private BufferedWriter out = null;


    public DownClient(String ip, int port) throws IOException {

        try {

            socket=new Socket(ip, port);
            System.out.println("[Info] connected to server.");

        } catch (IOException e) {
            throw e;
        }
    }


    public void start() {

        try {

            File file = new File("DownFile");
            byte b[] = new byte[1024];

            BufferedInputStream ins = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(file));

            int read = 0;
            try {
                while ((read = ins.read(b , 0 , 1024) ) != -1){
                    fout.write(b,0,read);
                    System.out.print("#");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(fout!=null) fout.close();
                if(ins!=null) ins.close();
            }

            System.out.println("\n[Info] download complete.");
            System.out.println("[Info] downloaded file : DownFile");

        } catch (Exception e) {
            System.out.println("[Error] problem occurred.");
            e.printStackTrace();
        } finally {
            try{ socket.close(); } catch(Exception e){ System.out.println("[Error] fail to close Socket."); };
        }

    }


    public static void main(String args[]) {

        String ip = "127.0.0.1";
        int port = 5777;

        System.out.println("Usage1 : java DownClient (IPAddress) (Port)");
        System.out.println("Usage2 : java DownClient (Port)");

        if(args.length == 1) {
            port = Integer.parseInt(args[0]);
        } else if(args.length == 2) {
            ip = args[0];
            port = Integer.parseInt(args[1]);
        } else if(args.length > 2) {
            System.out.println("[Error] too may parameters.");
            System.exit(-1);
        }

        System.out.println("[Info] IP : " + ip);
        System.out.println("[Info] Port : " + port);


        try {
            DownClient c = new DownClient(ip, port);
            c.start();
        } catch (IOException e) {
            System.out.println("[Error] fail to create socket.");
        }

    }

}