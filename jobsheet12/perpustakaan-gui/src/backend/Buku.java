package backend;

import java.util.ArrayList;

public class Buku {
    private static final ArrayList<Buku> DATA = new ArrayList<>();
    private static int nextId = 1;

    static {
        new Buku(new Kategori().getById(1), "Timun Mas", "Elex Media", "Bang Supit").save();
        new Buku(new Kategori().getById(2), "Aljabar Linier", "Springer", "Alex Baldwin").save();
        new Buku(new Kategori().getById(1), "Bintang Terang", "Erlangga", "Mat Sewoot").save();
    }

    private int idbuku;
    private Kategori kategori = new Kategori();
    private String judul;
    private String penerbit;
    private String penulis;

    public Buku() {
    }

    public Buku(Kategori kategori, String judul, String penerbit, String penulis) {
        this.kategori = kategori;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
    }

    public int getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(int idbuku) {
        this.idbuku = idbuku;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Salinan buku; kategori dibaca ulang dari Kategori (setara JOIN pada database).
    private Buku copy() {
        Buku b = new Buku(new Kategori().getById(kategori.getIdkategori()),
                judul, penerbit, penulis);
        b.idbuku = idbuku;
        return b;
    }

    public Buku getById(int id) {
        for (Buku b : DATA) {
            if (b.idbuku == id) {
                return b.copy();
            }
        }
        return new Buku();
    }

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> list = new ArrayList<>();
        for (Buku b : DATA) {
            list.add(b.copy());
        }
        return list;
    }

    public ArrayList<Buku> search(String keyword) {
        String key = keyword.toLowerCase();
        ArrayList<Buku> list = new ArrayList<>();
        for (Buku b : DATA) {
            if (b.judul.toLowerCase().contains(key)
                    || b.penerbit.toLowerCase().contains(key)
                    || b.penulis.toLowerCase().contains(key)) {
                list.add(b.copy());
            }
        }
        return list;
    }

    public void save() {
        if (idbuku == 0) {
            idbuku = nextId++;
            DATA.add(copy());
            return;
        }
        for (int i = 0; i < DATA.size(); i++) {
            if (DATA.get(i).idbuku == idbuku) {
                DATA.set(i, copy());
                return;
            }
        }
    }

    public void delete() {
        DATA.removeIf(b -> b.idbuku == idbuku);
    }
}
