package accessmodifiers;

import qspiderquestions.Student;

public class IntroToAccessModifiers extends Student{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Student student = new Student();
       //System.out.println(student.age);//this is not possible
       //student.demo("trivedi");this is not possible
       /*The non static protected members are inherited by the child classes and can access them as its own members.
        *  But we can’t access these members using the reference of the parent class.
        *   We can access non static protected members only by using child class reference. 
        */
       IntroToAccessModifiers obj = new IntroToAccessModifiers();
       System.out.println(obj.age);
       obj.demo("shubham");
	}

}
