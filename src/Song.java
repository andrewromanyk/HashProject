public class Song {
    private String name;
    private String artist;
    private String album;

    public Song(String name, String artist, String album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Song)) {return false;}
        return name.equals(((Song) obj).name) && artist.equals(((Song) obj).artist) && album.equals(((Song) obj).album);
    }

    @Override
    public int hashCode() {
        int hash = 13 + name.hashCode();
        hash -= album.hashCode()*album.hashCode();
        hash += artist.hashCode()*3;
        return hash;
    }

    @Override
    public String toString() {
        return "['" + name + "', '" + artist + "', '" + album + "']";
    }
}
