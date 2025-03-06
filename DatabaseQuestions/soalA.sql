
CREATE DATABASE db_mahasiswa;

DROP TABLE IF EXISTS mahasiswa;
CREATE TABLE mahasiswa(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(70),
    gender VARCHAR
)

DROP TABLE IF EXISTS kelas;
CREATE TABLE kelas(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(70),
    "Jurusan" VARCHAR
)

DROP TABLE IF EXISTS kelas_mahasiswa;
CREATE TABLE kelas_mahasiswa(
    id SERIAL NOT NULL PRIMARY KEY,
    id_mahasiswa INT,
    id_kelas INT,
    CONSTRAINT fk_mahasiswa FOREIGN KEY(id_mahasiswa) REFERENCES mahasiswa(id),
    CONSTRAINT fk_kelas FOREIGN KEY(id_kelas) REFERENCES kelas(id)
)



DROP TABLE IF EXISTS mata_pelajaran;
CREATE TABLE mata_pelajaran(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(70),
    "SKS" INT
)


DROP TABLE IF EXISTS nilai_mahasiswa;
CREATE TABLE nilai_mahasiswa(
    id SERIAL NOT NULL PRIMARY KEY,
    id_mahasiswa INT,
    mata_pelajaran INT,
    nilai DECIMAL,
    tahun INT,
    semester INT,
    CONSTRAINT fk_mahasiswa FOREIGN KEY(id_mahasiswa) REFERENCES mahasiswa(id),
    CONSTRAINT fk_mata_pelajaran FOREIGN KEY(mata_pelajaran) REFERENCES mata_pelajaran(id)
)