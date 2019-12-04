CREATE TABLE Pathways (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL, #title of pathway
    languageReq double, #language arts requirement
    mathReq double, #mathematics requirement
    scienceReq double, #science requirement
    socialReq double, #social studies requirement
    govReq double, #us government/citizenship requirement
    healthReq double, #health education requirement
    peReq double, #physical education requirement
    fitnessReq double, #fitness for life requirement
    artsReq double, #fine arts requirement
    cteReq double, #career and technical education requirement
    compReq double, #computer technology requirement
    financialReq double, #financial literacy requirement
    electiveReq double, #general electives requirement
    PRIMARY KEY (id)
);

CREATE TABLE Students (
    id int NOT NULL,
    name varchar(255),
    grade int NOT NULL,
    pathwayId int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (pathwayId) REFERENCES Pathways(id)
);

INSERT INTO Pathways (title, mathReq, scienceReq, govReq)
VALUES ('Utah Aerospace Pathways', 4.00, 6.00, 0.50);

INSERT INTO Students
VALUES (9632019, 'Daniel Elliott', 12, 1);

INSERT INTO Pathways (title, languageReq, mathReq, scienceReq)
VALUES ('Regents', 4.00, 4.00, 4.00);