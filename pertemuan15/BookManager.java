import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public BookManager() {
        loadDefaultBooks();
    }

    private void loadDefaultBooks() {
        addBook("Laskar Pelangi", "Andrea Hirata", false);
        addBook("Bumi Manusia", "Pramoedya Ananta Toer", false);
        addBook("Negeri 5 Menara", "A. Fuadi", false);
    }

    public void showBooks() {
        System.out.println("\n=== DAFTAR BUKU ===");
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku.");
        } 
        else {
            for (Book b : books) {
                String status = b.isDipinjam() ? " (Dipinjam)" : "";
                System.out.println(b.getId() + ". " + b.getJudul() + " - " + b.getPengarang() + status);
            }
        }
    }

    public void addBook(String judul, String pengarang, boolean print) {
        books.add(new Book(nextId++, judul, pengarang));
        if (print) {
            System.out.println("Buku berhasil ditambahkan!");
        }
    }

    public Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public void editBook(Scanner input) {
        showBooks();
        System.out.print("Masukkan ID buku yang ingin diedit: ");
        int id = Integer.parseInt(input.nextLine());
        Book book = findBookById(id);
        if (book != null) {
            System.out.print("Judul baru: ");
            String judul = input.nextLine();
            System.out.print("Pengarang baru: ");
            String pengarang = input.nextLine();
            book.setJudul(judul);
            book.setPengarang(pengarang);
            System.out.println("Buku berhasil diupdate!");
        }
        else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void deleteBook(Scanner input) {
        showBooks();
        System.out.print("Masukkan ID buku yang ingin dihapus: ");
        int id = Integer.parseInt(input.nextLine());
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Buku berhasil dihapus!");
        }
        else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}