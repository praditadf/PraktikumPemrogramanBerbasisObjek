package backend;

import java.util.ArrayList;

public class Kategori {

    private static final ArrayList<Kategori> DATA = new ArrayList<>();
    private static int nextId = 1;

    static {
        new Kategori("Novel", "Koleksi buku novel").save();
        new Kategori("Referensi", "Buku referensi ilmiah").save();
        new Kategori("Komik", "Komik anak-anak").save();
    }

    private int idkategori;
    private String nama;
    private String keterangan;

    public Kategori() {
    }

    public Kategori(String nama, String keterangan) {
        this.nama = nama;
        this.keterangan = keterangan;
    }

    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    // Dipakai JComboBox untuk mencocokkan item yang terpilih (dua kategori sama bila id-nya sama).
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Kategori k && k.idkategori == idkategori;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idkategori);
    }

    private Kategori copy() {
        Kategori k = new Kategori(nama, keterangan);
        k.idkategori = idkategori;
        return k;
    }

    public Kategori getById(int id) {
        for (Kategori k : DATA) {
            if (k.idkategori == id) {
                return k.copy();
            }
        }
        return new Kategori();
    }

    public ArrayList<Kategori> getAll() {
        ArrayList<Kategori> list = new ArrayList<>();
        for (Kategori k : DATA) {
            list.add(k.copy());
        }
        return list;
    }

    public ArrayList<Kategori> search(String keyword) {
        String key = keyword.toLowerCase();
        ArrayList<Kategori> list = new ArrayList<>();
        for (Kategori k : DATA) {
            if (k.nama.toLowerCase().contains(key)
                    || k.keterangan.toLowerCase().contains(key)) {
                list.add(k.copy());
            }
        }
        return list;
    }

    public void save() {
        if (idkategori == 0) {
            idkategori = nextId++;
            DATA.add(copy());
            return;
        }
        for (int i = 0; i < DATA.size(); i++) {
            if (DATA.get(i).idkategori == idkategori) {
                DATA.set(i, copy());
                return;
            }
        }
    }

    public void delete() {
        DATA.removeIf(k -> k.idkategori == idkategori);
    }

    @Override
    public String toString() {
        return nama;
    }
}
