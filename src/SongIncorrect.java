public class SongIncorrect {
    private String name;
    private String artist;
    private String album;

    public SongIncorrect(String name, String artist, String album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "['" + name + "', '" + artist + "', '" + album + "']";
    }
}
