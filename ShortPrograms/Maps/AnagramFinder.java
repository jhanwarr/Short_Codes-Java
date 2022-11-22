import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AnagramFinder
{
	private Map<String, LinkedList<String>> data= new HashMap<>();

	public static void main(String[] args)
	{
		AnagramFinder obj = new AnagramFinder();

		try
		{
			Scanner sc = new Scanner(new File(getFileName()));

			while(sc.hasNextLine())
			{
				String s = sc.nextLine();
				obj.addToMap(s);
			}

			System.out.println("Anagrams : ");
			for (LinkedList<String> list : obj.data.values()) 
			{
				if (list.size() >= 2) 
					System.out.println(list);
			}

			sc.close();
		}

		catch(FileNotFoundException e) 
		{
			System.out.println("The File not found");
		}
	}

	public String getFileName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the file : ");
		return sc.nextLine();
	}

	public void addToMap(String s) 
	{
		String k = Anagrams.build(s);
		LinkedList<String> list = data.get(k);
		
		if (list == null) 
		{
			list = new LinkedList<String>();
			data.put(k, list);
		}

		list.add(s);
	}
}