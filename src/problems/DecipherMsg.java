package problems;

public class DecipherMsg
{
	public static void main(String args[])
	{
		// String cipher = "jussDs sfsfs fwfsldfms Atvt hrqgse, Cnikg";
		String cipher = "Li, ailu jw au facntll";
		String plain = decipher(cipher);
		System.out.println(plain);
	}

	private static String decipher(String encrypted_message)
	{
		StringBuilder plain = new StringBuilder("");
		String key = "8251220";
		int keycounter = 0;
		for (int i = 0; i < encrypted_message.length(); i++)
		{
			char temp = encrypted_message.charAt(i);
			if (keycounter == key.length())
				keycounter = 0;
			if (temp >= 65 && temp <= 90)
			{
				char plainChar = (char) (encrypted_message.charAt(i)
						- Character.getNumericValue(key.charAt(keycounter)));
				if (plainChar < 65)
				{
					int diff = 65 - plainChar;
					plainChar = (char) (91 - diff);
				}
				System.out.println(encrypted_message.charAt(i));
				System.out.println(key.charAt(keycounter));
				System.out.println(plainChar);
				System.out.println();
				plain.append(plainChar);
				keycounter++;
			}
			else if (temp >= 97 && temp <= 122)
			{
				char plainChar = (char) (encrypted_message.charAt(i)
						- Character.getNumericValue(key.charAt(keycounter)));
				if (plainChar < 97)
				{
					int diff = 97 - plainChar;
					plainChar = (char) (123 - diff);
				}
				System.out.println(encrypted_message.charAt(i));
				System.out.println(key.charAt(keycounter));
				System.out.println(plainChar);
				System.out.println();
				plain.append(plainChar);
				keycounter++;
			}
			else
			{
				plain.append(temp);
			}
		}
		return plain.toString();
	}
}
