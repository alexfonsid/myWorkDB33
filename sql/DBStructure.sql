DROP TABLE IF EXISTS pc;
DROP TABLE IF EXISTS monitor;
DROP TABLE IF EXISTS cabinet;
DROP TABLE IF EXISTS department;

CREATE TABLE department
(
    id_department integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name_department character varying NOT NULL,
    PRIMARY KEY (id_department)
);

CREATE TABLE cabinet
(
    id_cabinet integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name_cabinet character varying NOT NULL,
    number_cabinet integer NOT NULL,
    floor_cabinet integer NOT NULL,
    id_department_cabinet integer NOT NULL,
    PRIMARY KEY (id_cabinet),
    FOREIGN KEY (id_department_cabinet) REFERENCES department (id_department) ON DELETE RESTRICT
);

CREATE TABLE pc
(
    id_pc integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    inventory_number_pc character varying NOT NULL,
    serial_number_pc character varying NOT NULL,
    id_cabinet_pc integer NOT NULL,
	PRIMARY KEY (id_pc),
	FOREIGN KEY (id_cabinet_pc) REFERENCES cabinet (id_cabinet) ON DELETE RESTRICT
);

CREATE TABLE monitor
(
    id_monitor integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    inventory_number_monitor character varying NOT NULL,
    serial_number_monitor character varying NOT NULL,
    id_cabinet_monitor integer NOT NULL,
	PRIMARY KEY (id_monitor),
	FOREIGN KEY (id_cabinet_monitor) REFERENCES cabinet (id_cabinet) ON DELETE RESTRICT
);



