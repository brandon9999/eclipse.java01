/** 2차원 배열(배열의 배열)을 테스트하는 예제 **/

public class Array2DimensionTest 
{     
	public static void main(String[] args) 
	{        
		int[][] src = new int[][]{{100,200,300}, {400,500,600}};        
		int[][] tar = {{701,702,703}, {704,705,706}};      
		//int[][] src의 정보출력         
		System.out.print("src.length:" + src.length + "\t");    
		System.out.print("src[0].length:" + src[0].length + "\t");    
		System.out.println("src[1].length:" + src[1].length);  
		//int[][] tar의 정보출력       
		System.out.print("tar.length:" + tar.length + "\t");   
		System.out.print("tar[0].length:" + tar[0].length + "\t");       
		System.out.println("tar[1].length:" + tar[1].length);         
		//2차원 배열의 출력      
		for(int i=0; i<src.length; i++)     
			for(int j=0; j<src[i].length; j++)
			{                
				System.out.print("src[" + i + "][" + j + "]=" + src[i][j] + "\t");      
				System.out.print("tar[" + i + "][" + j + "]=" + tar[i][j] + "\n");        
			}         
		//for문에 블록이 없으면 한 줄에 영향을 준다.     
	}
}