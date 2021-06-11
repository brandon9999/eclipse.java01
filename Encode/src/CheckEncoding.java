import java.io.*;
public class CheckEncoding
{
  // ................
  public static void main(String[] args) throws IOException
    {
         OutputStreamWriter out = new OutputStreamWriter(System.out);
              System.out.println(out.getEncoding());
    }
}

