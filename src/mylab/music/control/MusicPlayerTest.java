package mylab.music.control;

import mylab.music.entity.*;
import mylab.music.interfaces.Playable;

public class MusicPlayerTest {
    public static void main(String[] args) {
        System.out.println("━━━━━━ 음악 재생 시스템 테스트 ━━━━━━");

        // MP3 테스트
        System.out.println("\n── MP3 테스트 ──");
        MP3 mp3 = new MP3("Dynamite", "BTS", "MP3", 6);
        mp3.displayInfo();
        mp3.play();
        mp3.setVolume(5);
        mp3.play();
        mp3.stop();

        // Vinyl 테스트
        System.out.println("\n── Vinyl 테스트 ──");
        Vinyl vinyl = new Vinyl("Yesterday", "The Beatles", 33);
        vinyl.displayInfo();
        vinyl.play();
        vinyl.clean();

        // 다형성 테스트
        System.out.println("\n── 다형성 테스트 ──");
        MusicMedia media1 = new MP3("Butter", "BTS", "MP3", 4);
        media1.displayInfo();
        media1.play();

        // 캐스팅 테스트
        System.out.println("\n── 캐스팅 테스트 ──");
        if (media1 instanceof Playable) {
            Playable playable = (Playable) media1;
            playable.setVolume(7);
            playable.play();
            playable.stop();
        }
    }
}