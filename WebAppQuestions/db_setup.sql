-- Active: 1738515536995@@127.0.0.1@5432@db_techtest
CREATE DATABASE db_techtest;

CREATE TABLE negara(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
)

CREATE TABLE provinsi(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    negara_id INT,
    CONSTRAINT fk_provinsi FOREIGN KEY(negara_id) REFERENCES negara(id)
)

CREATE TABLE kota(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    provinsi_id INT,
    CONSTRAINT fk_kota FOREIGN KEY(provinsi_id) REFERENCES provinsi(id)
)

INSERT INTO negara(name)
    VALUES
    ('Indonesia'),
    ('South Korea'),
    ('United States of America');

INSERT INTO provinsi(name, negara_id)
    VALUES
    ('DKI Jakarta', 1),
    ('Jawa Barat', 1),
    ('Jawa Tengah', 1),
    ('Jawa Timur', 1),

    ('Gyeonggi', 2),
    ('Chungcheong', 2),
    ('Gangwon', 2),
    ('Incheon', 2),

    ('California', 3),
    ('Texas', 3),
    ('Massachusetts', 3),
    ('Florida', 3);


INSERT INTO kota(name, provinsi_id)
    VALUES

    ('Jakarta Timur', 1),
    ('Jakarta Barat', 1),
    ('Jakarta Utara', 1),
    ('Jakarta Selatan', 1),
    ('Jakarta Pusat', 1),

    ('Bandung', 2),
    ('Bekasi', 2),
    ('Depok', 2),
    ('Bogor', 2),
    ('Cimahi', 2),

    ('Semarang', 3),
    ('Surakarta', 3),
    ('Magelang', 3),
    ('Pekalongan', 3),
    ('Tegal', 3),

    ('Surabaya', 4),
    ('Malang', 4),
    ('Kediri', 4),
    ('Blitar', 4),
    ('Madiun', 4),



    ('Suwon', 5),
    ('Seongnam', 5),
    ('Goyang', 5),
    ('Yongin', 5),
    ('Bucheon', 5),

    ('Cheongju', 6),
    ('Chungju', 6),
    ('Jecheon', 6),
    ('Danyang', 6),
    ('Okcheon', 6),

    ('Chuncheon', 7),
    ('Wonju', 7),
    ('Gangneung', 7),
    ('Donghae', 7),
    ('Samcheok', 7),

    ('Incheon', 8),
    ('Bupyeong', 8),
    ('Namdong', 8),
    ('Seo', 8),
    ('Yeonsu', 8),



    ('Los Angeles', 9),
    ('San Francisco', 9),
    ('San Diego', 9),
    ('San Jose', 9),
    ('Sacramento', 9),

    ('Houston', 10),
    ('Dallas', 10),
    ('Austin', 10),
    ('San Antonio', 10),
    ('Fort Worth', 10),

    ('Boston', 11),
    ('Cambridge', 11),
    ('Worcester', 11),
    ('Springfield', 11),
    ('Lowell', 11),

    ('Miami', 12),
    ('Orlando', 12),
    ('Tampa', 12),
    ('Jacksonville', 12),
    ('Tallahassee', 12);



CREATE Table pelajaran(
    id SERIAL PRIMARY KEY,
    code VARCHAR(255),
    name VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE
)

    