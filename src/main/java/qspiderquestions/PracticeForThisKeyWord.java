package qspiderquestions;



public class PracticeForThisKeyWord {

	double price = 250.50;
	
	public PracticeForThisKeyWord(double price) {
		this.price=price;
	}
	public void display() {
		double price = 110.15;
		//local value will be prferred over global remember
		System.out.println(price);
		System.out.println(this.price);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         double price = 77.0;
         System.out.println(price);
         PracticeForThisKeyWord obj = new PracticeForThisKeyWord(1000.00);
         obj.display();
	}

}
