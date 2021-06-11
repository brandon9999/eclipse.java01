import java.util.Locale;


public class LocaleTest 
{
	public static void main(String args[])
	{
		Locale locale = Locale.getDefault();
		String s = "";
		s=locale.getCountry();
		System.out.println(s);
		s=locale.getDisplayCountry();
		System.out.println(s);
		s=locale.getDisplayName();
		System.out.println(s);
		s=locale.getLanguage();
		System.out.println(s);
		s=System.getProperty("os.name");
		System.out.println(s);
	}
}
