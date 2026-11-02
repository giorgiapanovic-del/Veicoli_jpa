
    create table bici (
    	id_veicoli integer not null,
        id_bici integer not null auto_increment,
        id_tipo_sospensione integer,
        numero_corone integer not null,
        numero_marce integer not null,
        pieghevole bit not null,
        tipo_freno varchar(255) not null,
        primary key (id_bici)
    ) engine=InnoDB;

    create table categoria (
        id integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table colore (
        id_colore integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id_colore)
    ) engine=InnoDB;

    create table macchina (
    	id_veicoli integer not null,
    	id_macchina integer not null auto_increment,
        cc integer not null,
        numero_porte integer not null,
        targa varchar(255) not null,
        primary key (id_macchina)
    ) engine=InnoDB;

    create table marca (
        id_marca integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id_marca)
    ) engine=InnoDB;

    create table moto (
    	id_veicoli integer not null,
    	id_moto integer not null auto_increment,
        cc integer not null,
        targa varchar(255) not null,
        primary key (id_moto)
    ) engine=InnoDB;

    create table notifica_systema (
        lang varchar(4) not null,
        code varchar(20) not null,
        notifica varchar(255),
        primary key (lang, code)
    ) engine=InnoDB;

    create table tipo_alimentazione (
        id_tipo_alimentazione integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id_tipo_alimentazione)
    ) engine=InnoDB;

    create table tipo_sospensione (
        id_tipo_sospensione integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id_tipo_sospensione)
    ) engine=InnoDB;

    create table tipo_veicolo (
        id_tipo_veicolo integer not null auto_increment,
        nome varchar(255) not null,
        primary key (id_tipo_veicolo)
    ) engine=InnoDB;

    create table veicoli (
    	id integer not null auto_increment,
    	categoria integer,
    	marca integer,
    	modello varchar(255) not null,
    	colore integer,
        anno_produzione integer not null,
        numero_ruote integer not null,
        tipo_alimentazione integer,
        tipo_veicolo integer,
        primary key (id)
    ) engine=InnoDB;

    alter table bici 
       add constraint UKe6edykb85nklxm94k84qd4ib1 unique (id_veicoli);

    alter table macchina 
       add constraint UKmkhkqnva0a2gap14g6q6nh04j unique (id_veicoli);

    alter table moto 
       add constraint UKaojq8pafgwdx95w4fkv3dxo52 unique (id_veicoli);

    alter table bici 
       add constraint FKblrxi1rdhposhi3egaxa5w58j 
       foreign key (id_tipo_sospensione) 
       references tipo_sospensione (id_tipo_sospensione);

    alter table bici 
       add constraint FK5djjw2oqic6iikwn8pe33kjlk 
       foreign key (id_veicoli) 
       references veicoli (id);

    alter table macchina 
       add constraint FK7sdoud3jv1x34hn746rt1endr 
       foreign key (id_veicoli) 
       references veicoli (id);

    alter table moto 
       add constraint FKjhhhqwlda8u46abhjqadgog3j 
       foreign key (id_veicoli) 
       references veicoli (id);

    alter table veicoli 
       add constraint FK9j55doxysd1qgb4lq59k56pvh 
       foreign key (categoria) 
       references categoria (id);

    alter table veicoli 
       add constraint FKntlyo8r2fdh3gpp6idm29ti76 
       foreign key (colore) 
       references colore (id_colore);

    alter table veicoli 
       add constraint FKcjih8mcyrd19rgpdkexw2n35w 
       foreign key (marca) 
       references marca (id_marca);

    alter table veicoli 
       add constraint FK7ru2wbiu11hjxh8qcmn6jw1bj 
       foreign key (tipo_alimentazione) 
       references tipo_alimentazione (id_tipo_alimentazione);

    alter table veicoli 
       add constraint FK2wwp4g7prdxuj0889m66ylht0 
       foreign key (tipo_veicolo) 
       references tipo_veicolo (id_tipo_veicolo);
