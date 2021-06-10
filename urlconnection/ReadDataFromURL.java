import java.net.*;
import java.io.*;

public class ReadDataFromURL {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("java ReadDataFromURL URL");
			System.exit(0);
		}
		
		URL url = new URL(args[0]);

		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		char[] buff = new char[512];
		int len = -1;
		
		while( (len = br.read(buff)) != -1) {
			System.out.print(new String(buff, 0, len));
		}
		
		br.close();
	}
}