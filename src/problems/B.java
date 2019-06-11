package problems;

class A
{
	public void print()
	{
		System.out.println("A");
	}
}

public class B extends A
{
	@Override
	public void print()
	{
		System.out.println("B");
	}

	public static void main(String[] args)
	{
		A a1 = new A();
		A a2 = new B();
		B b1 = (B) new A();
		B b2 = new B();
		a1.print();
		a2.print();
		b1.print();
		b2.print();
	}

}
