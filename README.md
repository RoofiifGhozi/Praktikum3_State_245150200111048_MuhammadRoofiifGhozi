# Praktikum 3 Konsep State dan Rekomposisi

Aplikasi ini dibuat untuk memenuhi tugas praktikum bab 3 mengenai konsep state dan rekomposisi pada Jetpack Compose. Terdapat tiga fitur utama yang dibuat yaitu aplikasi counter, toggle warna box, dan profil interaktif.

## Implementasi State di Aplikasi

1. **Aplikasi Counter**  
   Pengelolaan angka menggunakan variabel state count yang dideklarasikan dengan remember { mutableStateOf(0) }. Setiap kali tombol Tambah atau Kurang diklik, nilai variabel diperbarui sehingga Compose otomatis memperbarui teks angka di layar.

2. **Toggle Warna Box**  
   Pengaturan warna box menggunakan state boolean isRed dengan remember { mutableStateOf(true) }. Saat area box diklik, nilai isRed di-toggle yang secara otomatis mengubah warna latar belakang box antara merah dan hijau.

3. **Profil Interaktif**  
   Penerapan state hoisting dilakukan pada tombol Follow, di mana variabel state isFollowed disimpan pada komponen induk (ProfileTab) dan dikirim ke komponen tombol melalui parameter. Hal ini memungkinkan pembaruan tombol dan teks indikator status pengikutan di bawahnya terjadi secara bersamaan.

## Analisis Compose Dibandingkan XML Tradisional

Penggunaan Jetpack Compose jauh lebih sederhana dibandingkan XML tradisional untuk kasus penanganan state. Pada XML imperatif, kita harus menghubungkan ID elemen menggunakan ViewBinding atau findViewById dan mengubah properti tampilan secara manual melalui kode. Sedangkan pada Compose yang bersifat deklaratif, UI akan otomatis memperbarui tampilannya begitu nilai state berubah. Hal ini membuat penulisan kode menjadi lebih ringkas, mengurangi risiko kesalahan data UI yang tidak sinkron, serta memudahkan pemisahan logika komponen agar dapat digunakan kembali.
