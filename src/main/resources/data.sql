INSERT INTO TROLE (id, nombre) VALUES (1, 'ADMIN');
INSERT INTO TROLE (id, nombre) VALUES (2, 'USER');

INSERT INTO TUSUARIO (nombre, a_paterno, a_materno)
VALUES ('Haru', 'Sánchez', 'Okumura');

INSERT INTO TUSUARIO (nombre, a_paterno, a_materno)
VALUES ('Makoto', 'Sánchez', 'Niijima');

INSERT INTO USUARIO_ROL (USUARIO_ID, ROL_ID) VALUES (1, 1);
INSERT INTO USUARIO_ROL (USUARIO_ID, ROL_ID) VALUES (1, 2);
INSERT INTO USUARIO_ROL (USUARIO_ID, ROL_ID) VALUES (2, 1);
