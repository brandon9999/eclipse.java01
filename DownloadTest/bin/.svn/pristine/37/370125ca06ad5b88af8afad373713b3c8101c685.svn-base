import java.io.*;
import java.net.*;
import java.util.*;

/*
 * server.bat파일
   java DownServer %1 %2
   
JSP 사용법은 http://ip:port/Download.jsp?src=파일절대경로
이렇게 하시면 되구요.
JAVA로 하실땐
서버측에서 java DownServer {port} {파일절대경로}
클라이언트측에서 java DownClient {ip} {port}
이렇게 하시면 됩니다.

 */

public class DownServer {


    private ServerSocket serverSocket = null;
    private Socket socket = null;


    public DownServer(int port) throws IOException {
        try {

            serverSocket = new ServerSocket(port);
            System.out.println("[Info] waiting for client...");

        } catch (IOException e) {
            throw e;
        }
    }


    public void start(String src) {

        try {

            while (true) {

                try {
                    socket = serverSocket.accept();
                    System.out.println("[Info] connected to client");
                } catch (IOException ie) {
                    System.out.println("[Error] fail to connect.");
                }

                download(src);

            }

        } catch (Exception e) {
            System.out.println("[Error] problem occurred.");
            e.printStackTrace();
        } finally {
            try{ serverSocket.close(); } catch(Exception e){ System.out.println("[Error] fail to close ServerSocket."); };
            try{ socket.close(); } catch(Exception e){ System.out.println("[Error] fail to close Socket."); };
        }
    }


    public void download(String src) {

        try {

            String separator = System.getProperty("file.separator");
            int idx =  src.lastIndexOf(separator);
            String srcDir = src.substring(0, idx);
            String srcFile = src.substring(idx+1);
            File sourcefile = new File(srcDir, srcFile);

            byte b[] = new byte[1024];

            try {

                if ( sourcefile!= null && sourcefile.isFile()) {

                    BufferedInputStream fin = new BufferedInputStream(new FileInputStream(sourcefile));
                    BufferedOutputStream outs = new BufferedOutputStream(socket.getOutputStream());

                    int read = 0;
                    try {
                        while ((read = fin.read(b , 0 , 1024) ) != -1){
                            outs.write(b,0,read);
                            System.out.print("#");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if(outs!=null) outs.close();
                        if(fin!=null) fin.close();
                    }

                    System.out.println("\n[Info] download complete.");

                } else {
                    System.out.println("[Error] no such file.");
                }


            } catch(Exception ex) {
                System.out.println("[Error] fail to download.");
                ex.printStackTrace();
            }

        } catch(Exception e) {
            System.out.println("[Error] fail to download.");
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {

        int port = 5777;
        String src = "C:\\작업중\\license";

        System.out.println("Usage1 : java DownServer");
        System.out.println("Usage2 : java DownServer {absolute-file-path}");
        System.out.println("Usage3 : java DownServer {port} {absolute-file-path}");

        if (args.length == 1) {
            src = args[0];
        } if (args.length == 2) {
            port = Integer.parseInt(args[0]);
            src = args[1];
        } else if (args.length > 2) {
            System.out.println("[Error] too may parameters.");
            System.exit(-1);
        }

        System.out.println("[Info] Port : " + port);
        System.out.println("[Info] File : " + src);

        try {
            DownServer s = new DownServer(port);
            s.start(src);
        } catch (IOException e) {
            System.out.println("[Error] fail to create socket.");
        }

    }

}