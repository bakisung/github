package f_oop2;

public abstract class Animal {

	void run() {
		System.out.println("달려간다~~~");
	}
	
	abstract void sound();
	
}

class Dog extends Animal {

	@Override
	void sound() {
		System.out.println("멍멍!!");
	}
	
}

class Tiger extends Animal{

	@Override
	void sound() {
		
	}
	
}

class Dolphin extends Animal {

	@Override
	void sound() {
		System.out.println("끼익~");
	}
	
}