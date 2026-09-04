|            | Praktikum Pemrograman Berbasis Objek                                                         |
| ---------- | -------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                 |
| Nama       | Achmad Pradita Dwi Firmansyah                                                                |
| Kelas      | TI - 2G                                                                                      |
| Repository | [link] (https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet02) |

# Langkah Kerja

## Langkah Kerja 2

_Reactangle.java_

```
package jobsheet02;

public class Reactangle {
    int width;
    int height;
}
```

_Main.java_

```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle r = new Reactangle();
        r.width = 6;
        r.height = 4;

        System.out.println("Reactangle " + r.width + "x" + r.height);
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main'
Reactangle 6x4
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## Langkah Kerja 3

_Reactanlge.java_

```
package jobsheet02;

public class Reactangle {
    int width;
    int height;

    int area() {
        return width * height;
    }

    int perimeter() {
        return 2 * (width + height);
    }
}
```

_Main.java_

```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle r = new Reactangle();
        r.width = 6;
        r.height = 4;

        System.out.println("Reactangle " + r.width + "x" + r.height);
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main'
Reactangle 6x4
Area: 24 Perimeter: 20
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## Langkah Kerja 4

_Reactangle.java_

```
package jobsheet02;

public class Reactangle {
    int width;
    int height;

    Reactangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int area() {
        return width * height;
    }

    int perimeter() {
        return 2 * (width + height);
    }
}
```

_Main.java_

```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle r = new Reactangle(6, 4);

        System.out.println("Reactangle " + r.width + "x" + r.height);
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  c:; cd 'c:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek'; & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main'
Reactangle 6x4
Area: 24
Perimeter: 20
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

## Langkah Kerja 5

_Main.java_

```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle original = new Reactangle(6, 4);

        System.out.println("Area: " + original.area());

        Reactangle copy = original;
        copy.width = 10;
        System.out.println("Via original: " + original.area());
        System.out.println("Via copy: " + copy.area());

        Reactangle empty = null;
        System.out.println(empty.area());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main'
Area: 24
Via original: 40
Via copy: 40
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "jobsheet02.Reactangle.area()" because "empty" is null
        at jobsheet02.Main.main(Main.java:15)
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>
```

*Setelah hapus 2 baris uji null*
```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle original = new Reactangle(6, 4);

        System.out.println("Area: " + original.area());

        Reactangle copy = original;
        copy.width = 10;
        System.out.println("Via original: " + original.area());
        System.out.println("Via copy: " + copy.area());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  c:; cd 'c:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek'; & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main' 
Area: 24
Via original: 40
Via copy: 40
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek> 
```

## Langkah Kerja 6
*Student.java*
```
package jobsheet02;

public class Student {
    private String name;
    private String studentId;
    private double gpa;

    Student(String name, String studentId, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String describe() {
        return name + " (" + studentId + ", GPA: " + gpa + ")";
    }
}
```

*Main.java*
```
package jobsheet02;

public class Main {
    public static void main(String[] args) {
        Reactangle original = new Reactangle(6, 4);

        System.out.println("Area: " + original.area());

        Reactangle copy = original;
        copy.width = 10;
        System.out.println("Via original: " + original.area());
        System.out.println("Via copy: " + copy.area());

        Student s = new Student("Nadia", "S001", 3.8);
        System.out.println(s.describe());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main' 
Area: 24
Via original: 40
Via copy: 40
Nadia (S001, GPA: 3.8)
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek> 
```

## Langkah Kerja 7
*Main.java*
```
package jobsheet02;

public class Main {
    public static void main(String[] args) {        
        Reactangle [] shapes = new Reactangle[3];
        shapes[0] = new Reactangle(6, 4);
        shapes[1] = new Reactangle(3, 3);
        shapes[2] = new Reactangle(8, 2);
        
        for (Reactangle r : shapes) {
            System.out.println("Area: " +r.area() + ", Perimeter: " +r.perimeter());
        }

        Student s = new Student("Nadia", "S001", 3.8);
        System.out.println(s.describe());
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main' 
Area: 24, Perimeter: 20
Area: 9, Perimeter: 12
Area: 16, Perimeter: 20
Nadia (S001, GPA: 3.8)
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek> 
```

# Tugas Mandiri
## 1. Buat kelas Circle
*Circle.java*
```
package jobsheet02;

public class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }
}
```

*Hasil Run Terminal*
```
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek>  & 'C:\Program Files\Java\jdk-24\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\ACER\AppData\Roaming\Code\User\workspaceStorage\4cf050fa69df9a7583a54155788fea83\redhat.java\jdt_ws\PraktikumPemrogramanBerbasisObjek_e6355637\bin' 'jobsheet02.Main' 
Area: 78.53981633974483, Circumference: 31.41592653589793
PS C:\PENYIMPANAN\Documents\G\PraktikumPemrogramanBerbasisObjek> 
```

## 2. Jawab singkat (2-3 kalimat masing-masing):
- a) apa bedanya objek dengan referensi ke objek?
```
Objek sudah memiliki alamat sedangkan referensi hanya menunjuk ke objek tersebut, sehingga ketika referensi dipanggil akan sama seperti memanggil objek tersebut.
```
- b) tepatnya kapan konstruktor sebuah kelas dijalankan?
```
Konstruktor akan dijalankan ketika sebuah objek sudah dibuat, konstruktor dijalankan dengan mengisi parameter ketika awal pembuatan objek
```