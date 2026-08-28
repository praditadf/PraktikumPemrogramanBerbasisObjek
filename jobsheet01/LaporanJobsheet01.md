|            | Praktikum Pemrograman Berbasis Objek                                               |
| ---------- | ---------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                       |
| Nama       | Achmad Pradita Dwi Firmansyah                                                      |
| Kelas      | TI - 2G                                                                            |
| Repository | [link] (https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/jobsheet01) |

# 3. Percobaan

## 3.1 Percobaan 1

**Class Bike**

```
package jobsheet01;
public class Bike {
    private String brand;
    private int speed;
    private int gear = 1;
    // Gear 1: max 5 km/h, Gear 2: mac 10 km/h, ... Gear 6: max 60 km/h
    private final int[] GEAR_SPEED_LIMITS = { 5, 10, 25, 30, 40, 60 };

    void setBrand(String brandName) {
        brand = brandName;
    }

    void gearChanges(int gearValue) {
        if (gearValue < 1 || gearValue > 6) {
            System.out.println("Invalid gear value. Gear must be beetween 1 and 6.");
        } else {
            gear = gearValue;
        }
    }

    int speedAcceleration(int increment) {
        speed += increment;
        if (speed > GEAR_SPEED_LIMITS[gear - 1]) {
            speed = GEAR_SPEED_LIMITS[gear - 1];
        }
        return speed;
    }
    int speedDeceleration(int decrement) {
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        return speed;
    }

    void printInfo(){
        System.out.println("Brand : " + brand);
        System.out.println("Speed : " + speed);
        System.out.println("Gear : " + gear);
    }
}
```

**Class BikeDemo**

```
package jobsheet01;

public class BikeDemo {
    public static void main(String[] args) {
        Bike mountainBike1 = new Bike();
        Bike mountainBike2 = new Bike();

        mountainBike1.setBrand("Trek");
        mountainBike1.speedAcceleration(10);
        mountainBike1.gearChanges(2);
        mountainBike1.printInfo();

        mountainBike2.setBrand("Giant");
        mountainBike2.speedAcceleration(20);
        mountainBike2.gearChanges(3);
        mountainBike2.printInfo();
    }
}
```

The solution is implemented in BikeDemo.java, and below is screenshot of the result.

![Screenshot](img/img1.png)

## 3.2 Percobaan 2

**Class RoadBike**

```
package jobsheet01;

public class RoadBike extends Bike{
    private int tireWidth;

    void setTireWidth(int width) {
        tireWidth = width;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("Tire Width : " + tireWidth + " mm");
        System.out.println("Bike Type : Road Bike ");
    }

}
```

**Class BikeDemo**

```
package jobsheet01;

public class BikeDemo {
    public static void main(String[] args) {
        Bike mountainBike1 = new Bike();
        Bike mountainBike2 = new Bike();
        RoadBike roadBike1 = new RoadBike();

        mountainBike1.setBrand("Trek");
        mountainBike1.speedAcceleration(10);
        mountainBike1.gearChanges(2);
        mountainBike1.printInfo();

        mountainBike2.setBrand("Giant");
        mountainBike2.speedAcceleration(20);
        mountainBike2.gearChanges(3);
        mountainBike2.printInfo();

        roadBike1.setBrand("Spesialized");
        roadBike1.setTireWidth(25);
        roadBike1.speedAcceleration(15);
        roadBike1.gearChanges(4);
        roadBike1.printInfo();
    }
}
```

The solution is implemented in BikeDemo.java, and below is screenshot of the result.

![Screenshot](img/img2.png)

**Pertanyaan**

1. Jelaskan perbedaan antara object dengan class!

```
* Object : 
* Class  : 
```

2. Jelaskan alasan gear dan brand dapat menjadi atribut dari object Bike!

```
Gear dan brand 
```

3. Sebutkan salah satu kelebihan utama dari pemrograman berorientasi objek dibandingkan dengan pemrograman prosedural!

```
Pemograman berorientasi objek 
```

4. Apakah diperbolehkan melakukan pendefinisian dua buah atribut dalam satu baris kode seperti “public String nama, alamat;”?

```
Pendefinisian dua buah atribut dalam saru baris kode
```

5. Pada class RoadBike, jelaskan alasan atribut brand, speed, dan gear tidak lagi ditulis di dalam class tersebut!

```
Atribut brand, speed, dan gear tidak lagi ditulis di dalam class RoadBike 
```

# Praktikum

