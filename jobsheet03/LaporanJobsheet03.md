|            | Praktikum Pemrograman Berbasis Objek                                                         |
| ---------- | -------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                 |
| Nama       | Achmad Pradita Dwi Firmansyah                                                                |
| Kelas      | TI - 2G                                                                                      |
| Repository | [link] (https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet03) |

# Percobaan

## Percobaan 1 - Enkapsulasi

### Class Motor.java

```
package jobsheet03.MotorEncapsulation;

public class Motor {
    public int kecepatan = 0;
    public boolean kontanOn = false;

    public void printStatus() {
        if (kontanOn == true) {
            System.out.println("Kontak On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan " + kecepatan + "\n");
    }
}
```

### Class MotorDemo.java

```
package jobsheet03.MotorEncapsulation;

public class MotorDemo {

    public static void main(String[] args) {
        Motor motor = new Motor();
        motor.printStatus();
        motor.kecepatan = 50;
        motor.printStatus();
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Kontak Off
Kecepatan 0

Kontak Off
Kecepatan 50

PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## Percobaan 2 - Access Modifier

### Class Motor.java

```
package jobsheet03.MotorEncapsulation;

public class Motor {
    private int kecepatan = 0;
    private boolean kontanOn = false;

    public void nyalakanMesin() {
        kontanOn = true;
    }

    public void matikanMesin() {
        kontanOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (kontanOn == true) {
            kecepatan += 5;
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin Off! \n");
        }
    }

    public void kurangiKecepatan() {
        if (kontanOn == true) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena Mesin Off! \n");
        }
    }

    public void printStatus() {
        if (kontanOn == true) {
            System.out.println("Kontak On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan " + kecepatan + "\n");
    }

}
```

### Class MotorDemo.java

```
package jobsheet03.MotorEncapsulation;

public class MotorDemo {

    public static void main(String[] args) {
        Motor motor = new Motor();
        motor.printStatus();
        motor.tambahKecepatan();

        motor.nyalakanMesin();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.tambahKecepatan();
        motor.printStatus();

        motor.matikanMesin();
        motor.printStatus();
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Kontak Off
Kecepatan 0

Kecepatan tidak bisa bertambah karena Mesin Off!

Kontak On
Kecepatan 0

Kontak On
Kecepatan 5

Kontak On
Kecepatan 10

Kontak On
Kecepatan 15

Kontak Off
Kecepatan 0

PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

### Pertanyaan

1. Pada class TestMobil, saat kita menambah kecepatan untuk pertama kalinya, mengapa muncul peringatan “Kecepatan tidak bisa bertambah karena Mesin Off!”?

```

```

2. Mengapa atribut kecepatan dan kontakOn diset private?

```

```

3. Ubah class Motor sehingga kecepatan maksimalnya adalah 100!

```

```

## Percobaan 3 - Getter dan Setter

### Class Anggota.java

```
package jobsheet03.KoperasiGetterSetter;

public class Anggota {
    private String nama;
    private String alamat;
    private float simpanan;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public float getSimpanan() {
        return simpanan;
    }

    public void setor(float uang) {
        simpanan += uang;
    }

    public void pinjam(float uang) {
        simpanan -= uang;
    }
}
```

### Class KoperasiDemo.java

```
package jobsheet03.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota();
        anggota1.setNama("Iwan Setiawan");
        anggota1.setAlamat("Jalan Sukarno Hatta no 10");
        anggota1.setor(100000);
        System.out.println("Simanan " +anggota1.getNama()+ " : Rp " +anggota1.getSimpanan());

        anggota1.pinjam(5000);
        System.out.println("Simanan " +anggota1.getNama()+ " : Rp " +anggota1.getSimpanan());
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Simanan Iwan Setiawan : Rp 100000.0
Simanan Iwan Setiawan : Rp 95000.0
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## Percobaan 4 - Konstuktor, Instasiasi

### Class Anggota.java

```
package jobsheet03.KoperasiGetterSetter;

public class Anggota {
    private String nama;
    private String alamat;
    private float simpanan;

    Anggota(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
        this.simpanan = 0;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public float getSimpanan() {
        return simpanan;
    }

    public void setor(float uang) {
        simpanan += uang;
    }

    public void pinjam(float uang) {
        simpanan -= uang;
    }
}
```

### Class KoperasiDemo.java

```
package jobsheet03.KoperasiGetterSetter;

public class KoperasiDemo {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Iwan", "Jalan Mawar");
        System.out.println("Simanan " +anggota1.getNama()+ " : Rp " +anggota1.getSimpanan());

        anggota1.setNama("Iwan Setiawan");
        anggota1.setAlamat("Jalan Sukarno Hatta no 10");
        anggota1.setor(100000);
        System.out.println("Simanan " +anggota1.getNama()+ " : Rp " +anggota1.getSimpanan());

        anggota1.pinjam(5000);
        System.out.println("Simanan " +anggota1.getNama()+ " : Rp " +anggota1.getSimpanan());
    }
}
```

###

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Simanan null : Rp 0.0
Simanan Iwan Setiawan : Rp 100000.0
Simanan Iwan Setiawan : Rp 95000.0
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Simanan Iwan : Rp 0.0
Simanan Iwan Setiawan : Rp 100000.0
Simanan Iwan Setiawan : Rp 95000.0
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

### Pertanyaan – Percobaan 3 dan 4

1. Apa yang dimaksud getter dan setter?

```
Getter adalah public method dan memiliki tipe data return, yang berfungsi untuk mendapatkan nilai dari atribut private. Sedangkan setter adalah public method yang tidak memiliki tipe data return, yang berfungsi untuk memanipulasi nilai dari atribut private.

```

2. Apa kegunaan dari method getSimpanan()?

```

```

3. Method apa yang digunakan untuk menambah saldo?

```
Method yang digunakan untuk menambah saldo adalah method setor
```

4. Apa yang dimaksud konstruktor?

```

```

5. Sebutkan aturan dalam membuat konstruktor?

```
1. Nama konstruktor harus sama dengan nama class
2. Konstruktor tidak memiliki tipe data return
3. Konstruktor tidak boleh menggunakan modifier abstract, static, final, dan synchronized
```

6. Apakah boleh konstruktor bertipe private?

```
Di java kita dapat memiliki konstruktor dengan modifier private, protected, public or default.
```

7. Kapan menggunakan konstruktor dengan passing parameter?

```

```

8. Apa perbedaan inisialisasi atribut dan instansiasi atribut?

```

```

9. Apa perbedaan inisialisasi method dan instansiasi method?

```

```

# Tugas

## 1. Cobalah program dibawah ini dan tuliskan hasil outputnya

### Class EncapDemo.java

```
package jobsheet03.Tugas1;

public class EncapDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge > 30) {
            age = 30;
        }else {
            age = newAge;
        }
    }
}
```

### Class EncapTest.java

```
package jobsheet03.Tugas1;

public class EncapTest {
    public static void main(String[] args) {
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(35);

        System.out.println("Name : " + encap.getName());
        System.out.println("Age : " + encap.getAge());
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Name : James
Age : 30
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## 2. Pada program diatas, pada class EncapTest kita mengeset age dengan nilai 35, namun pada saat ditampilkan ke layar nilainya 30, jelaskan mengapa.

```
Program tersebut menampilkan nilai 30 di layar padahal kita mengeset dengan nilai 35, karena terdapat pemilihan pada method setAge dimana jika kita mengeset nilai diatas 30 maka akan menghasilkan age dengan nilai 30, namun jika kita mengeset dengan nilai dari 30 kebawah maka nilai yang dihasilkan akan sama dengan nilai yang kita set.
```

## 3. Ubah program diatas agar atribut age dapat diberi nilai maksimal 30 dan minimal 18

### Perubahan class EncapDemo.java

```
    public void setAge(int newAge) {
        if (newAge > 30) {
            age = 30;
        } else if (newAge < 18) {
            age = 18;
        } else {
            age = newAge;
        }
    }
```

### Perubahan Class EncapTest.java

```
        EncapDemo encap = new EncapDemo();
        encap.setName("James");
        encap.setAge(35);

        System.out.println("Name : " + encap.getName());
        System.out.println("Age : " + encap.getAge());

        encap.setAge(15);

        System.out.println("Name : " + encap.getName());
        System.out.println("Age : " + encap.getAge());
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Name : James
Age : 30
Name : James
Age : 18
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## 4. Pada sebuah sistem manajemen pergudangan kargo ekspedisi, terdapat class Kontainer yang memiliki atribut antara lain nomorResi, namaPemilik, kapasitasMaksimal (dalam kg), dan beratMuatanSaatIni. Kontainer dapat menerima tambahan muatan barang dengan batasan kapasitas maksimal yang telah ditentukan. Kontainer juga dapat diturunkan muatannya (bongkar muat). Ketika barang diturunkan, maka jumlah muatan saat ini akan berkurang sesuai dengan nominal berat yang dikeluarkan.<Br>Buatlah class Kontainer tersebut, berikan atribut (private), method getter, dan konstruktor sesuai dengan kebutuhan arsitektur enkapsulasi. Uji dengan kelas driver TestLogistik berikut ini untuk memeriksa apakah manajemen state kelas Anda telah berjalan dengan benar:

### Class Kontainer.java

```
package jobsheet03.Tugas2;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private float kapasitasMaksimal;
    private float beratMuatanSaatIni;

    Kontainer(String nomorResi, String namaPemilik, float kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
        beratMuatanSaatIni = 0;
    }

    public String getNomorResi() {
        return nomorResi;
    }
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public float getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public void tambahMuatan(float beratTambahan) {
        if (beratTambahan > kapasitasMaksimal) {
            System.out.println("Maaf, berat muatan melebihi kapasitas maksimal kontainer.");
        } else {
            beratMuatanSaatIni += beratTambahan;
        }
    }

    public void turunkanMuatan(float beratTurunkan) {
        if (beratTurunkan > beratMuatanSaatIni) {
            System.out.println("Maaf, berat muatan yang diturunkan melebihi batas muatan saat ini");
        }else {
            beratMuatanSaatIni -= beratTurunkan;
        }
    }

    public float getBeratMuatanSaatIni() {
        return beratMuatanSaatIni;
    }
}
```

### Class TestLogistik.java

```
package jobsheet03.Tugas2;

public class TestLogistik {
    public static void main(String[] args) {
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal());

        System.out.println("\nMemasukkan muatan baru seberat 6.000 kg...");
        kontainerAlfa.tambahMuatan(6000);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMemasukkan muatan baru seberat 4.000 kg...");
        kontainerAlfa.tambahMuatan(4000);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMembongkat muat/menurunkan barang seberat 500 kg...");
        kontainerAlfa.turunkanMuatan(500);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.println("\nMembongkat muat/menurunkan barang seberat 1.500 kg...");
        kontainerAlfa.turunkanMuatan(1500);
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet03.Tugas2.TestLogistik'
Nama Pemilik Kontainer: PT. Maju Bersama
Kapasitas Maksimal: 5000.0

Memasukkan muatan baru seberat 6.000 kg...
Maaf, berat muatan melebihi kapasitas maksimal kontainer.
Berat muatan saat ini: 0.0 kg

Memasukkan muatan baru seberat 4.000 kg...
Berat muatan saat ini: 4000.0 kg

Membongkat muat/menurunkan barang seberat 500 kg...
Berat muatan saat ini: 3500.0 kg

Membongkat muat/menurunkan barang seberat 1.500 kg...
Berat muatan saat ini: 2000.0 kg
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## 5. Modifikasi soal kargo logistik di atas agar nominal berat muatan yang dibongkar/diturunkan dalam satu kali pemanggilan method turunkanMuatan() maksimal hanya boleh sebesar 50% dari total berat muatan saat ini. Langkah ini diterapkan demi alasan keselamatan kerja operasional alat berat (crane). Jika operator mencoba menurunkan muatan melebihi batas 50% tersebut, sistem harus memblokir aksi dan memunculkan peringatan: "Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!".

### Perubahan method turunkanMuatan()

```
    public void turunkanMuatan(float beratTurunkan) {
        if (beratTurunkan > (beratMuatanSaatIni * 0.5)) {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
        }else {
            beratMuatanSaatIni -= beratTurunkan;
        }
    }
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Berat muatan saat ini: 5000.0 kg
Membongkat muat/menurunkan barang seberat 3.000 kg...
Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!
Berat muatan saat ini: 5000.0 kg
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## 6. Modifikasi kelas Main TestLogistik agar parameter jumlah berat barang yang dimasukkan (tambahMuatan) maupun berat barang yang dibongkar (turunkanMuatan) dapat menerima input nilai dinamis dari pengguna secara interaktif melalui terminal menggunakan utilitas java.util.Scanner.

### Perubahan Class TestLogistik.java

```
package jobsheet03.Tugas2;
import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer: " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: " + kontainerAlfa.getKapasitasMaksimal());

        float berat;

        System.out.print("\nMemasukkan muatan baru seberat : ");
        kontainerAlfa.tambahMuatan(berat = sc.nextFloat());
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");

        System.out.print("\nMembongkat muat/menurunkan barang seberat : ");
        kontainerAlfa.turunkanMuatan(berat = sc.nextFloat());
        System.out.println("Berat muatan saat ini: " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Nama Pemilik Kontainer: PT. Maju Bersama
Kapasitas Maksimal: 5000.0

Memasukkan muatan baru seberat : 4000
Berat muatan saat ini: 4000.0 kg

Membongkat muat/menurunkan barang seberat : 2500
Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!
Berat muatan saat ini: 4000.0 kg
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## 7. Sebuah aplikasi pemesanan tiket bioskop memerlukan kelas Tiket untuk mengelola data pemesanan secara aman. Kelas ini harus memiliki atribut private: judulFilm (String), hargaDasar (double), dan statusPembayaran (boolean).<br> Ketentuan pengesetan nilai objek:<br>● Konstruktor harus menerima parameter judulFilm dan hargaDasar. Nilai awal statusPembayaran selalu diset false (Belum Dibayar).<br>● Atribut hargaDasar tidak boleh bernilai negatif. Jika input yang dimasukkan kurang dari 0, otomatis set nilai default ke Rp 35.000.<br>● Sediakan method lakukanPembayaran() untuk mengubah statusPembayaran menjadi true.<br>● Nilai statusPembayaran hanya boleh dibaca (Read-Only) menggunakan getter, tidak boleh memiliki fungsi setter langsung dari luar kelas demi alasan keamanan transaksi.

### Class Tiket.java

```
package jobsheet03.Tugas3;

public class Tiket {
    private String judulFilm;
    private double hargaDasar;
    private boolean statusPembayaran;

    Tiket(String judulFilm, double hargaDasar) {
        this.judulFilm = judulFilm;
        this.hargaDasar = hargaDasar;
        statusPembayaran = false;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public double getHargaDasar() {
        if (hargaDasar < 0) {
            return hargaDasar = 35000;
        } else {
            return hargaDasar;
        }
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }

    public void lakukanPembayaran() {
        statusPembayaran = false;
    }
}
```

### Class TestBioskop.java

```
package jobsheet03.Tugas3;

public class TestBioskop {
    public static void main(String[] args) {
        Tiket tiket1 = new Tiket("Avengers: Endgame", -50000);
        System.out.println("Film: " + tiket1.getJudulFilm());
        System.out.println("Harga Tiket: " + tiket1.getHargaDasar());
        System.out.println("Status Lunas? " + tiket1.isStatusPembayaran());

        System.out.println("\nMemproses pembayaran...");
        tiket1.lakukanPembayaran();
        System.out.println("Status Lunas Terbaru? " + tiket1.isStatusPembayaran());
    }
}
```

### Hasil Run Terminal

```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
Film: Avengers: Endgame
Harga Tiket: 35000.0
Status Lunas? false

Memproses pembayaran...
Status Lunas Terbaru? false
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```