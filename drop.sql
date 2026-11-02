
    alter table bici 
       drop 
       foreign key FKblrxi1rdhposhi3egaxa5w58j;

    alter table bici 
       drop 
       foreign key FK5djjw2oqic6iikwn8pe33kjlk;

    alter table macchina 
       drop 
       foreign key FK7sdoud3jv1x34hn746rt1endr;

    alter table moto 
       drop 
       foreign key FKjhhhqwlda8u46abhjqadgog3j;

    alter table veicoli 
       drop 
       foreign key FK9j55doxysd1qgb4lq59k56pvh;

    alter table veicoli 
       drop 
       foreign key FKntlyo8r2fdh3gpp6idm29ti76;

    alter table veicoli 
       drop 
       foreign key FKcjih8mcyrd19rgpdkexw2n35w;

    alter table veicoli 
       drop 
       foreign key FK7ru2wbiu11hjxh8qcmn6jw1bj;

    alter table veicoli 
       drop 
       foreign key FK2wwp4g7prdxuj0889m66ylht0;

    drop table if exists bici;

    drop table if exists categoria;

    drop table if exists colore;

    drop table if exists macchina;

    drop table if exists marca;

    drop table if exists moto;

    drop table if exists notifica_systema;

    drop table if exists tipo_alimentazione;

    drop table if exists tipo_sospensione;

    drop table if exists tipo_veicolo;

    drop table if exists veicoli;
