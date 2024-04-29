package qspiderquestions;


public class StaticAndNonStaticBlocks {
	static int age;
	String name;
	static {
		age=10;
	}
	static {
		age=20;
	}
	{
		System.out.println("non static block 1");
	}
	{
		System.out.println("non static block 2");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" understanding blocks");
System.out.println(age);

		
	}
	static {
		System.out.println("static block");
	}

}
