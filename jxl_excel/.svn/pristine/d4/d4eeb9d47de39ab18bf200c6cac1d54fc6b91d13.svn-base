import java.io.*; // 파일 입력 관련 클래스
import jxl.*; // jxl 관련 클래스

public class Jxl_Read
{
	public static void  main(String args[]) throws FileNotFoundException, IOException,jxl.read.biff.BiffException
	{
		// 이번에도 파일과 엑셀 파일 입력 관련 예외 선언을 미리 해주고 들어옵니다.
	  Workbook myWorkbook = Workbook.getWorkbook(new File("D:\\DevHome\\AppLibrary\\jxl_excel\\testexcel.xls"));
	  Sheet mySheet = myWorkbook.getSheet(0); // 정확한 쉬트를 입력 받아서...
  
	  System.out.print("학번\t성명\t비고\t\n"); // 엑셀 제목을 적어 주고
  
	  for(int no=1;no<6;no++)
	  { // 행의 갯수 만큼 돌리고
	      for(int i=0;i<3;i++)
		  { // 열의 갯수 만큼 돌려서
	         Cell myCell = mySheet.getCell(i,no); // 셀의 행과 열의 정보를 가져온 후...
                  
	         System.out.print(myCell.getContents()+"\t"); // 텝의 거리 만큼 열을 나열 하고...
	         //Quick and dirty function to return the contents of this cell as a string. 이라고 API에 쓰여 있더군요.
	      }
	      System.out.println(); // 행이 바뀔 때 마다 개행하여 출력해 보셈.
	  }
	}
} 
  
