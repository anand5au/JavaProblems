package problems;

// this program will compile and run w/o any error regardless of Test1 extending Test (javac Test.java)
// java Test - no output
// java Test1 - hello
// Only constraint - filename should match with public class name.
// A java file can have ony one public class, but it can have multiple classes with one main method each
// On compiling such a class multiple class files are created and they can be run separately

public class Test
{

}

class Test1 extends Test
{
	public static void main(String[] args)
	{
		System.out.println("hello");
	}
}
