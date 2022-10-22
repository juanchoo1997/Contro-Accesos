CREATE TABLE roles (
	  idroles SERIAL NOT NULL,
	  descripcion VARCHAR(50) NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idroles)
	);

	CREATE TABLE empresa (
	  idempresa SERIAL NOT NULL,
	  nombre VARCHAR(50) NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idempresa)
	);

	CREATE TABLE Tipo_personal (
	  idTipo_personal SERIAL NOT NULL,
	  Descripción VARCHAR(50) NULL,
	  PRIMARY KEY(idTipo_personal)
	);

	CREATE TABLE tipo_identificacion (
	  idtipo_identificacion SERIAL NOT NULL,
	  descripcion VARCHAR(50) NULL,
	  PRIMARY KEY(idtipo_identificacion)
	);

	CREATE TABLE personal (
	  idpersonal SERIAL NOT NULL,
	  identificacion VARCHAR(20) NOT NULL,
	  tipo_identificacion_idtipo_identificacion INTEGER NOT NULL,
	  Tipo_personal_idTipo_personal INTEGER NOT NULL,
	  nombres VARCHAR(50) NULL,
	  apellidos VARCHAR(50) NULL,
	  empresa VARCHAR(50) NULL,
	  estado INTEGER NULL,
	  direccion VARCHAR(50) NULL,
	  telefono VARCHAR(10) NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idpersonal),
	  FOREIGN KEY(Tipo_personal_idTipo_personal)
		REFERENCES Tipo_personal(idTipo_personal)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION,
	  FOREIGN KEY(tipo_identificacion_idtipo_identificacion)
		REFERENCES tipo_identificacion(idtipo_identificacion)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);

	CREATE TABLE usuarios (
	  idusuarios SERIAL NOT NULL,
	  tipo_identificacion_idtipo_identificacion INTEGER NOT NULL,
	  empresa_idempresa INTEGER NOT NULL,
	  roles_idroles INTEGER NOT NULL,
	  usuario VARCHAR(50) NULL,
	  contrasena VARCHAR(50) NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idusuarios),
	  FOREIGN KEY(roles_idroles)
		REFERENCES roles(idroles)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION,
	  FOREIGN KEY(empresa_idempresa)
		REFERENCES empresa(idempresa)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION,
	  FOREIGN KEY(tipo_identificacion_idtipo_identificacion)
		REFERENCES tipo_identificacion(idtipo_identificacion)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);

	CREATE TABLE dispositivos (
	  iddispositivos SERIAL NOT NULL,
	  personal_idpersonal INTEGER NOT NULL,
	  serial VARCHAR(50) NOT NULL,
	  marca VARCHAR(50) NULL,
	  tipo VARCHAR(50) NULL,
	  fecha_registro DATE NULL,
	  url_qr VARCHAR(80) NULL,
	  PRIMARY KEY(iddispositivos),
	  FOREIGN KEY(personal_idpersonal)
		REFERENCES personal(idpersonal)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);

	CREATE TABLE biometria (
	  idbiometria SERIAL NOT NULL,
	  personal_idpersonal INTEGER NOT NULL,
	  ewsq VARCHAR(200) NULL,
	  iso VARCHAR(200) NULL,
	  fecha_enrolamiento DATE NULL,
	  dedo VARCHAR(50) NULL,
	  mano VARCHAR(50) NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idbiometria),
	  FOREIGN KEY(personal_idpersonal)
		REFERENCES personal(idpersonal)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);

	CREATE TABLE Accesos (
	  idAccesos SERIAL NOT NULL,
	  personal_idpersonal INTEGER NOT NULL,
	  usuarios_idusuarios INTEGER NOT NULL,
	  fecha_ingreso DATE NULL,
	  fecha_salida DATE NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(idAccesos),
	  FOREIGN KEY(personal_idpersonal)
		REFERENCES personal(idpersonal)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION,
	  FOREIGN KEY(usuarios_idusuarios)
		REFERENCES usuarios(idusuarios)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);

	CREATE TABLE dispositivos_Accesos (
	  Accesos_idAccesos INTEGER NOT NULL,
	  dispositivos_iddispositivos INTEGER NOT NULL,
	  fecha_registro DATE NULL,
	  PRIMARY KEY(Accesos_idAccesos, dispositivos_iddispositivos),
	  FOREIGN KEY(dispositivos_iddispositivos)
		REFERENCES dispositivos(iddispositivos)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION,
	  FOREIGN KEY(Accesos_idAccesos)
		REFERENCES Accesos(idAccesos)
		  ON DELETE NO ACTION
		  ON UPDATE NO ACTION
	);
