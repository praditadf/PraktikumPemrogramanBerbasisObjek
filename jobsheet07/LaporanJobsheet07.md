|            | Praktikum Pemrograman Berbasis Objek                                                        |
| ---------- | ------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                |
| Nama       | Achmad Pradita Dwi Firmansyah                                                               |
| Kelas      | TI - 2G                                                                                     |
| Repository | [link](https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet07) |

# Percobaan

## Percobaan 1: Overloading Method (Perkalian)

### Class Perkalian.java

```
package jobsheet07.percobaan1;

public class Perkalian {
    public int kali(int a, int b) {
        return a * b;
    }

    public int kali(int a, int b, int c) {
        return a * b * c;
    }

    public double kali(double a, double b) {
        return a * b;
    }

    public void tampilkan(int nomor, String label) {
        System.out.println(nomor + ". " + label);
    }

    public void tampilkan(String label, int nomor) {
        System.out.println(label + " #" + nomor);
    }
}
```

### Class MainPercobaan1.java

```
package jobsheet07.percobaan1;

public class MainPercobaan1 {
    public static void main(String[] args) {
        Perkalian p = new Perkalian();
        System.out.println("kali(25, 43)  = " + p.kali(25, 43));
        System.out.println("kali(34, 23, 56)  = " + p.kali(34, 23, 56));
        System.out.println("kali(25.5, 4.0)  = " + p.kali(25.5, 4.0));

        p.tampilkan(1, "Perkalian");
        p.tampilkan("Perkalian", 1);
    }
}

```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
kali(25, 43)     = 1075
kali(34, 23, 56) = 43792
kali(25.5, 4.0)  = 102.0
1. Perkalian
Perkalian #1
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Eksperimen

```
    public long kali(int a, int b)
    { return (long) a * b; }
Duplicate method kali(int, int) in type Perkalian
```

```
    public int kali(int x, int y) {
        return x * y;
    }
Duplicate method kali(int, int) in type Perkalian
```

```
MainPercobaan1.java
System.out.println("kali(5, 2.5)  = " + p.kali(5, 2.5));
System.out.println("kali(2, 3)    = " + p.kali(2, 3));
System.out.println("kali (2.0, 3) = " + p.kali(2.0, 3));

PS C:\G\PraktikumPemrogramanBerbasisObjek>
kali(5, 2.5)  = 12.5
kali(2, 3)    = 6
kali (2.0, 3) = 6.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan Percobaan 1

1. Sebutkan method hasil overloading pada Perkalian dan pembeda tiap pasangannya (jumlah, tipe, atau urutan parameter).

```
Method hasil overloading :
public int kali(int a, int b)

public int kali(int a, int b, int c)

public double kali(double a, double b)

public void tampilkan(int nomor, String label)

public void tampilkan(String label, int nomor)

```

2. Pada p.kali(25.5, 4.0), versi kali() mana yang dipanggil? Mengapa bukan versi int?

```
p.kali(25.5, 4.0) memanggil public double kali(double a, double b). tidak menggunakan versi int karena pada parameter pemanggilan menggunakan tipe data double.
```

3. Mengapa tampilkan(int, String) dan tampilkan(String, int) sah sebagai overloading, sedangkan dua method yang hanya beda tipe kembalian atau nama parameter tidak?

```
tampilkan(int, String) dan tampilkan(String, int) sah sebagai overloading karena nama method sama walaupun tipe parameter berbeda
```

4. Pada eksperimen ketiga, mengapa kali(5, 2.5) menghasilkan 12.5 dan bukan error?

```
kali(5, 2.5) menghasilkan 12.5 dan bukan error karena int boleh diperlebar (widening) menjadi double sehingga yang dipanggil adalah parameter double a, double b. 5 diubah menjadi 5.0
```

## Percobaan 2: Pemilihan Overload oleh Compiler (Resolusi)

### Class Resolusi.java

```
package jobsheet07.percobaan2;

public class Resolusi {
    public static void tampil(long x) {
        System.out.println("tampil(long) : " + x);
    }

    public static void tampil(Integer x) {
        System.out.println("tampil(Integer) : " + x);
    }

    public static void tampil(Object x) {
        System.out.println("tampil(Object) : " + x);
    }

    public static void tampil(int... x) {
        System.out.println("tampil(int...) : " + x.length + " elemen");
    }
}
```

### Class MainPercobaan2.java

```
package jobsheet07.percobaan2;

public class MainPercobaan2 {
    public static void main(String[] args) {
        Resolusi.tampil(5);
        Resolusi.tampil(5L);
        Resolusi.tampil(Integer.valueOf(7));
        Resolusi.tampil(3.5);
        Resolusi.tampil("Java");
        Resolusi.tampil();
        Resolusi.tampil(1, 2, 3);
    }
}
```

### Prediksi Pemanggilan

| Pemanggilan                | Prediksi Anda             | Hasil sebenarnya          |
| -------------------------- | ------------------------- | ------------------------- |
| tampil(5)                  | tampil(long) : 5          | tampil(long) : 5          |
| tampil(5L)                 | tampil(long) : 5          | tampil(long) : 5          |
| tampil(Integer.valueOf(7)) | tampil(Integer) : 7       | tampil(Integer) : 7       |
| tampil(3.5)                | tampil(Object) : 3.5      | tampil(Object) : 3.5      |
| tampil("Java")             | tampil(Object) : Java     | tampil(Object) : Java     |
| tampil()                   | tampil(int...) : 0 elemen | tampil(int...) : 0 elemen |
| tampil(1, 2, 3)            | tampil(int...) : 3 elemen | tampil(int...) : 3 elemen |

### Eksperimen kumulatif

| Kondisi                                                      | Overload yang dipanggol oleh tampil(5) |
| ------------------------------------------------------------ | -------------------------------------- |
| Semua overload aktif                                         | tampil(long) : 5                       |
| tampil(long) dikomentari                                     | tampil(Integer) : 5                    |
| tampil(long) dan tampil(Integer) dikomentari                 | tampil(Object) : 5                     |
| tampil(long), tampil(Integer), dan tampil(Object) dikomentar | tampil(int...) : 1 elemen              |

### Class Eksperimen2.java

```
package jobsheet07.percobaan2;

public class Eksperimen2 {
    static void tampilLong(Long x) {
        System.out.println("Long: " + x);
    }

    public static void main(String[] args) {
        tampilLong(5);
    }
}
```

The method tampilLong(Long) in the type Eksperimen2 is not applicable for the arguments (int)

## Pertanyaan Percobaan 2

1. Mengapa tampil(5) memilih tampil(long) dan bukan tampil(Integer), padahal 5 dapat di-boxing? Sebutkan fase yang menentukan.

```
Fase penentuan resolusi pemanggilan method mendahulukan proses primitive widening conversion (pelebaran tipe primitif) dibandingkan boxing dan var args. Oleh karena itu, argumen int (5) akan otomatis diperlebar menjadi long untuk memanggil method tampil(long).
```

2. Jelaskan perpindahan overload pada tiap baris tabel Langkah 3.

```
Urutannya long (widening), Integer (boxing), Object (boxing lalu widening), dan terakhir int... (varargs). Karena itu tampil(3.5) memanggil tampil(Object): double tidak dapat di-widening ke long, sehingga di-boxing menjadi Double lalu dipandang sebagai Object.
```

3. Mengapa tampilLong(5) gagal, sedangkan tampil(5) dapat berakhir pada tampil(Object) bila overload lain dikomentari?

```
tampilLong(5) gagal karena parameternya adalah tipe wrapper Long, dan Java tidak mengizinkan proses widening dilanjutkan boxing secara berurutan (dari primitif int menjadi primitif long lalu ke objek Long). Di sisi lain, tampil(5) dapat memanggil tampil(Object) karena Java mengizinkan proses boxing dilanjutkan widening (primitif int di-boxing menjadi objek Integer, lalu nilainya diperlebar menjadi tipe Object karena Integer adalah subclass dari Object).
```

4. Tantangan. Tanpa menjalankan, prediksi output Resolusi.tampil((short) 3) dan Resolusi.tampil('A'), lalu buktikan.

```
Prediksi : tampil(long) : 3, tampil(Object) : A
Hasil    : tampil(long) : 3, tampil(long) : 65
```

## Percobaan 3: Overloading Konstruktor (Kucing)

### Class Kucing.java

```
package jobsheet07.percobaan3;

public class Kucing {
    private String nama;
    private int umur;

    public Kucing(String nama) {
        this(nama, 1);
        System.out.println("Konstuktor 1 parameter selesai");
    }

    public Kucing(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        System.out.println("Konstruktor 2 parameter selesai");
    }

    public void info() {
        System.out.println("Kucing " + nama + ", umur " + umur + " tahun");
    }
}
```

### Class MainPercobaan3.java

```
package jobsheet07.percobaan3;

public class MainPercobaan3 {
    public static void main(String[] args) {
        Kucing a = new Kucing("Tom");
        a.info();
        System.out.println();
        Kucing b = new Kucing("Garfield", 5);
        b.info();
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Konstruktor 2 parameter selesai
Konstuktor 1 parameter selesai
Kucing Tom, umur 1 tahun

Konstruktor 2 parameter selesai
Kucing Garfield, umur 5 tahun
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Langkah 4: Eksperimen, konstruktor tanpa parameter

```
Kucing c = new Kucing();
The constructor Kucing() is undefined
```

## Pertanyaan Percobaan 3

1. Mengapa Konstruktor 2 parameter selesai tercetak lebih dulu daripada Konstruktor 1 parameter selesai pada new Kucing("Tom")?

```
Karena konstruktor pertama memanggil this(nama, 1) yang mengarah ke konstruktor kedua sehingga isi dari konstruktor 2 yang dieksekusi semua sebelum kembali ke konstruktor pertama
```

2. Apa keuntungan this(nama, 1) dibandingkan menyalin isi konstruktor kedua ke konstruktor pertama?

```
Penggunaan this() menghindari duplikasi kode (code reuse) dan memusatkan logika inisialisasi pada satu konstruktor utama. Jika suatu saat ada perubahan aturan inisialisasi atribut, perubahan hanya perlu dilakukan di satu tempat tanpa khawatir ada kode yang terlewat.
```

3. Tambahkan public Kucing() yang memanggil this("Tanpa Nama") dan mencetak Konstruktor 0 parameter selesai. Tuliskan output new Kucing() serta urutan ketiga konstruktor dijalankan

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Konstruktor 2 parameter selesai
Konstuktor 1 parameter selesai
Konstruktor 0 parameter selesau
Kucing Tanpa Nama, umur 1 tahun
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Percobaan 4: Dasar Overriding (Ikan dan Piranha)

### Class Ikan.java

```
package jobsheet07.percobaan4;

public class Ikan {
    public void swim() {
        System.out.println("Ikan bisa berenang");
    }

    public Ikan beranak() {
        return new Ikan();
    }
}
```

### Class Piranha.java

```
package jobsheet07.percobaan4;

public class Piranha extends Ikan{
    @Override
    public void swim() {
        super.swim();
        System.out.println("Piranha bisa makan daging");
    }

    @Override
    public Piranha beranak() {
        return new Piranha();
    }
}
```

### Class MainPercobaan4.java

```
package jobsheet07.percobaan4;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Ikan a =new Ikan();
        Piranha c = new Piranha();

        a.swim();
        c.swim();

        Piranha anak = c.beranak();
        System.out.println("Tipe objek anak: " + anak.getClass().getSimpleName());
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Ikan bisa berenang
Ikan bisa berenang
Piranha bisa makan daging
Tipe objek anak: Piranha
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Langkah 4: Eksperimen, langgar aturan overriding

| Perubahan Pesan                                                     | error pertama                                                                      |
| ------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| Hapus public pada swim() di Piranha                                 | Cannot reduce the visibility of the inherited method from Ikan                     |
| Tambahkan final pada swim() di Ikan (public final void swim())      | overridden method is final                                                         |
| Ubah swim() di Piranha menjadi swim(int jarak), @Override tetap ada | The method swim(int) of type Piranha must override or implement a supertype method |
| Tambahkan throws Exception pada swim() di Piranha                   |                                                                                    |

## Pertanyaan Percobaan 4

1. Bandingkan a.swim() dan c.swim(). Apa peran super.swim(), dan apa yang tercetak bila baris itu dihapus?

```
Pemanggilan a.swim() menjalankan implementasi asal dari kelas Ikan, sedangkan c.swim() menjalankan versi spesifik (overridden) dari kelas Piranha. Keyword super.swim() berfungsi memanggil method swim() milik kelas induk (Ikan) dari dalam Piranha. Jika baris tersebut dihapus, tulisan "Ikan bisa berenang" tidak akan ikut tercetak saat memanggil c.swim(), dan hanya mencetak "Piranha bisa makan daging".
```

2. Apa manfaat covariant return pada beranak()? Apakah Piranha anak = a.beranak(); valid? Mengapa?

```
Covariant return memungkinkan overriding method di subclass mengembalikan tipe data yang lebih spesifik yang merupakan turunan dari return type aslinya. Ini mencegah programmer harus melakukan type-casting secara manual. Baris Piranha anak = a.beranak(); tidak valid, karena variabel a merepresentasikan objek bertipe Ikan. Kembalian dari a.beranak() bertipe Ikan dan tidak dapat ditugaskan langsung ke referensi Piranha tanpa downcasting.
```

3. Untuk tiap baris tabel Langkah 4, sebutkan aturan overriding yang dilanggar.

```
Hapus public pada swim() di Piranha                                 : Melanggar aturan bahwa hak akses overriding method harus sama atau lebih luas dari overridden method. Method dari induk bersifat public, sehingga menurunkannya menjadi package-private tidak diizinkan.
Tambahkan final pada swim() di Ikan (public final void swim())      : Method induk dengan kata kunci final bersifat mutlak dan tidak boleh di-override oleh kelas turunannya.
Ubah swim() di Piranha menjadi swim(int jarak), @Override tetap ada : Deklarasi overriding menuntut kesamaan daftar parameter baik dari jumlah, tipe, maupun urutan.
Tambahkan throws Exception pada swim() di Piranha                   : Overriding method tidak diperkenankan melempar exception turunan (checked exceptions) yang lebih luas atau tidak dideklarasikan pada method superclass-nya.
```

4. Pada baris ketiga tabel, apa yang terjadi bila @Override dihapus? Apakah swim(int) overriding atau overloading?

```
Apabila anotasi @Override dihapus, pesan error akan hilang dan method akan dianggap sah. Perlakuan swim(int) ini masuk ke dalam overloading karena daftar parameternya sudah berbeda dengan swim() bawaan yang ia warisi dari Ikan.
```

5. Tantangan. Jika swim() di Ikan dibuat private dan Piranha memiliki @Override public void swim(), apa yang terjadi? Mengapa?

```
Akan memunculkan compile-error dari tag @Override. Method private tidak pernah diwariskan ke subclass sehingga class Piranha seolah tidak memiliki method swim() dari induknya. Akibatnya, Piranha tidak menimpa (override) apapun, melainkan murni membuat method swim() baru.
```

## Percobaan 5: Overloading dan Overriding Bersama (Karyawan, Staff, Manager)

### Class Karyawan.java

```
package jobsheet07.percobaan5;

public class Karyawan {
    protected String nip;
    protected String nama;
    protected String golongan;
    protected double gajiPokok;

    public Karyawan(String nip, String nama, String golongan) {
        this.nip = nip;
        this.nama = nama;
        this.golongan = golongan;
        this.gajiPokok = hitungGajiPokok(golongan);
    }

    private static double hitungGajiPokok(String golongan) {
        return switch (golongan) {
            case "1" -> 5000000;
            case "2" -> 3000000;
            case "3" -> 2000000;
            case "4" -> 1000000;
            case "5" -> 750000;
            default -> throw new IllegalArgumentException(
                    "Golongan tidak dikenal: " + golongan);
        };
    }

    public String getNama() {
        return nama;
    }

    public double getGaji() {
        return gajiPokok;
    }

    public void lihatInfo() {
        System.out.println("NIP          : " + nip);
        System.out.println("Nama         : " + nama);
        System.out.println("Golongan     : " + golongan);
        System.out.printf("Gaji         : %.0f%n", getGaji());
    }
}
```

### Class Staff.java

```
package jobsheet07.percobaan5;

public class Staff extends Karyawan {
    private int jamLembur;
    private double tarifLembur;

    public Staff(String nip,String nama, String golongan, int jamLembur, double tarifLembur) {
        super(nip, nip, golongan);
        this.jamLembur = jamLembur;
        this.tarifLembur = tarifLembur;
    }

    public double getGaji(int jamLembur, double tarifLembur) {
        return super.getGaji() + jamLembur * tarifLembur;
    }

    @Override
    public double getGaji() {
        return getGaji(jamLembur, tarifLembur);
    }

    @Override
    public void lihatInfo() {
        super.lihatInfo();
        System.out.println("Jam lembur   : " + jamLembur);
        System.out.printf("Tarif/jam    : %.0f%n", tarifLembur);

    }
}
```

### Class Manager.java

```
package jobsheet07.percobaan5;

public class Manager extends Karyawan {
    private double tunjangan;
    private String bagian;
    private Staff[] bawahan;

    public Manager(String nip, String nama, String golongan, double tunjangan, String bagian, Staff[] bawahan) {
        super(nip, nama, golongan);
        this.tunjangan = tunjangan;
        this.bagian = bagian;
        this.bawahan = bawahan;
    }

    @Override
    public double getGaji() {
        return super.getGaji() + tunjangan;
    }

    public void viewStaff() {
        System.out.println("----------------------------");
        for (Staff s : bawahan) {
            s.lihatInfo();
            System.out.println("----------------------------");
        }
    }

    @Override
    public void lihatInfo() {
        System.out.println("Manager : " + bagian);
        super.lihatInfo();
        System.out.printf("Tunjangan    : %.0f%n", tunjangan);
        viewStaff();
    }
}
```

### Class MainPercobaan5.java

```
package jobsheet07.percobaan5;

public class MainPercobaan5 {
    public static void main(String[] args) {
        Staff usman = new Staff("0003", "Usman", "2", 10, 10000);
        Staff anugrah = new Staff("0005", "Anugrah", "2", 10, 55000);

        Manager tedjo = new Manager("101", "Tedjo", "1", 5000000,"Administrasi", new Staff[] { usman, anugrah });

        tedjo.lihatInfo();

        System.out.println();
        System.out.println("Simulasi lembur Usman 20 jam @ 15000 = " + (long) usman.getGaji(20, 15000));

    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Manager : Administrasi
NIP          : 101
Nama         : Tedjo
Golongan     : 1
Gaji         : 10000000
Tunjangan    : 5000000
----------------------------
NIP          : 0003
Nama         : 0003
Golongan     : 2
Gaji         : 3100000
Jam lembur   : 10
Tarif/jam    : 10000
----------------------------
NIP          : 0005
Nama         : 0005
Golongan     : 2
Gaji         : 3550000
Jam lembur   : 10
Tarif/jam    : 55000
----------------------------

Simulasi lembur Usman 20 jam @ 15000 = 3300000
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan Percobaan 5

1. Tunjuk method yang termasuk overloading dan yang termasuk overriding pada ketiga class (sebutkan class dan signature-nya), dan jelaskan pembeda masing-masing.

```
Overloading : getGaji() dan getGaji(int lembur, double gajiLembur) pada class Staff. Pembedanya terletak pada daftar parameter method yang berada di dalam satu hierarki.
Overriding  : getGaji() dan lihatInfo() pada class Staff serta class Manager. Method ini menimpa fungsionalitas yang ada pada class Karyawan dengan ciri nama dan parameter yang persis sama.
```

2. Mengapa getGaji(int, double) memakai super.getGaji(), sedangkan getGaji() pada Staff memanggil getGaji(jamLembur, tarifLembur)? Apa yang terjadi bila isi getGaji(int, double) diganti return getGaji() + jamLembur \* tarifLembur;?

```
getGaji(int, double) memanggil super.getGaji() untuk mengakses nilai gaji pokok dari parent Karyawan yang belum tertimpa perhitungan lain.
getGaji() memanggil getGaji(jamLembur, tarifLembur) untuk mendelegasikan (meneruskan) kalkulasi nilai total gaji lembur.
Jika diganti menjadi return getGaji() + ..., akan menyebabkan perulangan terus menerus (infinite recursive loop). Method tersebut akan terus memanggil dirinya sendiri sampai memori penuh (StackOverflowError).
```

3. Apa akibatnya pada gaji Staff bila getGaji() di Staff ditulis return jamLembur \* tarifLembur;? Apakah gaji Manager ikut berubah?

```
Gaji Staff hanya akan menampung nominal uang lembur saja karena tidak lagi menambahkan gaji pokok utama dari Karyawan. Gaji Manager tidak akan ikut berubah, karena method getGaji() pada Manager langsung mengambil nilai induk menggunakan super.getGaji() (Karyawan), tanpa bersinggungan dengan method di Staff.
```

4. Apa hubungan Manager dengan Staff (is-a atau has-a)? Tunjuk atributnya dan bandingkan dengan hubungan Manager dengan Karyawan.

```
Hubungan antara Manager dan Staff adalah has-a (Agregasi), ditunjukkan dengan deklarasi struktur private Staff[] st; di dalam file class Manager. Sedangkan hubungan Manager terhadap Karyawan adalah is-a (Inheritance), karena ia mewarisi Karyawan lewat deklarasi public class Manager extends Karyawan.
```

# Tugas dan Deliverable

## Tugas 1: Overloading pada class Segitiga

### Class Segitiga.java

```
package jobsheet07.Tugas1;

public class Segitiga {
    private int sudut;

    public int sisaSudut(int sudutA) {
        return 180 - sudutA;
    }

    public int sisaSudut(int sudutA, int sudutB) {
        return 180 - (sudutA + sudutB);
    }

    public int keliling(int sisiA, int sisiB, int sisiC) {
        return sisiA + sisiB + sisiC;
    }

    public double keliling(int sisiA, int sisiB) {
        return sisiA + sisiB + Math.sqrt((sisiA*sisiA)+(sisiB*sisiB));
    }

    public int getSudut() {
        if (sudut <= 0 || sudut >= 180) {
            throw new IllegalArgumentException();
        }else{
            return sudut;
        }
    }
}
```

### Class MainTugas1.java

```
package jobsheet07.Tugas1;

public class MainTugas1 {
    public static void main(String[] args) {
        Segitiga t = new Segitiga();
        System.out.println("Jumlah dua sudut lain : " + t.sisaSudut(60));
        System.out.println("Sudut ketiga : " + t.sisaSudut(60, 50));
        System.out.println("Keliling 3, 4, 5 : " + t.keliling(3, 4, 5));
        System.out.println("Keliling siku 3, 4 : " + t.keliling(3, 4));
        System.out.println("Keliling siku 5, 12 : " + t.keliling(5, 12));
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Jumlah dua sudut lain : 120
Sudut ketiga : 70
Keliling 3, 4, 5 : 12
Keliling siku 3, 4 : 12.0
Keliling siku 5, 12 : 30.0
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Pertanyaan analisis:

- (a) keliling(3, 4, 5) dan keliling(3, 4) bertipe kembalian berbeda. Apakah itu yang membuatnya sah sebagai overloading? Apa pembeda sebenarnya?

```
Tipe kembalian yang berbeda bukan penentu utama sahnya overloading. Overloading akan tetap sah baik memiliki return type yang sama ataupun berbeda. Faktor pembeda murninya adalah perbedaan jumlah parameter (tiga parameter vs dua parameter).
```

- (b) Apa yang terjadi bila t.keliling(3, 4.0) dipanggil? Tuliskan pesan error dan alasannya.

```
The method keliling(int, int) in the type Segitiga is not applicable for the arguments (int, double)
Terjadi compile-error karena method keliling meminta dua parameter spesifik int, sedangkan nilai argumen 4.0 bertipe double tidak bisa dikecilkan (narrowing) secara diam-diam menuju primitif int.
```

## Tugas 2: Overriding pada Manusia, Dosen, dan Mahasiswa

### Pertanyaan analisis:

- (a) Mengapa bernafas() pada objek Mahasiswa mencetak teks milik Manusia, sedangkan makan() tidak?

```
Karena subclass Mahasiswa tidak mendeklarasikan dan menimpa (override) method bernafas(), sehingga program menggunakan implementasi dasar bawaan dari induknya (Manusia). Sebaliknya, Mahasiswa mendefinisikan ulang method makan(), sehingga fungsi versi Mahasiswa yang akan dieksekusi.
```

- (b) Bandingkan hasil makan() pada Dosen dan Mahasiswa, lalu jelaskan peran super.makan().

```
Saat class Dosen dan Mahasiswa melakukan override method makan(), mereka bisa menambahkan spesifikasi output masing-masing. Keberadaan super.makan() diimplementasikan untuk menjamin operasi makan() utama dari objek Manusia tetap dieksekusi tanpa diabaikan total, sebelum fitur spesifik dijalankan.
```

## Tugas 3: Jawab singkat

1. Lengkapi tabel perbandingan berikut dengan bahasa Anda sendiri.

| Aspek                 | Overloading                                                           | Overriding                                                                                               |
| --------------------- | --------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| Lokasi terjadi        | Class yang sama                                                       | superclass dan subclass                                                                                  |
| Signature (parameter) | Nama method sama, tetapi jumlah, tipe, atau urutan parameter berbeda. | Nama dan daftar parameter harus sama.                                                                    |
| Tipe kembalian        | Boleh sama atau berbeda                                               | Harus sama                                                                                               |
| Access modifier       | Tidak harus sama                                                      | Tidak boleh lebih daripada method yang di override                                                       |
| Peran @Override       | Tidak digunakan                                                       | Menandai bahwa method dimaksudkan untuk menimpa method induk dan membantu compiler mendeteksi kesalahan. |

2. Kapan Anda memilih overloading dan kapan overriding? Beri satu contoh masing-masing dari jobsheet ini.

```
Gunakan Overloading jika Anda ingin memberikan fleksibilitas pilihan data input (parameter) dalam satu instruksi logika. Contoh: Method kali() yang ada di dalam class Perkalian.
Gunakan Overriding saat ingin mengganti sebagian atau seluruh perilaku logik sebuah method superclass (parent) sehingga menghasilkan fungsionalitas turunan yang lebih relevan. Contoh: Method lihatInfo() pada class Manager yang menimpa method di class Karyawan.
```

3. Jelaskan mengapa method static, private, dan final tidak dapat di-override, masingmasing dalam satu atau dua kalimat.

```
Static: Method ini ditambatkan langsung ke tingkatan struktur Class bukan memori instansiasi objek, sehingga menghalangi mekanisme pemanggilan polimorfisme (dynamic binding).  Private: Penanda akses ini secara ketat mengunci keberadaan method dari seluruh subclass turunannya, alhasil fungsi itu dianggap tidak ada untuk dilakukan override.  Final: Pemberian penanda final menandakan bahwa susunan dari sebuah method maupun parameter harus mutlak dan dilarang dirubah modifikasinya seumur hidup struktur.
```
