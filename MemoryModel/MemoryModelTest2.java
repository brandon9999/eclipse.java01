class MemoryModelTest2 
{
      static int x=0;
      public static void main(String args[]) 
      {
         int a=10, b=20, c;
   
         c = add(a, b);
		 System.out.println(c);
		 System.out.println("bbbbbbbbbbbbbb"); 
      }
      static int add(int a, int b) 
      {
         return(a + b);
      }
   }