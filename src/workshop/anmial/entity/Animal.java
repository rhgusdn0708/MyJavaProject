package workshop.anmial.entity;

public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
		
	}
	
	public abstract void eat();
	
	public void wark() {
		System.out.println("������ " + legs +  "�߷� �ȴ´�.");
	}
	
}
