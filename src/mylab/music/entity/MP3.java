package mylab.music.entity;

import mylab.music.interfaces.Playable;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; // MB ����
    private int volume;

    public MP3(String title, String artist) {
        this(title, artist, "MP3", 0);
    }

    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5; // �⺻ ���� ����
    }

    @Override
    public void play() {
        System.out.printf("%s ������ \"%s\" ��(��) �����з� ����˴ϴ�.\n", format, title);
        System.out.println("���� ����: " + volume);
    }

    @Override
    public void stop() {
        System.out.printf("%s ����� �����Ǿ����ϴ�.\n", format);
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("������ " + volume + "�� �����Ǿ����ϴ�.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("���� ũ��: " + fileSize + "MB");
    }

    // Getters
    public int getFileSize() { return fileSize; }
    public int getVolume() { return volume; }
}