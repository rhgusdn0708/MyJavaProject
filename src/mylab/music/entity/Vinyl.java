package mylab.music.entity;

public class Vinyl extends MusicMedia {
    private int rpm; // 회전 속도 (33 또는 45)

    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }

    @Override
    public void play() {
        System.out.printf("바이날 레코드 \"%s\" 이(가) %d rpm으로 재생됩니다.\n", title, rpm);
    }

    public void clean() {
        System.out.println("바이날 레코드를 청소합니다.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("회전 속도: " + rpm + " rpm");
    }

    // Getter
    public int getRpm() { return rpm; }
}