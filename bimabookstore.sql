-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Jul 2022 pada 13.20
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bimabookstore`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` int(11) NOT NULL,
  `kode_buku` varchar(10) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `penerbit_buku` varchar(100) NOT NULL,
  `genre_buku` varchar(50) NOT NULL,
  `harga_buku` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `kode_buku`, `judul_buku`, `penerbit_buku`, `genre_buku`, `harga_buku`) VALUES
(1, 'OP1', 'One Piece', 'Oda Eiichiro', 'Komik', 21000),
(2, 'BSD1', 'Bungo Stray Dogs', 'Kafka Asagiri', 'Komik', 98000),
(3, 'SXF1', 'Spy x Family', 'Endo Tatsuya', 'Komik', 33750),
(4, 'JJK1', 'Jujutsu Kaisen', 'Gege Akutami', 'Komik', 30000),
(6, 'N1', 'Naruto Shippuden', 'Masashi Kishimoto', 'Komik', 23000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_hp` int(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `total_buku` int(10) NOT NULL,
  `total_harga` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `nama`, `email`, `no_hp`, `alamat`, `judul_buku`, `total_buku`, `total_harga`) VALUES
(1, 'Bima', 'bima@gmail.com', 123, 'asd', 'One Piece', 3, 63000),
(2, 'Raka', 'raka@gmail.com', 123, 'asd', 'Spy x Family', 2, 67500),
(3, 'Jati', 'jati@gmail.com', 123, 'asd', 'Bungo Stray Dogs', 3, 294000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indeks untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `buku`
--
ALTER TABLE `buku`
  MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `id_pembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
