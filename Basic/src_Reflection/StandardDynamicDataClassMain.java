/** URLClassLoader�� �̿��� Class Ŭ���� �ε� **/

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