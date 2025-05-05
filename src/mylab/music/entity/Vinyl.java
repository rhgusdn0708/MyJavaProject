package mylab.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm; // ȸ�� �ӵ� (33 �Ǵ� 45)

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void play() {
        System.out.printf("���̳� ���ڵ� \"%s\" ��(��) %d rpm���� ����˴ϴ�.\n", title, rpm);
    }

    public void clean() {
        System.out.println("���̳� ���ڵ带 û���մϴ�.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("ȸ�� �ӵ�: " + rpm + " rpm");
    }

    // Getter
    public int getRpm() { return rpm; }
}