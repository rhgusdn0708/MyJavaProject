package mylab.music.control;

import mylab.music.entity.*;
import mylab.music.interfaces.Playable;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("������������ ���� ��� �ý��� �׽�Ʈ ������������");

        // MP3 �׽�Ʈ
        System.out.println("\n���� MP3 �׽�Ʈ ����");
        MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 6);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(5);
        mp3.play();
        mp3.stop();

        // Vinyl �׽�Ʈ
        System.out.println("\n���� Vinyl �׽�Ʈ ����");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        // ������ �׽�Ʈ
        System.out.println("\n���� ������ �׽�Ʈ ����");
        MusicMedia media1 = new MP3("Butter", "BTS", "MP3", 4);
        media1.displayInfo();
        media1.play();

        // ĳ���� �׽�Ʈ
        System.out.println("\n���� ĳ���� �׽�Ʈ ����");
        if (media1 instanceof Playable) {
            Playable playable = (Playable) media1;
            playable.setVolume(7);
            playable.play();
            playable.stop();
        }
    }
}