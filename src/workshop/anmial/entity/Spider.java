package workshop.anmial.entity;

public class Spider extends Animal{
	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("Spider´Â ÀÛÀº ¹ú·¹¸¦ ¸Ô¾î¿ä!!");		
	}
}
