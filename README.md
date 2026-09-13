# Praktikum 3 - Konsep State dan Rekomposisi

Aplikasi Android berbasis Jetpack Compose yang mengimplementasikan konsep pengelolaan state, rekomposisi, dan state hoisting pada tiga fitur utama: Aplikasi Counter, Toggle Warna Box, dan Profil Interaktif.

## Implementasi State di Aplikasi

Pengelolaan data UI pada aplikasi ini sepenuhnya menggunakan mekanisme state di Jetpack Compose:
- **Aplikasi Counter**: Menggunakan variabel state `count` yang dideklarasikan dengan `remember { mutableStateOf(0) }`. Setiap kali tombol `+ Tambah` atau `- Kurang` diklik, nilai `count` diperbarui dan secara otomatis memicu rekomposisi pada komponen teks angka.
- **Toggle Warna Box**: Menggunakan variabel state boolean `isRed` dengan `remember { mutableStateOf(true) }`. Interaksi klik pada Box mengubah nilai `isRed`, yang kemudian menentukan warna latar belakang (Merah atau Hijau) serta teks indikator warna secara dinamis.
- **Profil Interaktif**: Menerapkan pola state hoisting melalui komponen `FollowButtonHoisted`. State `isFollowed` disimpan pada komponen induk (`ProfileTab`) dan dioper ke komponen tombol via parameter, sehingga pembaruan tombol dan teks indikator di bawahnya terjadi secara bersamaan dari satu sumber data.

## Keuntungan Jetpack Compose Dibandingkan XML Tradisional

Untuk kasus pengelolaan state interaktif, Jetpack Compose menawarkan pendekatan yang jauh lebih sederhana dibandingkan XML tradisional:
1. **Paradigma Deklaratif**: Pada Compose, UI secara otomatis memperbarui tampilannya begitu variabel state yang diobservasi berubah. Hal ini berbeda dengan XML imperatif yang mengharuskan kita mencari ID View (`findViewById` atau ViewBinding) dan mengubah propertinya secara manual satu per satu.
2. **Bebas Boilerplate & Lebih Aman**: Seluruh kode UI dan logika state ditulis menggunakan bahasa Kotlin murni. Kita tidak perlu mengelola file layout XML terpisah, sehingga terhindar dari potensi kesalahan seperti data UI tidak sinkron (*state mismatch*) atau `NullPointerException`.
3. **State Hoisting & Komponen Reusable**: Compose mempermudah pemisahan logika data dari tampilan melalui state hoisting, sehingga komponen UI seperti tombol Follow dapat digunakan kembali (*reusable*) di bagian aplikasi mana pun secara bersih dan fleksibel.
