import java.net.*;

class InetTest {
public static void main(String args[] ) {
    for(int i=0; i<1000; i++) {
    try {
        InetAddress inet = InetAddress.getLocalHost();
        String str = inet.getHostName();
        System.out.println("str :" + str);
        Thread.sleep(1000);
    }catch(Exception e) {
        e.printStackTrace();
    }
    }
}
}