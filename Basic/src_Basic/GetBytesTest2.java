import java.io.*;
import java.util.Locale;

public class GetBytesTest2
{
	public static void main(String args[])
	{
		String Str1 = new String("ab¾Ècde");
		
		try
		{
			byte[] Str2 = Str1.getBytes();
			System.out.println("Returned Value = " + Str2);
			System.out.println("Returned Value length = " + Str1.getBytes().length);

			Str2 = Str1.getBytes("UTF-8");
			System.out.println("Returned Value = " + Str2);
			System.out.println("Returned Value length = " + Str1.getBytes("UTF-8").length );
			
			Str2 = Str1.getBytes("ISO-8859-1");
			System.out.println("Returned Value = " + Str2);
			System.out.println("Returned Value length = " + Str1.getBytes("ISO-8859-1").length );			
		}
		catch(UnsupportedEncodingException e)
		{
			System.out.println("Unsupported character set");
		}
	}
	
	
	
}
