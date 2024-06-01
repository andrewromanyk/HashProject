import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] value = "Lorem ipsum".getBytes();
        System.out.println("MessageDigest:");
        MessDig(value, "MD5");
        MessDig(value, "SHA-1");
        MessDig(value, "SHA-256");

        byte[] value2 = "Lorem ipsum".getBytes();
        System.out.println("SecureRandom:");
        SecRan(value2, "SHA1PRNG");
        SecRan(value2, "Windows-PRNG");
        SecRan(value2, "DRBG");

        {
            System.out.println("Class Song:");
            HashMap<Song, Integer> map = new HashMap<>();
            Song song1 = new Song("Immigrant Song", "Led Zeppelin", "Led Zeppelin III");
            Song song2 = new Song("Paint it, black", "The Rolling Stones", "single");
            Song song3 = new Song("Immigrant Song", "Led Zeppelin", "Led Zeppelin III");
            System.out.println("song1: " + song1);
            System.out.println("song2: " + song2);
            System.out.println("song3: " + song3);
            System.out.println("song1 == song2: " + (song1.equals(song2)));
            System.out.println("song1 == song3: " + (song1.equals(song3)));
            System.out.println("song1 hash: " + song1.hashCode());
            System.out.println("song2 hash: " + song2.hashCode());
            System.out.println("song3 hash: " + song3.hashCode());
            map.put(song1, 1);
            map.put(song2, 2);
            map.put(song3, 3);
            System.out.println("Hashmap:" );
            printMap(map);
        }

        {
            System.out.println("\nClass SongIncorrect:");
            HashMap<SongIncorrect, Integer> map = new HashMap<>();
            SongIncorrect song1 = new SongIncorrect("Immigrant Song", "Led Zeppelin", "Led Zeppelin III");
            SongIncorrect song2 = new SongIncorrect("Paint it, black", "The Rolling Stones", "single");
            SongIncorrect song3 = new SongIncorrect("Immigrant Song", "Led Zeppelin", "Led Zeppelin III");
            System.out.println("song1: " + song1);
            System.out.println("song2: " + song2);
            System.out.println("song3: " + song3);
            System.out.println("song1 == song2: " + (song1.equals(song2)));
            System.out.println("song1 == song3: " + (song1.equals(song3)));
            System.out.println("song1 hash: " + song1.hashCode());
            System.out.println("song2 hash: " + song2.hashCode());
            System.out.println("song3 hash: " + song3.hashCode());
            map.put(song1, 1);
            map.put(song2, 2);
            map.put(song3, 3);
            System.out.println("Hashmap:" );
            printMap(map);
        }
   }

   public static void MessDig(byte[] value, String mode) throws NoSuchAlgorithmException {
       MessageDigest MD = MessageDigest.getInstance(mode);
       System.out.print("Mode: " + MD.getAlgorithm()
               + "\nValue: " + Arrays.toString(value)
               + "\nHash: " + bytesToHexString(MD.digest(value)) + "\n\n");
   }

    public static void SecRan(byte[] value, String mode) throws NoSuchAlgorithmException {
        SecureRandom SR = SecureRandom.getInstance(mode);
        SR.setSeed(value);
        System.out.print("Mode: " + SR.getAlgorithm()
                + "\nValue: " + Arrays.toString(value)
                + "\nHash: " + SR.nextLong() + "\n\n");
    }

    public static <K, V> void printMap(Map<K, V> map){
        System.out.println("{");
        for (K key : map.keySet()) {
            System.out.println(key.toString() + ": " + map.get(key) + ",");
        }
        System.out.println("}");
    }

    public static String bytesToHexString(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

