INSERT INTO Author (name , email, password, phone, document )
VALUES
    ('Thiago Camposs', 'thithi@proton.com', 'qp4!V7Ak@S3*tTfvnTrYyPMZCM%2JY3', '(XX)XXXXXXXXX','XXX.XXX.XXX-XX'),
    ('Pedro Dalge Rossini', 'pedroDR@gmail.com', '#E5#rcNksJJ$eX4!jvTrYEVNu*2E6zk', '(XX)XXXXXXXXX','XXX.XXX.XXX-XX')
;
INSERT INTO Revisor ( name ,email ,password ,phone ,document ,lattes ,workingInstitution ,researchId ,areasOfInterest )
VALUES
    ('Claytones', 'clayclay@gmail.com', 'K%JpG3XvN#bH5@nE!mqJSNc2HB4Sbwh', '(XX)XXXXXXXXX', 'XXX.XXX.XXX-XX', 'https://lattes.cnpq.br/XXXXXXXXXXXXX', 'Instituto Federal de São Paulo - Campus Bragança Paulista', 'XXXXXX', 'Linux')
;    
INSERT INTO Area (title )
VALUES
    ('Technology'),
    ('Health'),
    ('Finance'),
    ('Exact sciences')
;

INSERT INTO Subarea(title , areaId )
VALUES
    ('Linux',1),
    ('Artificial Intelligence',1),
    ("women's health", 2)
;
SELECT * FROM Author;
SELECT * FROM Revisor;    
SELECT * FROM Area;
SELECT * FROM Subarea;