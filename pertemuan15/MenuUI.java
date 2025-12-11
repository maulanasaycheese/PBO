import java.util.Scanner;

public class MenuUI {
    private UserManager userManager = new UserManager();
    private BookManager bookManager = new BookManager();
    private BorrowManager borrowManager = new BorrowManager();
    private Scanner input = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String pilih = input.nextLine();

            if (pilih.equals("1")) {
                loginMenu();
            }
            else if (pilih.equals("2")) {
                registerMenu();
            }
            else if (pilih.equals("0")) {
                System.out.println("Terima kasih.");
                break;
            }
            else {
                System.out.println("Pilihan salah.");
            }
        }
    }

    private void loginMenu() {
        System.out.print("Username: ");
        String user = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();
        
        User loggedInUser = userManager.login(user, pass);
        if (loggedInUser != null) {
            System.out.println("Login berhasil! Halo " + loggedInUser.getNamaLengkap());
            mainMenu(loggedInUser);
        }
        else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    private void registerMenu() {
        System.out.print("Username baru: ");
        String user = input.nextLine();
        System.out.print("Password baru: ");
        String pass = input.nextLine();
        System.out.print("Nama Lengkap: ");
        String nama = input.nextLine();

        if (userManager.register(user, pass, nama)) {
            System.out.println("Registrasi berhasil! Silakan login.");
        }
        else {
            System.out.println("Username sudah terpakai.");
        }
    }

    private void mainMenu(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nMENU UTAMA");
            System.out.println("1. Lihat Semua Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Edit Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Pinjam Buku");
            System.out.println("6. Kembalikan Buku");
            System.out.println("7. Riwayat Peminjaman");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");
            String pilih = input.nextLine();

            switch (pilih) {
                case "1": bookManager.showBooks(); break;
                case "2": 
                    System.out.print("Judul: ");
                    String judul = input.nextLine();
                    System.out.print("Pengarang: ");
                    String pengarang = input.nextLine();
                    bookManager.addBook(judul, pengarang, true);
                    break;
                case "3": bookManager.editBook(input);
                break;
                case "4": bookManager.deleteBook(input);
                break;
                case "5": pinjamBook(user);
                break;
                case "6": kembalikanBook(user);
                break;
                case "7": borrowManager.showRiwayat();
                break;
                case "0": loggedIn = false;
                break;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void pinjamBook(User user) {
        bookManager.showBooks();
        System.out.print("ID buku yang ingin dipinjam: ");
        int id = Integer.parseInt(input.nextLine());
        Book book = bookManager.findBookById(id);
        if (book != null) {
            borrowManager.pinjamBuku(user, book);
        }
        else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    private void kembalikanBook(User user) {
        bookManager.showBooks();
        System.out.print("ID buku yang ingin dikembalikan: ");
        int id = Integer.parseInt(input.nextLine());
        Book book = bookManager.findBookById(id);
        if (book != null) {
            borrowManager.kembalikanBuku(user, book);
        }
        else {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}
