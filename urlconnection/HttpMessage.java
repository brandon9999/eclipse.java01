import java.io.*;
import java.net.*;
import java.util.*;

/**
 * HTTP ��û �޽����� �������� �����Ѵ�.
 *
 * @author �ֹ���, era13@hanmail.net
 */
public class HttpMessage {
	
	/**
	 * HTTP ���������� ����Ͽ� ������ URL
	 */
	private URL targetURL;
	
	/**
	 * POST ������� �����͸� ������ �� ���Ǵ� ��� ��Ʈ��
	 */
	private DataOutputStream out;
	
	public HttpMessage(URL targetURL) {
		this.targetURL = targetURL;
	}
	
	public InputStream sendGetMessage() throws IOException {
		return sendGetMessage(null);
	}
	
	public InputStream sendGetMessage(Properties params) throws IOException {
		String paramString = "";
		
		if (params != null) {
			paramString = "?"+encodeString(params);
		}
		URL url = new URL(targetURL.toExternalForm() + paramString);
		
		URLConnection conn = url.openConnection();
		conn.setUseCaches(false);
		return conn.getInputStream();
	}
	
	public InputStream sendPostMessage() throws IOException {
		return sendPostMessage("");
	}
	
	public InputStream sendPostMessage(Properties params) throws IOException {
		String paramString = "";
		
		if (params != null) {
			paramString = encodeString(params);
		}
		return sendPostMessage(paramString);
	}

	public InputStream sendPostMessage(String[] paramName, String[] paramValue) throws IOException {
		String paramString = "";
		
		if (paramName != null) {
			paramString = encodeString(paramName, paramValue);
		}
		return sendPostMessage(paramString);
	}
	
	private InputStream sendPostMessage(String encodedParamString) throws IOException {
		URLConnection conn = targetURL.openConnection();
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		conn.setUseCaches(false);
		
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
		out = null;
		try {
			out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(encodedParamString);
			out.flush();
		} finally {
			if (out != null) out.close();
		}
		
		return conn.getInputStream();
	}
	
	public static String encodeString(String[] paramName, String[] paramValue) {
		if (paramName.length != paramValue.length)
			throw new IllegalArgumentException("paranName.length is not equal to paramValue.length");
		
		StringBuffer sb = new StringBuffer(256);
		
		for (int i = 0 ; i < paramName.length ; i++) {
			sb.append(paramName[i] + "=" + URLEncoder.encode(paramValue[i]) );
			
			if (i < paramName.length -1) sb.append("&");
		}
		return sb.toString();
	}
	
	public static String encodeString(Properties params) {
		StringBuffer sb = new StringBuffer(256);
		Enumeration names = params.propertyNames();
		
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = params.getProperty(name);
			sb.append(URLEncoder.encode(name) + "=" + URLEncoder.encode(value) );
			
			if (names.hasMoreElements()) sb.append("&");
		}
		return sb.toString();
	}
}
