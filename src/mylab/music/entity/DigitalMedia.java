package mylab.music.entity;

public abstract class DigitalMedia extends MusicMedia {
    protected String format;

    public DigitalMedia(String title, String artist, String format) {
        super(title, artist);
        this.format = format;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Æ÷¸Ë: " + format);
    }

    // Getter
    public String getFormat() { return format; }
}