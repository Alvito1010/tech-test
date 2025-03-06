
INSERT INTO kelas(name, "Jurusan")
    VALUES
    ('RF', 'Computer Science'),
    ('RG', 'Computer Science'),
    ('RB', 'Computer Science'),
    ('RF', 'Information Systems'),
    ('RP', 'Information Systems'),
    ('RB', 'Information Systems');


INSERT INTO kelas_mahasiswa(id_mahasiswa, id_kelas)
    VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (4, 4);

    
    





SELECT ROW_NUMBER() OVER (ORDER BY M.id) as "No", M.id as "NIM", M.name as "Name", K.name as "Kelas", MP.name as "Pelajaran", NM.tahun as "Tahun", NM.nilai as "Nilai"
FROM mahasiswa as M

INNER JOIN kelas_mahasiswa as KM ON M.id = KM.id_mahasiswa
INNER JOIN kelas as K ON KM.id_kelas = K.id

INNER JOIN nilai_mahasiswa as NM ON M.id = NM.id_mahasiswa
INNER JOIN mata_pelajaran as MP ON NM.mata_pelajaran = MP.id

WHERE K.name = 'RF' AND MP.name = 'Matematika' AND NM.tahun = 2022 AND NM.nilai > 85
ORDER BY M.id

