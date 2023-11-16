DROP TABLE IF EXISTS Subarea;
DROP TABLE IF EXISTS Area;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Revisor;
DROP TABLE IF EXISTS Article;
DROP TABLE IF EXISTS Author_x_Article;
DROP TABLE IF EXISTS Evaluation;


CREATE TABLE IF NOT EXISTS Author(
    authorId INTEGER NOT NULL PRIMARY KEY, 
    name VARCHAR(99),
    email VARCHAR(99),
    password VARCHAR(99),
    phone VARCHAR(99),
    document VARCHAR(99)
);
CREATE TABLE IF NOT EXISTS Revisor(
    revisorId INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(99),
    email VARCHAR(99),
    password VARCHAR(99),
    phone VARCHAR(99),
    document VARCHAR(99),
    lattes VARCHAR(99),
    workingInstitution VARCHAR(99),
    researchId VARCHAR(99)
);
CREATE TABLE IF NOT EXISTS Area(
    areaId INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(99)
);
CREATE TABLE IF NOT EXISTS Subarea(
    subareaId INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(99),
    areaId INTEGER,
    FOREIGN KEY (subareaId) REFERENCES Area(subareaId)
);
CREATE TABLE IF NOT EXISTS Revisor_x_Area(
    revisor_x_areaId INTEGER NOT NULL PRIMARY KEY,
    revisorId INTEGER,
    areaId INTEGER,
    FOREIGN KEY (revisorId) REFERENCES Revisor(revisorId),
    FOREIGN KEY (areaId) REFERENCES Area(areaId)
);
CREATE TABLE IF NOT EXISTS Article(
    articleId INTEGER NOT NULL PRIMARY KEY,
    title VARCHAR(99),
    summary VARCHAR(99),
    keyword VARCHAR(99),
    involveHumans BOOLEAN,
    processNumber VARCHAR(99),
    pdfFile VARCHAR(99),
    subAreaId INTEGER,
    evaluation1Id VARCHAR(99),
    evaluation2Id VARCHAR(99),
    evaluation3Id VARCHAR(99),
    FOREIGN KEY (subAreaId) REFERENCES Subarea(subAreaId);
);
CREATE TABLE IF NOT EXISTS Author_x_Article(
    uid INTEGER NOT NULL PRIMARY KEY, 
    authorId INT NOT NULL,
    articleId INT NOT NULL,
    FOREIGN KEY (authorId) REFERENCES Author(authorId),
    FOREIGN KEY (articleId) REFERENCES Article(articleId)
);
CREATE TABLE IF NOT EXISTS Evaluation(
    evaluationId INTEGER NOT NULL PRIMARY KEY,
    articleId INT NOT NULL,
    revisorId INT NOT NULL,
    comment VARCHAR(99),
    grade INT,
    FOREIGN KEY (revisorId) REFERENCES Revisor(revisorId),
    FOREIGN KEY (articleId) REFERENCES Article(articleId)
);
