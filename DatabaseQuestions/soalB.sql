-- insert data into necessary foreign keys (mata pelajaran and mahasiswa)
INSERT INTO mata_pelajaran(name, "SKS")
    VALUES
        ('Matematika', 4),
        ('Fisika', 5),
        ('Olahraga', 3);
    

INSERT INTO mahasiswa(name, gender)
    VALUES
        ('John', 'Male'),
        ('Tyson', 'Male'),
        ('Miyoung', 'Female'),
        ('Tarik', 'Male');


-- insert data into nilai mahasiswa after foreign keys exist
INSERT INTO nilai_mahasiswa(id_mahasiswa, mata_pelajaran, nilai, tahun, semester)
    VALUES
        (1, 1, 90.0, 2022, 2),
        (1, 2, 86.0, 2025, 3),
        (2, 1, 87.0, 2022, 1),
        (2, 3, 89.0, 2024, 2),
        (3, 1, 94.0, 2022, 1),
        (3, 2, 94.0, 2025, 1),
        (3, 3, 92.0, 2025, 1),
        (4, 1, 80.0, 2023, 2),
        (4, 3, 70.0, 2023, 5)

