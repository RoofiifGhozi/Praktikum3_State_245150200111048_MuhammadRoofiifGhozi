# Praktikum 3 Konsep State dan Rekomposisi

Aplikasi ini dibuat untuk memenuhi tugas praktikum bab 3 mengenai konsep state dan rekomposisi pada Jetpack Compose. Terdapat tiga fitur utama yang dibuat yaitu aplikasi counter, toggle warna box, dan profil interaktif.

## Implementasi State di Aplikasi

Pengelolaan data UI pada aplikasi ini memanfaatkan variabel state yang disimpan menggunakan remember dan mutableStateOf. Pada fitur counter, variabel state digunakan untuk menyimpan nilai angka yang otomatis bertambah atau berkurang saat tombol diklik. Pada fitur toggle warna box, state boolean digunakan untuk mengubah warna latar belakang box antara merah dan hijau ketika area box disentuh. Sementara pada fitur profil, state digunakan untuk mengatur status tombol follow sekaligus mengubah teks indikator di bawahnya secara bersamaan melalui penerapan state hoisting.

## Analisis Compose Dibandingkan XML Tradisional

Penggunaan Jetpack Compose jauh lebih sederhana dibandingkan XML tradisional untuk kasus penanganan state. Pada XML imperatif, kita harus menghubungkan ID elemen menggunakan ViewBinding atau findViewById dan mengubah properti tampilan secara manual melalui kode. Sedangkan pada Compose yang bersifat deklaratif, UI akan otomatis memperbarui tampilannya begitu nilai state berubah. Hal ini membuat penulisan kode menjadi lebih ringkas, mengurangi risiko kesalahan data UI yang tidak sinkron, serta memudahkan pemisahan logika komponen agar dapat digunakan kembali.
