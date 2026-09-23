import java.util.Arrays;
import java.util.Scanner;

class SafePlaylist {
    private String[] songs;
    private int count;

    public SafePlaylist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class PlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        sc.nextLine();

        SafePlaylist p = new SafePlaylist(capacity);
        String song1 = sc.nextLine();
        String song2 = sc.nextLine();

        p.addSong(song1);
        p.addSong(song2);

        String[] copy = p.getSongs();
        copy[0] = sc.nextLine();

        System.out.println("Original first song: " + p.getSongs()[0]);
        System.out.println("Modified copy first song: " + copy[0]);
        System.out.println("Total song count: " + p.getSongCount());

        sc.close();
    }
}