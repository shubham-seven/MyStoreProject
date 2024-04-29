package qspiderquestions;

public  class Student {
	
	static int x =5;
	String name = "shubham";
protected	int age = 31;
	
	
	public Student() {
		
	}
	
	public Student(String name,int age) {
		this.name=name;
		this.age=age;
		demo("baba");
	}
	protected void demo(String str) {
		System.out.println(str);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Student s1 = new Student("rakesh", 20);
         Student s2 = new Student("prakash", 25);
         System.out.println("Name "+s1.name +" Age "+s1.age);
         System.out.println(s2.name+s2.age);
         s1.demo("john");
         s2.demo("mark");
         
         //3 ways to access static member of class
         //Via object reference variable
         System.out.println(s1.x);
         //Via variable name directly
         System.out.println(x);
         //Via className
         System.out.println(Student.x);
         
        

	}
	
	
}
