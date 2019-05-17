import java.net.*; 
import java.io.*; 

public class UrlTest{ 
    public static void main(String args[])  
                             throws MalformedURLException, IOException
    { 
        URL url = new URL("http://10.240.140.215/redmine");  
        URLConnection conn = url.openConnection(); 
        //출력 스트림 제어 
        conn.setDoOutput(true); 
        OutputStream os = conn.getOutputStream(); 
        PrintWriter out = new PrintWriter(os); 
        out.println("qt=love");  
        out.close(); 
        //입력 스트림 제어 
        String temp; 
        InputStream is = conn.getInputStream(); 
        InputStreamReader isr = new InputStreamReader(is); 
        BufferedReader br = new BufferedReader(isr); 
        while( (temp=br.readLine())!=null)
        { 
            System.out.println(temp); 
        } 
        br.close(); 
    } 
} 
