import java.io.*; 
import java.net.*; 
import java.util.*; 

public class FileInfo
{     
	public static void main(String[] args) throws MalformedURLException
	{         
		File f = new File("D:\\temp3\\demo.f");          
		PrintStream out = System.out;          
		out.println("isFile(): " + f.isFile()); //�������� �ƴ���          
		out.println("isDirectory(): " + f.isDirectory()); //���͸����� �ƴ���          
		out.println("isHidden(): " + f.isHidden()); //������������          
		out.println("lastModified(): " + f.lastModified()); //�������� ������ ��¥          
		out.println("canRead(): " + f.canRead()); //�б� �Ӽ��� ���� ��������          
		out.println("canWrite(): " + f.canWrite()); //���� �Ӽ��� ���� ��������          
		out.println("getPath(): " + f.getPath()); //��� ���           
		out.println("getAbsolutePath(): "+ f.getAbsolutePath()); //���� ���          
		out.println("getName(): " + f.getName()); //���͸� �Ǵ� ������ �̸�          
		out.println("toURL(): " + f.toURL()); //URL������ ���          
		out.println("exists(): " + f.exists()); //������ �����ϴ���          
		out.println("length(): " + f.length()); //������ ����      }  } 
	}
}