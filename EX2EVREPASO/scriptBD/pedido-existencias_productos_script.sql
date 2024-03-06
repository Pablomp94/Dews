 /*
DROP TABLE PRODUCTO_EXISTENCIAS;
*/

CREATE TABLE PRODUCTO_EXISTENCIAS (
	PRODUCTO_ID VARCHAR(30) NOT NULL,
	CANTIDAD INTEGER NOT NULL,
	PRIMARY KEY (PRODUCTO_ID),
	FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTO(ID)
);


/* 
delete from PRODUCTO_EXISTENCIAS;
*/

/* NUEVOS PRODUCTOS */
INSERT INTO PRODUCTO
(ID, MARCA, MODELO, IMAGENURL, CARACTERISTICAS, ESPECIFICACIONES, FECHA_LANZAMIENTO, PRECIO, CATEGORIA_CODIGO)
VALUES('SonyA7III', 'Sony', 'A7 III', 'imagenes/1862-sony-alpha-7-iii-242mp-wifi-bluetooth-cuerpo-negro.webp', 'Cuerpo 24Mpx ', 
'<ul><li>Sensor Full-Frame Exmor R BSI CMOS de 24MP</li><li>Vídeo 4K</li><li>AF de 693 puntos y 10 fps</li>
<li>710 disparos por carga</li><li>Doble ranura compatible UHS-II</li><li>Pantalla táctil y abatible de 3 pulgadas</li>
<li>Estabilizador de 5 ejes</li><li>Wi-Fi y NFC</li><li>USB 3.1 de tipo USB-C</li></ul>', 
'2021-01-01', 1849, 'Foto');

INSERT INTO PRODUCTO
(ID, MARCA, MODELO, IMAGENURL, CARACTERISTICAS, ESPECIFICACIONES, FECHA_LANZAMIENTO, PRECIO, CATEGORIA_CODIGO)
VALUES('SonyA7IV', 'Sony', 'A7 IV', 'imagenes/2586-sony-alpha-7-iv-33mp-wifi-bluetooth-cuerpo.webp', 'Cuerpo 33Mpx BSI', 
'<ul><li>Sensor Exmor R de fotograma completo retroiluminado de 33 MP<br></li>
<li>Vídeo 4K hasta a 60p<br></li>
<li>Tecnología de seguimiento en tiempo real y AF/Eye AF&nbsp;<br></li>
<li>10 fps<br></li>
<li>Visor electrónico de 3,69 millones de puntos</li>
<li>Pantalla táctil de 3 pulgadas multiángulo<br></li>
<li>Sistema de estabilización de imagen de 5 ejes<br></li>
<li>Doble ranura para tarjeta</li></ul>', '2023-01-01', 2499, 'Foto');