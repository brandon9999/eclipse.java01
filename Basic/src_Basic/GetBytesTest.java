import java.io.UnsupportedEncodingException;

public class GetBytesTest {

  public static void main(String[] arg) {
    String text = "To¾È";
    byte[] textArray = text.getBytes();
    
    for(byte b: textArray)
    {
      System.out.println(b);
    }
    
    System.out.println(textArray.length);
    

    try
    {
        String[] reqGetEncoding    = {"UTF-8", "KSC5601", "ISO-8859-1"};
        String[] reqPutEncoding    = {"UTF-8", "KSC5601", "ISO-8859-1"};
        
        
            	
               
        for (int i = 0;i < reqGetEncoding.length;i++) 
        {
            for (int j = 0;j < reqPutEncoding.length;j++) 
            {
                String strGet = new String(text.getBytes(reqGetEncoding[i]), reqPutEncoding[j]);
            	System.out.println("From " + reqGetEncoding[i] + " To " + reqPutEncoding[j] + " => " + strGet);
            	byte[] strGetArray = strGet.getBytes();
            	System.out.println(strGetArray.length);
            }
        }
    }
	catch(UnsupportedEncodingException e)
	{
		System.out.println("Unsupported character set");
	}    

  }
}
