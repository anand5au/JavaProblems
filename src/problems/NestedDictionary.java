package problems;

import java.util.TreeMap;

public class NestedDictionary
{
	static int currPosition = 1;

	private static String sortDictionary(String s)
	{
		TreeMap<String, String> tm = new TreeMap<String, String>();
		StringBuilder builder = new StringBuilder();
		String key = "";
		for (; currPosition < s.length(); currPosition++)
		{
			if (s.charAt(currPosition) == ':')
			{
				key = builder.toString();
				builder.delete(0, builder.length());
			}
			else if (s.charAt(currPosition) == ',')
			{
				tm.put(key, builder.toString());
				builder.delete(0, builder.length());
			}
			else if (s.charAt(currPosition) == '}')
			{
				tm.put(key, builder.toString());
				break;
			}
			else if (s.charAt(currPosition) == '{')
			{
				currPosition++;
				builder.append(sortDictionary(s));
			}
			else
			{
				builder.append(s.charAt(currPosition));
			}
		}
		return tm.toString();
	}

	public static void main(String[] args)
	{
		String s = "{b:{cb:{cba:cranberry,bba:{cba:{cba:cranberry,bba:ball,hba:hollywood},bba:ball,hba:hollywood},hba:hollywood},bb:black},a:apple,c:cherry}";
		System.out.println(sortDictionary(s));
	}

}
