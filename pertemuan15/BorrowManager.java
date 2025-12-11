import java.util.ArrayList;

public class BorrowManager {
    private ArrayList<String> riwayat = new ArrayList<>();

    public void pinjamBuku(User user, Book book) {
        if (book.isDipinjam()) {
            System.out.println("Maaf, buku sedang dipinjam.");
        }
        else {
            book.setDipinjam(true);
            riwayat.add(user.getNamaLengkap() + " meminjam: " + book.getJudul());
            System.out.println("Berhasil dipinjam!");
        }
    }

    public void kembalikanBuku(User user, Book book) {
        if (!book.isDipinjam()) {
            System.out.println("Buku ini tidak sedang dipinjam.");
        }
        else {
            book.setDipinjam(false);
            riwayat.add(user.getNamaLengkap() + " mengembalikan: " + book.getJudul());
            System.out.println("Buku berhasil dikembalikan!");
        }
    }

    public void showRiwayat() {
        System.out.println("\n=== RIWAYAT PEMINJAMAN ===");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada riwayat.");
        }
        else {
            for (String r : riwayat) {
                System.out.println("- " + r);
            }
        }
    }
}