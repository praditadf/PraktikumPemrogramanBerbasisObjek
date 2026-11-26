|            | Praktikum Pemrograman Berbasis Objek                                                        |
| ---------- | ------------------------------------------------------------------------------------------- |
| NIM        | 254107020130                                                                                |
| Nama       | Achmad Pradita Dwi Firmansyah                                                               |
| Kelas      | TI - 2G                                                                                     |
| Repository | [link](https://github.com/praditadf/PraktikumPemrogramanBerbasisObjek/tree/main/jobsheet12) |

## Langkah 1: Proyek, Backend, dan Pemisahan Frontend-Backend

![alt text](langkah1.png)

## Langkah 2: Merancang Form dengan Matisse (FrmKategori)

![alt text](langkah2.png)

## Langkah 3: Menampilkan Data ke JTable

![alt text](langkah3.png)

## Langkah 4: Event Handling Pertama (Simpan dan Tambah Baru)

![alt text](langkah4.1.png)

![alt text](langkah4.2.png)

![alt text](langkah4.3.png)

## Langkah 5: Event Mouse, Hapus, dan Cari

![alt text](langkah5.1.png)

![alt text](langkah5.2.png)

![alt text](langkah5.3.png)

![alt text](langkah5.4.png)

![alt text](langkah5.5.png)

# Tugas dan Hasil Kerja

![alt text](tugas1.png)

![alt text](tugas2.png)

## Jawab secara singkat (2-3 kalimat untuk masing-masing pertanyaan):

- (a) Jelaskan perbedaan event source, listener, dan handler dengan contoh dari tombol Simpan. Mengapa blok initComponents() tidak boleh diedit?

```
Event source adalah btnSimpan (komponen yang diklik). Listener adalah objek ActionListener yang didaftarkan ke tombol lewat addActionListener. Handler adalah method btnSimpanActionPerformed yang dipanggil saat tombol diklik. initComponents() tidak boleh diedit karena dibuat otomatis oleh Matisse dan akan ditimpa ulang saat desain berubah, sehingga editan manual hilang atau merusak sinkronisasi desain dan kode.
```

- (b) Mengapa setelah save() kode memanggil tampilkanData() dan tidak menambah baris ke tabel secara langsung?

```
Backend adalah satu-satunya sumber data, tabel hanya tampilannya. Memuat ulang lewat tampilkanData() menjamin isi tabel sama dengan data sebenarnya, termasuk id baru dan hasil ubah. Menambah baris manual berisiko tabel dan backend tidak sinkron.
```

- (c) Pertemuan berikutnya data diganti dari memori ke database. Bagian mana dari form yang perlu diubah, dan mengapa?

```
Yang diubah hanya implementasi backend (getAll, save, delete, search, getById diganti query database). Form tidak perlu berubah karena hanya memanggil method dan tidak tahu cara data disimpan (Single Responsibility, loose coupling).
```
