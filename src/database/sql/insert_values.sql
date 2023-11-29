INSERT INTO Author ( authorDocument ,name , email, password, phone )
VALUES
    ('111.111.111-11', 'Thiago Camposs', 'thithi@proton.com', 'qp4!V7Ak@S3*tTfvnTrYyPMZCM%2JY3', '(XX)XXXXXXXXX'),
    ('222.222.222-22', 'Pedro Dalge Rossini', 'pedroDR@gmail.com', '#E5#rcNksJJ$eX4!jvTrYEVNu*2E6zk', '(XX)XXXXXXXXX'),
    ('1', 'test', 'test@gmail.com', '1', '(XX)XXXXX-XXXX')
;
INSERT INTO Revisor ( name ,email ,password ,phone ,document ,lattes ,workingInstitution ,researchId )
VALUES
    ('Claytones', 'clayclay@gmail.com', 'K%JpG3XvN#bH5@nE!mqJSNc2HB4Sbwh', '(XX)XXXXXXXXX', 'XXX.XXX.XXX-XX', 'https://lattes.cnpq.br/XXXXXXXXXXXXX', 'Instituto Federal de São Paulo - Campus Bragança Paulista', 'XXXXXX')
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
    ('womens health', 2)
;
SELECT * FROM Author;
SELECT * FROM Revisor;    
SELECT * FROM Area;
SELECT * FROM Subarea;

INSERT INTO AcademicEvent( name ,initDate ,endDate ,location ,theme ,description ,areaDirectorId, idsAcceptedArticles , activitiesId , participantsId)
VALUES
    ('Technology Week', '22/11/2023', '26/11/2023', 'IFSP - bra', 'Technology', 'Daily lectures on the lasted and most relevant topics in the world of technology!', NULL, NULL, NULL,NULL )
;


SELECT * FROM AcademicEvent;