
public class FibonacciSeriesEg {

	public static void main(String[] args) 
	{
		int num1=0,num2=1,num3,count=100;
		int[] RevFibonacci=new int[100];
		RevFibonacci[0]=0;
		RevFibonacci[1]=1;
		System.out.print(num1+" "+num2);//printing 0 and 1  
		for(int i=2;i<count;i++)//loop starts from 2 because 0 and 1 are already printed  
		{  
		  num3=num1+num2;  
		  System.out.print(" "+num3);  
		  RevFibonacci[i]=num3;// Storing into an array
		  num1=num2;  
		  num2=num3;
		}
		System.out.println("");
		System.out.println("Reverse Order");
		for (int j = 99; j >=0; j--) 
		{
		  System.out.print(RevFibonacci[j]+" ");
		}
	}

}
