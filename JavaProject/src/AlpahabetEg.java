
public class AlpahabetEg {

	public static void main(String[] args) 
	{
		int Total=0;
		String input = "Swaroopa";
		int len=input.length();
		System.out.println("Length of the string is "+len);
		for (int i = 0; i < input.length(); i++) 
		{
			int ascii = input.charAt(i);
			System.out.println(input.charAt(i)+" Alphabet ascii code "+ascii);
			if (i == len-1) 
			{
				Total= Total * ascii;
				System.out.println(Total+"*"+ascii+"="+Total);
			}
			else if (ascii % 2 == 0)
			{
				Total= Total + ascii;	
				
			}
			else 
			{
				Total= Total - ascii;
			}
			System.out.println(Total);
		}
		System.out.println(Total);	
	}

}
