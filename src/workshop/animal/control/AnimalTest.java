package workshop.animal.control;

import workshop.anmial.entity.Animal;
import workshop.anmial.entity.Cat;
import workshop.anmial.entity.Pet;

public class AnimalTest {

	public static void main(String[] args) {
		//Cat ��ü�� �����ϴ� 3���� ���
		Cat cat1 = new Cat(); //5��
		Pet cat2 = new Cat(); //3��
		Animal cat3 = new Cat();//2��
		
		//Pet�� ���� ��� ���� �޼��� 
		cat1.setName("��");
		System.out.println(cat1.getName());
		cat1.play();		
		//Animal�� ���� ��� ���� �޼��� 
		cat1.eat();
		cat1.wark();
		
		//Pet�� ���� ��� ���� �޼��� 
		cat2.setName("�̿�");
		System.out.println(cat2.getName());
		cat2.play();
		
		//Animal�� ���� ��� ���� �޼���
		cat3.eat();
		cat3.wark();
		
		

	}

}