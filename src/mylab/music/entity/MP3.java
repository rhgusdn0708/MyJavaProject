package mylab.music.entity;

import mylab.music.interfaces.Playable;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; // MB 단위
    private int volume;

    public MP3(String title, String artist) {
        this(title, artist, "MP3", 0);
    }

    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5; // 기본 볼륨 설정
    }

    @Override
    public void play() {
        System.out.printf("%s 형식의 \"%s\" 이(가) 디지털로 재생됩니다.\n", format, title);
        System.out.println("현재 볼륨: " + volume);
    }

    @Override
    public void stop() {
        System.out.printf("%s 재생이 중지되었습니다.\n", format);
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("볼륨이 " + volume + "로 설정되었습니다.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }

    // Getters
    public int getFileSize() { return fileSize; }
    public int getVolume() { return volume; }
}