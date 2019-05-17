import java.net.*; 
import java.io.*; 

public class UrlTest{ 
    public static void main(String args[])  
                             throws MalformedURLException, IOException
    { 
    	//--------------------------------------------------------------
    	// 프록시 설정
    	//--------------------------------------------------------------
        System.setProperty("http.proxyHost", "swp.sec.samsung.net") ;
        System.setProperty("http.proxyPort", "8088");    	
    	
        URL url = new URL("https://tims.tmax.co.kr/login.html");  
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
