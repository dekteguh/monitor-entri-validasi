/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ekoteguh
 * Created: Oct 4, 2017
 */

CREATE DATABASE monitorentri_db;

USE monitorentri_db;

CREATE TABLE entrian(
    id varchar(255) not null,
    kabkota_id varchar(4) not null,
    no_batch int(3) not null,
    jml_dok_serah int(2) not null,
    waktu_serah date not null,
    is_serah int(1) not null,
    jml_dok_terima int(2),
    waktu_terima date,
    is_terima int(1),
    waktu_simpan date,
    operator_id varchar(255) not null,
    survei_sensus_id varchar(255) not null,
    PRIMARY KEY(id)
);

CREATE TABLE validasi(
    id varchar(255) not null,
    kabkota_id varchar(4) not null,
    no_batch int(3) not null,
    jml_dok_serah int(2) not null,
    waktu_serah date not null,
    is_serah int(1) not null,
    jml_dok_terima int(2),
    waktu_terima date,
    is_terima int(1),
    waktu_simpan date,
    operator_id varchar(255) not null,
    survei_sensus_id varchar(255) not null,
    PRIMARY KEY(id)
);