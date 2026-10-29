|            | Praktikum Pemrograman Berbasis Objek                                                        |
| ---------- | ------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                |
| Nama       | Achmad Pradita Dwi Firmansyah                                                               |
| Kelas      | TI - 2G                                                                                     |
| Repository | [link](https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet09) |

# Percobaan

## Percobaan 1: Bentuk Dasar Polimorfisme

### Langkah 4: Eksperimen

| Perubahan                        | Pesan error                                                                       |
| -------------------------------- | --------------------------------------------------------------------------------- |
| Aktifkan baris Vegetarian v2 = l | Type mismatch: cannot convert from GambaranDasar.Lion to GambaranDasar.Vegetarian |

### Class Employee.java

```
package jobsheet09.percobaan1;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeInfo() {
        return "Name = " + name;
    }
}
```

### Interface Payable.java

```
package jobsheet09.percobaan1;

public interface Payable {
    int getPaymentAmount();
}
```

### Class InternshipEmployee.java

```
package jobsheet09.percobaan1;

public class InternshipEmployee extends Employee {
    private int length;

    public InternshipEmployee(String name, int length) {
        super(name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " + length + " month/s\n";
        return info;
    }
}
```

### Class PermanentEmployee.java

```
package jobsheet09.percobaan1;

public class PermanentEmployee extends Employee implements Payable{
    private int salary;

    public PermanentEmployee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int getPaymentAmount() {
        return (int) (salary + 0.05 * salary); //gaji + bonus 5%
    }

    @Override
    public String getEmployeeInfo() {
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as permanent employee with salary " + salary + "\n";
        return info;
    }
}
```

### Class ElectricityBill.java

```
package jobsheet09.percobaan1;

public class ElectricityBill implements Payable {
    private int kwh;
    private String category;

    public ElectricityBill(int kwh, String category) {
        this.kwh = kwh;
        this.category = category;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int getPaymentAmount() {
        return kwh * getBasePrice();
    }

    public int getBasePrice() {
        return switch (category) {
            case "R-1" -> 100;
            case "R-2" -> 200;
            default -> 0;
        };
    }

    public String getBillInfo() {
        return "KWH = " + kwh + "\n"
            + "category = " + category + " (" + getBasePrice() + " perKWH)\n";
    }
}
```

### Class MainPercobaan1.java

```
package jobsheet09.percobaan1;

public class MainPercobaan1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        Employee e;
        Payable p;

        e = pEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        e = iEmp;
        System.out.println("e menunjuk objek " + e.getClass().getSimpleName());
        p = pEmp;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
        p = eBill;
        System.out.println("p menunjuk objek " + p.getClass().getSimpleName());
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
e menunjuk objek PermanentEmployee
e menunjuk objek InternshipEmployee
e menunjuk objek PermanentEmployee
e menunjuk objek ElectricityBill
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Eksperimen

| Tambahan pada main | Pesan error                                                      |
| ------------------ | ---------------------------------------------------------------- |
| p = iEmp;          | Type mismatch: cannot convert from InternshipEmployee to Payable |
| e = eBill;         | Type mismatch: cannot convert from ElectricityBill to Employee   |

Pesan error: incompatible types: InternshipEmployee cannot be
converted to Payable dan incompatible types: ElectricityBill cannot be
converted to Employee. InternshipEmployee tidak meng-implements Payable, dan
ElectricityBill bukan turunan Employee, sehingga keduanya bukan bentuk dari tipe yang dituju.

## Pertanyaan Percobaan 1

1. Class apa saja yang merupakan turunan dari class Employee?

```
Class yang merupakan turunan dari Class Employee adalah class PermanentEmployee & InternshipEmployee
```

2. Class apa saja yang meng-implements interface Payable?

```
Class yang meng-implements interface Payable adalah class PermanentEmployee dan ElectricityBill
```

3. Pada MainPercobaan1, mengapa e dapat diisi dengan objek pEmp (PermanentEmployee) dan iEmp (InternshipEmployee)?

```
Karena e adalah objek milik Employee yang merupakan superclass dari class PermanentEmployee dan class InternshipEmployee sehingga bisa objek superclass bisa diisi dengan objek subclassnya.
```

4. Pada MainPercobaan1, mengapa p dapat diisi dengan objek pEmp (PermanentEmployee) dan eBill (ElectricityBill)?

```
p dapat diisi dengan objek pEmp (PermanentEmployee) dan eBill (ElectricityBill) karena kedua class tersebut meng-implements Interface Payable sehingga objek p milik Payable dapat diisi oleh objek yang meng-implementsnya
```

5. Apa penyebab error pada p = iEmp; dan e = eBill;? Bandingkan dengan error pada Vegetarian v2 = l;.

```
Error pada p = iEmp, dan e = eBill, adalah karena masing masing objek tidak memiliki relasi sehingga menghasilkan error objek iEmp dan eBill tidak bisa diisikan ke objek p dan e, error ini sama dengan error pada Vegetarian v2 = l yang tidak memiliki relasi
```

6. Pada GambaranDasar, variabel a bertipe Animal, tetapi getClass() menampilkan Deer. Apa beda tipe referensi dan tipe objek?

```
Variabel a bertipe Animal, tetapi getClass() menampilkan Deer karena Animal a = d, perbedaan tipe referensi dan tipe objek adalah, tipe referensi adalah tipe data yang dideklarasikan pada variabel, sedangkan tipe objek adalah tipe class nyata dari instansiasi objek di memori.
```

7. Ambil kesimpulan tentang konsep dan bentuk dasar polimorfisme.

```
Polimorfisme berarti satu objek dapat dipandang dalam banyak bentuk, Bentuk yang paling umum adalah variabel bertipe superclass atau interface dipakai untuk menunjuk objek dari subclass (relasi is-a) atau dari class yang meng-implements interface tersebut.

```

## Percobaan 2: Virtual Method Invocation

### Class MainPercobaan2.java

```
package jobsheet09.percobaan2;

public class MainPercobaan2 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        Employee e;
        e = pEmp;
        System.out.println(e.getEmployeeInfo());
        System.out.println("------------------");
        System.out.println(pEmp.getEmployeeInfo());
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        e = iEmp;
        System.out.println("------------------");
        System.out.println(e.getEmployeeInfo()); //pernyataan sama, objek berbeda
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Dedik
Registered as permanent employee with salary 500

------------------
Name = Sunarto
Registered as internship employee for 5 month/s

PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Eksperimen

| Perubahan                                     | Pesan error                                               |
| --------------------------------------------- | --------------------------------------------------------- |
| Panggil e.getSalary() pada e bertipe Employee | The method getSalary() is undefined for the type Employee |

## Pertanyaan Percobaan 2

1. Pada langkah 1, mengapa e.getEmployeeInfo() dan pEmp.getEmployeeInfo() menghasilkan hasil yang sama?

```
e.getEmployeeInfo() dan pEmp.getEmployeeInfo() menghasilkan hasil yang sama karena variabel referensi e dan pEmp menunjuk ke objek yang sama, yaitu PermanentEmployee.
```

2. Mengapa pemanggilan e.getEmployeeInfo() disebut pemanggilan method virtual, sedangkan pEmp.getEmployeeInfo() tidak?

```
pemanggilan e.getEmployeeInfo() disebut pemanggilan method virtual karena pemanggilan dilakukan dari tipe referensi dan tipe objeknya berbeda yaitu Employee dan PermanentEmployee, sedangkan pEmp.getEmployeeInfo() tidak karena tipe referensi dan tipe objeknya sama yaitu PermanentEmployee.
```

3. Jelaskan maksud virtual method invocation. Mengapa disebut virtual?

```
Virtual method invocation adalah pemanggilan method hasil overriding melalui referensi polimorfik. Disebut virtual karena method yang dikenali compiler (berdasarkan tipe referensi) berbeda dari method yang dijalankan JVM (berdasarkan tipe objek sebenarnya).
```

4. Pada langkah 3, mengapa pernyataan e.getEmployeeInfo() yang sama menghasilkan keluaran berbeda?

```
Pernyataan e.getEmployeeInfo() yang sama menghasilkan keluaran berbeda karena method yang dijalankan mengikuti objek yang berbeda yang ditunjuk e.
```

5. Pada langkah 4, mengapa e.getSalary() ditolak compiler padahal objek yang ditunjuk e adalah PermanentEmployee?

```
e.getSalary() ditolak compiler karena compiler hanya memeriksa method berdasarkan tipe referensi variabelnya, yaitu Employee. Karena di dalam class Employee tidak terdapat deklarasi method getSalary(), maka proses kompilasi gagal meskipun saat runtime objek yang ditunjuk oleh e adalah PermanentEmployee.
```

## Percobaan 3: Heterogeneous Collection

### Class MainPercobaan3.java

```
package jobsheet09.percobaan3;

public class MainPercobaan3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "R-1");

        Employee[] e = {pEmp, iEmp};
        Payable[] p = {pEmp, eBill};
        // Employee[] e2 = {pEmp, iEmp, eBill}; // tidak valid

        for (Employee emp : e) {
            System.out.println(emp.getEmployeeInfo());
        }

        int total = 0;
        for (Payable tagihan : p) {
            total += tagihan.getPaymentAmount();
        }
        System.out.println("Total tagihan bulan ini = " + total);
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Name = Dedik
Registered as permanent employee with salary 500

Name = Sunarto
Registered as internship employee for 5 month/s

Total tagihan bulan ini = 1025
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Eksperimen

| Perubahan                                           | Pesan error                                                    |
| --------------------------------------------------- | -------------------------------------------------------------- |
| Aktifkan baris Employee[] e2 = {pEmp, iEmp, eBill}; | Type mismatch: cannot convert from ElectricityBill to Employee |

## Pertanyaan Percobaan 3

1. Mengapa array e dapat berisi objek pEmp (PermanentEmployee) dan iEmp (InternshipEmployee) yang bertipe berbeda?

```
array e dapat berisi objek pEmp (PermanentEmployee) dan iEmp (InternshipEmployee) yang bertipe berbeda, karena kedua objek tersebut merupakan turunan dari Class Employee array e
```

2. Mengapa array p dapat berisi objek pEmp (PermanentEmployee) dan eBill (ElectricityBill) yang bertipe berbeda?

```
array p dapat berisi objek pEmp (PermanentEmployee) dan eBill (ElectricityBill) yang bertipe berbeda, karena kedua class tersebut sama-sama meng-implements interface Payable, sehingga keduanya kompatibel menjadi elemen array bertipe Payable[].
```

3. Mengapa terjadi error pada Employee[] e2 = {pEmp, iEmp, eBill};?

```
error pada Employee[] e2 = {pEmp, iEmp, eBill} terjadi karena  ElectricityBill bukan turunan Employee, sehingga tidak boleh menjadi elemen array bertipe Employee.
```

4. Pada perulangan for (Employee emp : e), mengapa setiap elemen menghasilkan teks yang berbeda padahal pemanggilannya sama? Hubungkan dengan Percobaan 2.

```
Pada perulangan for (Employee emp : e) setiap elemen menghasilkan teks yang berbeda padahal pemanggilannya sama karena mekanisme Virtual Method Invocation seperti pada Percobaan 2. Meskipun dipanggil dengan pernyataan yang sama, saat runtime JVM akan mengeksekusi method getEmployeeInfo() hasil overriding sesuai dengan tipe objek sebenarnya(dynamic method dispatch).
```

## Percobaan 4: Polymorphic Argument, instanceof, dan Casting Objek

### Class Owner.java

```
package jobsheet09.percobaan4;

public class Owner {
    public void pay(Payable p) {
        System.out.println("Total payment = " + p.getPaymentAmount());
        if (p instanceof ElectricityBill) {
            ElectricityBill eb = (ElectricityBill) p;
            System.out.println(eb.getBillInfo());
        }else if (p instanceof PermanentEmployee) {
            PermanentEmployee pe = (PermanentEmployee) p;
            System.out.println(pe.getEmployeeInfo());
        }
    }

    public void showMyEmployee(Employee e) {
        System.out.println(e.getEmployeeInfo());
        if (e instanceof PermanentEmployee) {
            System.out.println("You have to pay her/him monthly!!!");
        } else {
            System.out.println("No need to pay him/her :)");
        }
    }
}
```

### Class MainPercobaan4.java

```
package jobsheet09.percobaan4;

public class MainPercobaan4 {
    public static void main(String[] args) {
        Owner ow = new Owner();

        ElectricityBill eBill = new ElectricityBill(5, "R-1");
        ow.pay(eBill); // bayar tagihan listrik
        System.out.println("--------------------------------------------");

        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        ow.pay(pEmp); // bayar pegawai tetap
        System.out.println("--------------------------------------------");

        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ow.showMyEmployee(pEmp); // info pegawai tetap
        System.out.println("--------------------------------------------");
        ow.showMyEmployee(iEmp); // info pegawai magang
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Total payment = 500
KWH = 5
category = R-1 (100 perKWH)

--------------------------------------------
Total payment = 525
Name = Dedik
Registered as permanent employee with salary 500

--------------------------------------------
Name = Dedik
Registered as permanent employee with salary 500

You have to pay her/him monthly!!!
--------------------------------------------
Name = Sunarto
Registered as internship employee for 5 month/s

No need to pay him/her :)
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

### Eksperimen

| Perubahan                                                 | Hasil                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| --------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Tambahkan ow.pay(iEmp); di akhir main pada MainPercobaan4 | The method pay(Payable) in the type Owner is not applicable for the arguments (InternshipEmployee)                                                                                                                                                                                                                                                                                                                                                                       |
| Buat class Eksperimen4 berikut dan jalankan Hasil:        | PS C:\G\PraktikumPemrogramanBerbasisObjek> Sebelum casting Exception in thread "main" java.lang.ClassCastException: class jobsheet09.percobaan4.InternshipEmployee cannot be cast to class jobsheet09.percobaan4.PermanentEmployee (jobsheet09.percobaan4.InternshipEmployee and jobsheet09.percobaan4.PermanentEmployee are in unnamed module of loader 'app') at jobsheet09.percobaan4.Eksperimen4.main(Eksperimen4.java:7) PS C:\G\PraktikumPemrogramanBerbasisObjek> |

## Pertanyaan Percobaan 4

1. Pada MainPercobaan4, mengapa ow.pay(eBill) dan ow.pay(pEmp) dapat dilakukan, padahal parameter pay() bertipe Payable? Perhatikan bahwa eBill adalah ElectricityBill dan pEmp adalah PermanentEmployee.

```
ow.pay(eBill) dan ow.pay(pEmp) dapat dilakukan, padahal parameter pay() bertipe Payable karena kedua class tersebut sama-sama meng-implements interface Payable, sehingga objek dari kedua class tersebut dapat diterima sebagai argumen.
```

2. Apa tujuan membuat parameter bertipe Payable pada method pay() di class Owner?

```
tujuan membuat parameter bertipe Payable pada method pay() di class Owner agar satu method pay() bersifat fleksibel dan dapat menerima berbagai objek dari class apa pun selama class tersebut meng-implements interface Payable.
```

3. Mengapa ow.pay(iEmp) menyebabkan error?

```
Karena method pay parameter bertipe Payable dan ow.pay(iEmp) merupakan pemanggilan method dengan parameter dari InternshipEmployee yang bukan merupakan turunan dari Payable sehingga akan menghasilkan error The method pay(Payable) in the type Owner is not applicable for the arguments (InternshipEmployee)
```

4. Pada Owner, untuk apa sintaks p instanceof ElectricityBill diperlukan?

```
Pada Owner sintaks p instanceof ElectricityBill diperlukan untuk mengidentifikasi bahwa p adalah objek dari ElectricityBill sehingga dapat di-cast ke ElectricityBill
```

5. Pada Owner, untuk apa casting (ElectricityBill) p diperlukan? Mengapa objek p bertipe Payable harus di-cast ke eb bertipe ElectricityBill? Petunjuk: method apa yang dikenal oleh tipe Payable?

```
casting (ElectricityBill) p diperlukan agar bisa mengakses method di ElectricityBill, objek p bertipe Payable harus di-cast ke eb bertipe ElectricityBill agar mengenali method getBillInfo() yang ada di ElectricityBill, karena objek p hanya mengenali method getPaymentAmount()
```

6. Pada Eksperimen4, mengapa kode lolos kompilasi tetapi gagal saat dijalankan? Bagaimana instanceof mencegah kegagalan tersebut?

```
Pada Eksperimen4, kode lolos kompilasi tetapi gagal saat dijalankan karena objek e di instansiasi dari class InternshipEmployee, sehingga ketika di casting ke PermanentEmployee tidak bisa, karena internshipEmployee tidak memiliki relasi ke PermanentEmployee. Oleh karena itu, Instanceof dapat mencegah kegagalan tersebut dengan memeriksa tipe objek nyata saat runtime terlebih dahulu (if (e instanceof PermanentEmployee)) sehingga proses casting hanya dijalankan apabila kondisinya bernilai true.
```

# Tugas dan Deliverable

## Tugas 1: Permainan Zombie, Barrier, dan Plant

### Class Destroyable.java

```
package jobsheet09.tugas1;

public interface Destroyable {
    void destroyed();
}
```

### Class Plant.java

```
package jobsheet09.tugas1;

public class Plant{
    public void doDestroy(Destroyable d) {
        d.destroyed();
    }
}
```

### Class Barrier.java

```
package jobsheet09.tugas1;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        strength = strength * 9/10;
    }

    public String getBarrierInfo() {
        return "Strength = " + strength;
    }
}
```

### Class Zombie.java

```
package jobsheet09.tugas1;

abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    public abstract void destroyed();

    public String getZombieInfo() {
        return "Health = " + health + " Level = " + level;
    }
}

```

### Class WalkingZombie.java

```
package jobsheet09.tugas1;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                health = Math.min(health + health * 10 / 100, 100);
                break;
            case 2:
                health = Math.min(health + health * 30 / 100, 100);
                break;
            case 3:
                health = Math.min(health + health * 40 / 100, 100);
                break;
            default:
                break;
        }
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data = " + super.getZombieInfo() + "\n";
    }
}
```

### Class JumpingZombie.java

```
package jobsheet09.tugas1;

public class JumpingZombie extends Zombie {
    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                health = Math.min(health + health * 30 / 100, 100);
                break;
            case 2:
                health = Math.min(health + health * 40 / 100, 100);
                break;
            case 3:
                health = Math.min(health + health * 50 / 100, 100);
                break;
            default:
                break;
        }
    }

    @Override
    public void destroyed() {
        this.health -= health * 10 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data = " + super.getZombieInfo() + "\n";
    }
}
```

### Class MainTugas1.java

```
package jobsheet09.tugas1;

public class MainTugas1 {
    public static void main(String[] args) {
        WalkingZombie wz = new WalkingZombie(100, 1);
        JumpingZombie jz = new JumpingZombie(100, 2);
        Barrier b = new Barrier(100);
        Plant p = new Plant();
        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
        System.out.println("----------------------");

        for (int i = 0; i < 4; i++) { // hancurkan 4 kali
            p.doDestroy(wz);
            p.doDestroy(jz);
            p.doDestroy(b);
        }

        System.out.println(wz.getZombieInfo());
        System.out.println(jz.getZombieInfo());
        System.out.println(b.getBarrierInfo());
    }

}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Walking Zombie Data = Health = 100 Level = 1

Jumping Zombie Data = Health = 100 Level = 2

Strength = 100
----------------------
Walking Zombie Data = Health = 42 Level = 1

Jumping Zombie Data = Health = 66 Level = 2

Strength = 64
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan analisis:

- (a) Mengapa Plant.doDestroy() dapat menerima WalkingZombie, JumpingZombie, dan Barrier padahal ketiganya tidak berada dalam satu hierarki class?

```
Plant.doDestroy() dapat menerima WalkingZombie, JumpingZombie, dan Barrier karena parameter d pada method doDestroy() bertipe interface Destroyable. Meskipun ketiganya tidak berada dalam satu hierarki superclass yang sama, class Barrier dan abstract class Zombie sama-sama meng-implements interface Destroyable.
```

- (b) Pada d.destroyed() di dalam Plant, apa tipe referensi dan tipe objek, dan versi destroyed() mana yang dijalankan untuk tiap pemanggilan di MainTugas1?

```
Pada d.destroyed() di dalam Plant, tipe referensinya adalah Destroyable. Sedangkan tipe objek dan versi destroyed() yang dijalankan pada MainTugas1 adalah:
p.doDestroy(wz): Tipe objeknya adalah WalkingZombie, dan yang dijalankan adalah destroyed() milik WalkingZombie.
p.doDestroy(jz): Tipe objeknya adalah JumpingZombie, dan yang dijalankan adalah destroyed() milik JumpingZombie.
p.doDestroy(b): Tipe objeknya adalah Barrier, dan yang dijalankan adalah destroyed() milik Barrier.
```

- (c) Apa yang terjadi bila Anda menulis new Zombie(100, 1)? Tuliskan pesan errornya.

```
Jika kita menulis new Zombie(100, 1) maka akan error karena Zombie adalah abstract class, sehingga tidak dapat diinstansiasi secara langsung.
Pesan Error: Cannot instantiate the type Zombie
```

## Tugas 2: Heterogeneous collection, instanceof, dan casting

### Class MainTugas2.java

```
package jobsheet09.tugas2;

public class MainTugas2 {
    public static void main(String[] args) {

        Destroyable[] arrayD = {
                new WalkingZombie(100, 1),
                new JumpingZombie(100, 2),
                new Barrier(100)
        };
        Plant p = new Plant();

        for (int i = 0; i < 4; i++) {
            for (Destroyable d : arrayD) {
                p.doDestroy(d);
            }
        }

        for (Destroyable d : arrayD) {
            if (d instanceof Zombie) {
                Zombie z = (Zombie)d;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (d instanceof Barrier) {
                Barrier b = (Barrier)d;
                System.out.println(b.getBarrierInfo());
            }
        }
    }
}
```

### Hasil Run Terminal

```
PS C:\G\PraktikumPemrogramanBerbasisObjek>
Walking Zombie Data = Health = 46 Level = 1

Jumping Zombie Data = Health = 92 Level = 2

Strength = 64
PS C:\G\PraktikumPemrogramanBerbasisObjek>
```

## Pertanyaan analisis:

- (a) Mengapa array harus bertipe Destroyable, bukan Zombie?

```
Array harus bertipe Destroyable karena array harus dapat  menampung objek WalkingZombie, JumpingZombie, sekaligus Barrier. Class Barrier bukanlah subclass dari Zombie, sehingga tidak dapat disimpan di dalam array bertipe Zombie[].
```

- (b) Mengapa casting ke Zombie diperlukan sebelum memanggil heal()?

```
Casting ke tipe Zombie diperlukan karena variabel elemen array bertipe referensi Destroyable. Di dalam interface Destroyable hanya terdapat deklarasi method destroyed() dan tidak terdapat method heal(). Oleh karena itu, referensi d harus di casting ke Zombie terlebih dahulu agar compiler mengenali dan mengizinkan pemanggilan method heal().
```

- (c) Apa yang terjadi bila pemeriksaan instanceof dihilangkan dan elemen Barrier di-cast ke Zombie?

```
Kode program tetap lolos proses kompilasi, tetapi akan berhenti error saat dijalankan, karena objek nyata di memori adalah Barrier yang tidak memiliki relasi dengan class Zombie.
```

## Tugas 3: Prediksi hasil kompilasi

| Pernyataan                             | Prediksi              | Alasan                                                                                                                                                              |
| -------------------------------------- | --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Zombie z = new WalkingZombie(100, 1);  | Ok                    | Karena WalkingZombie adalah subclass dari Zombie, sehingga variabel referensi dapat digunakan untuk menyimpan objek subclass                                        |
| Destroyable d = z;                     | Ok                    | Karena Class Zombie mengimplements Destroyable sehingga variabel referensi dapat digunakan untuk menyimpan referensi Zombie                                         |
| Zombie z2 = d;                         | error kompilasi   | Error, karena mengubah d bertipe Destroyable ke tipe yang lebih spesifik (Zombie) wajib menggunakan casting (Zombie)                                                |
| Zombie z3 = (Zombie) d;                | Ok                    | Karena sudah menggunakan casting (Zombie) dan isi objek asli di dalam d adalah turunan dari Zombie (yaitu WalkingZombie)                                            |
| Zombie z4 = new Zombie(100, 1);        | error kompilasi       | Karena Zombie adalah abstract class, sehingga tidak bisa dibuat objeknya secara langsung                                                                            |
| Destroyable d2 = new Plant();          | error kompilasi   | Karena plant tidak mengimplements Destroyable, melainkan hanya memanggil Destroyable di dalam parameter                                                             |
| Zombie z5 = new JumpingZombie(100, 2); | Ok                    | Karena JumpingZombie adalah subclass dari Zombie, sehingga variabel referensi dapat digunakan untuk menyimpan objek subclass                                        |
| WalkingZombie w = (WalkingZombie) z5;  | error saat dijalankan | Lolos saat di-compile, tapi error saat dijalankan karena isi objek asli di dalam z5 adalah JumpingZombie, sehingga tidak bisa dipaksa berubah menjadi WalkingZombie |
