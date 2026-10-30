|            | Praktikum Pemrograman Berbasis Objek                                                        |
| ---------- | ------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                |
| Nama       | Achmad Pradita Dwi Firmansyah                                                               |
| Kelas      | TI - 2G                                                                                     |
| Repository | [link](https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet10) |

# Percobaan

## Percobaan 1: Abstract Class

### Class Hewan.java

```
package jobsheet10.abstractclass;

public abstract class Hewan {
    protected int umur;

    protected Hewan() {
        this.umur = 0;
    }

    public void bertambahUmur() {
        this.umur += 1;
    }

    public abstract void bergerak();
}
```

### Class Ikan.java

```
package jobsheet10.abstractclass;

public class Ikan extends Hewan {
    @Override
    public void bergerak() {
        System.out.println("Berenang dengan SIRIP, \"wush..wush..\"");
    }
}
```

### Class Kucing.java

```
package jobsheet10.abstractclass;

public class Kucing extends Hewan {
    @Override
    public void bergerak() {
        System.out.println("Berjalan dengan KAKI, \"tap..tap..\"");
    }
}
```

### Class Orang.java

```
package jobsheet10.abstractclass;

public class Orang {
    private String nama;
    private Hewan hewanPeliharaan;

    public Orang(String nama) {
        this.nama = nama;
    }

    public void peliharaHewan(Hewan hewan) {
        this.hewanPeliharaan = hewan;
    }

    public void ajakPeliharaanJalanJalan() {
        System.out.println("Namaku " + this.nama);
        System.out.println("Hewan peliharaanku berjalan dengan cara: ");
        this.hewanPeliharaan.bergerak();
        System.out.println("---------------------------------------");
    }
}
```

### Class Program.java

```
package jobsheet10.abstractclass;

public class Program {
    public static void main(String[] args) {
        Kucing kucingKampung = new Kucing();
        Ikan lumbaLumba = new Ikan();

        Orang ani = new Orang("Ani");
        Orang budi = new Orang("Budi");

        ani.peliharaHewan(kucingKampung);
        budi.peliharaHewan(lumbaLumba);

        ani.ajakPeliharaanJalanJalan();
        budi.ajakPeliharaanJalanJalan();
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Namaku Ani
Hewan peliharaanku berjalan dengan cara:
Berjalan dengan KAKI, "tap..tap.."
---------------------------------------
Namaku Budi
Hewan peliharaanku berjalan dengan cara:
Berenang dengan SIRIP, "wush..wush.."
---------------------------------------
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan Percobaan 1

1. Jelaskan jalannya program di atas. Mengapa pemanggilan this.hewanPeliharaan.bergerak() di class Orang menghasilkan output yang berbeda untuk Ani dan Budi?

```
Program di atas menghasilkan output yang berbeda karena pada pemanggilan this.hewanPeliharaan.bergerak() di class Orang berisi referensi objek yang berbeda sehingga akan merujuk ke method bergerak sesuai dengan objek yang diinstansiasi.
```

2. Tambahkan baris Hewan hewan = new Hewan(); pada method main(). Tunjukkan hasil kompilasinya dan jelaskan secara singkat.

```
Penambahan baris Hewan hewan = new Hewan(); pada method main() akan menghasilkan error (Cannot instantiate the type Hewan) karena Hewan adalah Abstract class adalah class yang tidak dapat diinstansiasi (tidak bisa dibuat objeknya dengan new), objek dibuat dari class yang meng-implements/meng-extend-nya.
```

3. Bolehkah sebuah class yang meng-extend abstract class tidak mengimplementasikan abstract method induknya? Buktikan dengan menghapus method bergerak() dari class Ikan, lalu tunjukkan hasil kompilasinya dan jelaskan.

```
Sebuah class yang meng-extend abstract class harus mengimplementasikan abstract method induknya. Jika tidak, maka akan menghasilkan error(The type Ikan must implement the inherited abstract method Hewan.bergerak()) karena Class turunan (yang bukan abstract) wajib meng-override semua abstract method milik induknya.
```

4. Tambahkan abstract method public abstract void bernapas(); di dalam class Ikan tanpa mengubah deklarasi class Ikan. Tunjukkan hasil kompilasinya dan jelaskan aturan yang dilanggar.

```
Penambahan abstract method public abstract void bernapas(); di dalam class Ikan tanpa mengubah deklarasi class Ikan akan menghasilkan error(The abstract method bernapas in type Ikan can only be defined by an abstract class) karena Class yang memiliki minimal satu abstract method wajib dideklarasikan sebagai abstract class.
```

## Percobaan 2: Interface

### Class ICumlaude.java

```
package jobsheet10.interfacelatihan;

public interface ICumlaude {
    public abstract void lulus();

    public abstract void meraihIPKTinggi();
}
```

### Class Mahasiswa.java

```
package jobsheet10.interfacelatihan;

public class Mahasiswa {
    protected String nama;

    public Mahasiswa(String nama) {
        this.nama = nama;
    }

    public void kuliahDiKampus() {
        System.out.println("Aku mahasiswa, namaku " + this.nama);
        System.out.println("Aku berkuliah di kampus.");
    }
}
```

### Class Sarjana.java

```
package jobsheet10.interfacelatihan;

public class Sarjana extends Mahasiswa implements ICumlaude {
    public Sarjana(String nama) {
        super(nama);
    }

    @Override
    public void lulus() {
        System.out.println("Aku sudah menyelesaikan SKRIPSI");
    }

    @Override
    public void meraihIPKTinggi() {
        System.out.println("IPK-ku lebih dari 3,51");
    }
}
```

### Class PascaSarjana.java

```
package jobsheet10.interfacelatihan;

public class PascaSarjana extends Mahasiswa implements ICumlaude {
    public PascaSarjana(String nama) {
        super(nama);
    }

    @Override
    public void lulus() {
        System.out.println("Aku sudah menyelesaikan TESIS");
    }

    @Override
    public void meraihIPKTinggi() {
        System.out.println("IPK-ku lebih dari 3,71");
    }
}
```

### Class Rektor.java

```
package jobsheet10.interfacelatihan;

public class Rektor {
    public void beriSertifikatCumlaude(ICumlaude mahasiswaCumlaude) {
        System.out.println("Saya REKTOR, memberikan sertifikat cumlaude.");
        System.out.println("Selamat! Silakan perkenalkan diri Anda..");

        mahasiswaCumlaude.lulus();
        mahasiswaCumlaude.meraihIPKTinggi();

        System.out.println("----------------------------------------");
    }
}
```

### Class Program.java

```
package jobsheet10.interfacelatihan;

public class Program {
    public static void main(String[] args) {
        Rektor pakRektor = new Rektor();
        Mahasiswa mhsBiasa = new Sarjana("Charlie");
        Sarjana sarjanaCumlaude = new Sarjana("Dini");
        PascaSarjana masterCumlaude = new PascaSarjana("Elok");

        //pakRektor.beriSertifikatCumlaude(mhsBiasa);
        pakRektor.beriSertifikatCumlaude(sarjanaCumlaude);
        pakRektor.beriSertifikatCumlaude(masterCumlaude);
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Saya REKTOR, memberikan sertifikat cumlaude.
Selamat! Silakan perkenalkan diri Anda..
Aku sudah menyelesaikan SKRIPSI
IPK-ku lebih dari 3,51
----------------------------------------
Saya REKTOR, memberikan sertifikat cumlaude.
Selamat! Silakan perkenalkan diri Anda..
Aku sudah menyelesaikan TESIS
IPK-ku lebih dari 3,71
----------------------------------------
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan Percobaan 2

1. Mengapa pada langkah 7 terjadi error? Tuliskan pesan error-nya dan jelaskan bagaimana Anda memperbaikinya.

```
Pada langkah 7 terjadi error karena class mahasiswa tidak memiliki relasi ke interface ICumlaude. Untuk mengatasinya kita menghapus atau menjadikan komentar baris pakRektor.beriSertifikatCumlaude(mhsBiasa);
```

2. Dapatkah method kuliahDiKampus() dipanggil dari objek sarjanaCumlaude di class Program? Mengapa demikian?

```
method kuliahDiKampus() dapat dipanggil dari objek sarjanaCumlaude di class Program objek sarjanaCUmlaude dari instansiasi Class Sarjana merupakan turunan dari class Mahasiswa. Oleh karena itu, method kuliahDiKampus() dapat dipanggil dari sajranaCumlaude.
```

3. Dapatkah method kuliahDiKampus() dipanggil dari parameter mahasiswaCumlaude di method beriSertifikatCumlaude() pada class Rektor? Mengapa demikian?

```
method kuliahDiKampus() tidak dapat dipanggil dari parameter mahasiswaCumlaude di method beriSertifikatCumlaude() pada class Rektor karena method kuliahDiKampus() adalah method yang ada di dalam class Mahasiswa, sedangkan method beriSertifikatCumlaude() hanya memanggil ICumlaude, dan method kuliahDiKampus() adalah method milik mahasiswa yang tidak punya relasi dengan Class ICumlaude
```

4. Hapus kata kunci public pada method lulus() di class Sarjana. Tunjukkan hasil kompilasinya dan jelaskan, lalu kembalikan seperti semula.

```
Menghapus kata kunci public pada method lulus akan menghalakan error (Cannot reduce the visibility of the inherited method from ICumlaude) karena Method hasil implementasi interface pada class harus public.
```

## Percobaan 3: Multiple Interface

### Class IBerprestasi.java

```
package jobsheet10.percobaan3;

public interface IBerprestasi {
    public abstract void menjuaraiKompetisi();

    public abstract void membuatPublikasiIlmiah();
}
```

### Class PascaSarjana.java

```
package jobsheet10.percobaan3;

public class PascaSarjana extends Mahasiswa
        implements ICumlaude, IBerprestasi {
    public PascaSarjana(String nama) {
        super(nama);
    }

    @Override
    public void lulus() {
        System.out.println("Aku sudah menyelesaikan TESIS");
    }

    @Override
    public void meraihIPKTinggi() {
        System.out.println("IPK-ku lebih dari 3,71");
    }

    @Override
    public void menjuaraiKompetisi() {
        System.out.println("Saya telah menjuarai kompetisi INTERNASIONAL");
    }

    @Override
    public void membuatPublikasiIlmiah() {
        System.out.println("Saya menerbitkan artikel di jurnal INTERNASIONAL");
    }
}
```

### Class Program.java

```
package jobsheet10.percobaan3;

public class Program {
    public static void main(String[] args) {
        Rektor pakRektor = new Rektor();
        Mahasiswa mhsBiasa = new Sarjana("Charlie");
        Sarjana sarjanaCumlaude = new Sarjana("Dini");
        PascaSarjana masterCumlaude = new PascaSarjana("Elok");

        // pakRektor.beriSertifikatCumlaude(mhsBiasa);
        // pakRektor.beriSertifikatCumlaude(sarjanaCumlaude);
        // pakRektor.beriSertifikatCumlaude(masterCumlaude);

        // pakRektor.beriSertifikatMawapres(sarjanaCumlaude);
        pakRektor.beriSertifikatMawapres(masterCumlaude);
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Saya REKTOR, memberikan sertifikat MAWAPRES.
Selamat! Bagaimana Anda bisa berprestasi?
Saya telah menjuarai kompetisi INTERNASIONAL
Saya menerbitkan artikel di jurnal INTERNASIONAL
----------------------------------------
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan Percobaan 3

1. Pada interface IBerprestasi, ganti modifier public pada method menjuaraiKompetisi() menjadi protected dan pada method membuatPublikasiIlmiah() menjadi private. Apa yang terjadi? Jelaskan alasannya (sertakan capture hasilnya), lalu kembalikan seperti semula.

```
Mengganti modifier protected pada menjuaraiKompetisi() dan private pada membuatPublikasiIlmiah() akan menghasilkan error
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Error: Unable to initialize main class jobsheet10.percobaan3.Program
Caused by: java.lang.ClassFormatError: Method membuatPublikasiIlmiah in class jobsheet10/percobaan3/IBerprestasi has illegal modifiers: 0x402
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Karena Method dan konstanta di dalam interface tidak boleh diberi modifier private atau protected.
```

2. Tambahkan baris IBerprestasi prestasi = new IBerprestasi(); pada method main(). Mengapa baris tersebut error?

```
Penambahan baris IBerprestasi prestasi = new IBerprestasi(); akan menghasilkan error(IBerprestasi prestasi = new IBerprestasi();) karena Interface tidak memiliki constructor dan tidak dapat dibuat objeknya dengan new.
```

3. Apabila Sarjana Berprestasi harus menjuarai kompetisi NASIONAL dan menerbitkan artikel di jurnal NASIONAL, modifikasilah class-class yang terkait agar di class Program objek pakRektor dapat memberikan sertifikat mawapres kepada objek sarjanaCumlaude, dengan output seperti berikut.

#### Class Sarjana.java

```
package jobsheet10.percobaan3;

public class Sarjana extends Mahasiswa
        implements ICumlaude, IBerprestasi {
    public Sarjana(String nama) {
        super(nama);
    }

    @Override
    public void lulus() {
        System.out.println("Aku sudah menyelesaikan SKRIPSI");
    }

    @Override
    public void meraihIPKTinggi() {
        System.out.println("IPK-ku lebih dari 3,51");
    }

    @Override
    public void menjuaraiKompetisi() {
        System.out.println("Saya telah menjuarai kompetisi NASIONAL");
    }

    @Override
    public void membuatPublikasiIlmiah() {
        System.out.println("Saya menerbitkan artikel di jurnal NASIONAL");
    }
}
```

#### Class Program.java

```
package jobsheet10.percobaan3;

public class Program {
    public static void main(String[] args) {
        Rektor pakRektor = new Rektor();
        Mahasiswa mhsBiasa = new Sarjana("Charlie");
        Sarjana sarjanaCumlaude = new Sarjana("Dini");
        PascaSarjana masterCumlaude = new PascaSarjana("Elok");

        // pakRektor.beriSertifikatCumlaude(mhsBiasa);
        // pakRektor.beriSertifikatCumlaude(sarjanaCumlaude);
        // pakRektor.beriSertifikatCumlaude(masterCumlaude);

        pakRektor.beriSertifikatMawapres(sarjanaCumlaude);
        pakRektor.beriSertifikatMawapres(masterCumlaude);
    }
}
```

#### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Saya REKTOR, memberikan sertifikat MAWAPRES.
Selamat! Bagaimana Anda bisa berprestasi?
Saya telah menjuarai kompetisi NASIONAL
Saya menerbitkan artikel di jurnal NASIONAL
----------------------------------------
Saya REKTOR, memberikan sertifikat MAWAPRES.
Selamat! Bagaimana Anda bisa berprestasi?
Saya telah menjuarai kompetisi INTERNASIONAL
Saya menerbitkan artikel di jurnal INTERNASIONAL
----------------------------------------
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Tugas

### Class Binatang.java

```
package jobsheet10.tugas;

public abstract class Binatang {
    protected String nama;
    protected int jmlKaki;

    public Binatang(String nama, int jmlKaki) {
        this.nama = nama;
        this.jmlKaki = jmlKaki;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setKaki(int jmlKaki) {
        this.jmlKaki = jmlKaki;
    }

    public int getKaki() {
        return jmlKaki;
    }

    public abstract void displayBinatang();
}
```

### Class Singa.java

```
package jobsheet10.tugas;

public class Singa extends Binatang implements IKarnivora {
    private String suara;
    private String warnaBulu;

    public Singa(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void displayBinatang() {
        System.out.println("Jenis: Karnivora");
    }

    public void displayMakan() {
        System.out.println("Makanan: Daging");
    }

    public void displayData() {
        displayBinatang();
        displayMakan();
        System.out.println("Nama: " + getNama());
        System.out.println("Jumlah Kaki: " + getKaki());
        System.out.println("Suara: " + this.suara);
        System.out.println("Warna Bulu: " + this.warnaBulu + "\n");
    }
}
```

### Class Keledai.java

```
package jobsheet10.tugas;

public class Keledai extends Binatang implements IHerbivora {
    private String suara;
    private String warnaBulu;

    public Keledai(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void displayBinatang() {
        System.out.println("Jenis: Herbivora");
    }

    public void displayMakan() {
        System.out.println("Makanan: Tumbuhan");
    }

    public void displayData() {
        displayBinatang();
        displayMakan();
        System.out.println("Nama: " + getNama());
        System.out.println("Jumlah Kaki: " + getKaki());
        System.out.println("Suara: " + this.suara);
        System.out.println("Warna Bulu: " + this.warnaBulu + "\n");
    }
}
```

### Class Gorilla.java

```
package jobsheet10.tugas;

public class Gorilla extends Binatang
        implements IHerbivora, IKarnivora {
    private String suara;
    private String warnaBulu;

    public Gorilla(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void displayBinatang() {
        System.out.println("Jenis: Karnivora + Herbivora");
    }

    public void displayMakan() {
        System.out.println("Makanan: Daging + Tumbuhan");
    }

    public void displayData() {
        displayBinatang();
        displayMakan();
        System.out.println("Nama: " + getNama());
        System.out.println("Jumlah Kaki: " + getKaki());
        System.out.println("Suara: " + this.suara);
        System.out.println("Warna Bulu: " + this.warnaBulu + "\n");
    }
}
```

### Class IKarnivora.java

```
package jobsheet10.tugas;

public interface IKarnivora {
    public abstract void displayMakan();
}
```

### Class IHerbivora.java

```
package jobsheet10.tugas;

public interface IHerbivora {
    public abstract void displayMakan();
}
```

### Class Program.java

```
package jobsheet10.tugas;

public class Program {
    public static void main(String[] args) {
        Keledai keledai = new Keledai("Keledai", 4, "Hehehehe", "Abu-Abu");
        Gorilla gorilla = new Gorilla("Gulali", 4, "Haaum Hauum", "Hitam Manis");
        Singa singa = new Singa("CingaCing", 4, "Roaaar", "Coklat");

        keledai.displayData();
        gorilla.displayData();
        singa.displayData();
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Jenis: Herbivora
Makanan: Tumbuhan
Nama: Keledai
Jumlah Kaki: 4
Suara: Hehehehe
Warna Bulu: Abu-Abu

Jenis: Karnivora + Herbivora
Makanan: Daging + Tumbuhan
Nama: Gulali
Jumlah Kaki: 4
Suara: Haaum Hauum
Warna Bulu: Hitam Manis

Jenis: Karnivora
Makanan: Daging
Nama: CingaCing
Jumlah Kaki: 4
Suara: Roaaar
Warna Bulu: Coklat

PS C:\G\PraktikumPemrogramanBerbasisObjek>
```
