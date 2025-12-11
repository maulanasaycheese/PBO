public class Book {
    private int id;
    private String judul;
    private String pengarang;
    private boolean dipinjam = false;

    public Book(int id, String judul, String pengarang) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
    }

    public int getId() {
        return id; 
    }
    public String getJudul() { 
        return judul; 
    }
    public String getPengarang() { 
        return pengarang; 
    }
    public boolean isDipinjam() { 
        return dipinjam; 
    }

    public void setJudul(String judul) { 
        this.judul = judul; 
    }
    public void setPengarang(String pengarang) { 
        this.pengarang = pengarang; 
    }
    public void setDipinjam(boolean dipinjam) { 
        this.dipinjam = dipinjam; }
    }
    