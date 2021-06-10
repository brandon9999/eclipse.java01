import java.net.*;
import java.io.*;
import java.util.Properties;

public class SearchFromEmpas {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("java SearchFromEmpas °Ë»ö¾î");
			System.exit(0);
		}
		
		URL url = new URL("http://search.empas.com/search/all.html");
		HttpMessage httpMessage = new HttpMessage(url);
		
		Properties prop = new Properties();
		prop.setProperty("q", args[0]);
		prop.setProperty("m", "X");
		prop.setProperty("s", "s");
		prop.setProperty("e", "1");
		prop.setProperty("n", "10");
		
		InputStream is = httpMessage.sendGetMessage(prop);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		char[] buff = new char[512];
		int len = -1;
		
		while( (len = br.read(buff)) != -1) {
			System.out.print(new String(buff, 0, len));
		}
		br.close();
	}
}
