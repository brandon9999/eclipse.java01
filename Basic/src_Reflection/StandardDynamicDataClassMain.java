/** URLClassLoader를 이용한 Class 클래스 로딩 **/

import java.net.*;

public class StandardDynamicDataClassMain
{    
	public static void main(String[] args) throws MalformedURLException,         InstantiationException, IllegalAccessException, ClassNotFoundException
	{    
		URL[] urlArray = {new URL("http://www.jabook.org:80/")};   
		URLClassLoader cLoader = new URLClassLoader(urlArray);     
		Class c = cLoader.loadClass("DynamicData");     
		Object obj = c.newInstance();     
		System.out.println(obj);  
	} 
}