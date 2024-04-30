package sec02.exan01;

public class CarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		System.out.println("myCar.model : "+myCar.model);
		
		int s = myCar.speed;
		System.out.println(s);
		
		myCar.speed=190;
		System.out.println("myCar.speed : "+myCar.speed);
		
		Car myCar2=new Car();
		myCar2.speed=60;
		
		System.out.println("myCar.speed : "+myCar.speed);
		System.out.println("myCar2.speed : "+myCar2.speed);
		
		Car[] car=new Car[3];
		car[0] =new Car();
		
		Car[] car2=new Car[] {null, new Car(), new Car()};
		
		double r = Math.random();
		
		
		
		
	}

}
