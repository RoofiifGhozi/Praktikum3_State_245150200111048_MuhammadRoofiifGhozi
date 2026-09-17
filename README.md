# Praktikum 3 - Konsep State dan Rekomposisi

Aplikasi ini dibuat untuk memenuhi tugas praktikum bab 3 mengenai konsep state dan rekomposisi pada Jetpack Compose. Terdapat tiga fitur utama yang dibuat di dalam aplikasi yaitu aplikasi counter, toggle warna box, dan profil interaktif.

## Implementasi State di Aplikasi

1. **Aplikasi Counter**  
   Pengelolaan angka memakai variabel state count yang dibuat menggunakan remember { mutableStateOf(0) }. Variabel ini bertindak sebagai tempat menyimpan data angka awal yaitu nol. Ketika tombol Tambah atau Kurang diklik, nilai count diubah sehingga Compose secara otomatis mendeteksi perubahan data tersebut dan memperbarui teks angka yang ada di layar tanpa perlu pemanggilan manual.

2. **Toggle Warna Box**  
   Pengaturan warna latar belakang box memanfaatkan variabel state boolean isRed dengan remember { mutableStateOf(true) }. Saat area kotak diklik, event sentuhan akan mengubah nilai isRed dari true menjadi false atau sebaliknya. Perubahan nilai ini memicu Compose untuk mengganti warna box antara merah dan hijau serta mengubah teks di dalam box secara dinamis.

3. **Profil Interaktif**  
   Fitur profil ini menerapkan teknik state hoisting untuk memisahkan data dari tampilan tombol. Variabel state isFollowed disimpan pada komponen utama yaitu ProfileTab lalu nilainya dioper ke komponen tombol FollowButtonHoisted. Dengan begitu, saat tombol diklik, perubahan status tidak hanya mengubah teks pada tombol dari Follow menjadi Unfollow, tetapi juga otomatis mengubah warna dan teks indikator di bawahnya secara bersamaan.

## Analisis Compose Dibandingkan XML Tradisional

Penggunaan Jetpack Compose jauh lebih sederhana dibandingkan XML tradisional untuk kasus penanganan state. Pada XML imperatif, kita harus menghubungkan ID elemen menggunakan ViewBinding atau findViewById dan mengubah properti tampilan secara manual melalui kode. Sedangkan pada Compose yang bersifat deklaratif, UI akan otomatis memperbarui tampilannya begitu nilai state berubah. Hal ini membuat penulisan kode menjadi lebih ringkas, mengurangi risiko kesalahan data UI yang tidak sinkron, serta memudahkan pemisahan logika komponen agar dapat digunakan kembali.
