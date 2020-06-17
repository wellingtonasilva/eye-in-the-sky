CREATE DATABASE db_eyeinthesky;
GRANT ALL PRIVILEGES ON DATABASE db_eyeinthesky TO postgres;

\connect db_eyeinthesky

create table airport_code (
	airp_id bigserial not null primary key,
	airp_iata_code varchar(3),
	airp_icao_code varchar(4),
	airp_faa_code varchar(4),
	airp_location varchar(255),
	airp_airport varchar(255),
	airp_country varchar(100) 
);

create table airlines (
	airl_id varchar(20) not null primary key,
	airl_lcc integer,
	airl_name varchar(255),
	airl_type varchar(30)
);

create table search_param (
	sear_id bigserial not null primary key,
	sear_code varchar(255),
	sear_currency varchar(4),
	sear_currency_rate float,
	sear_destination varchar(255),
	sear_date_from varchar(20),
	sear_date_to varchar(20)
);

create table flight (
	flig_id bigserial not null primary key,
	sear_id integer not null,
    flig_code varchar(255),
    flig_dtime timestamp,
    flig_dtime_utc timestamp,
    flig_atime timestamp,
    flig_atime_utc timestamp,
    flig_duration_departure integer,
    flig_duration_return integer,
    flig_duration_total integer,
    flig_fly_duration varchar(255),
    flig_fly_from varchar(255),
    flig_city_from varchar(255),
    flig_city_code_from varchar(255),
    flig_country_from_code varchar(100),
    flig_country_from_name varchar(60),    
    flig_map_id_from varchar(100),
    flig_fly_to varchar(100),
    flig_city_to varchar(100),
    flig_city_code_to varchar(100),
    flig_country_to_code varchar(100),
    flig_country_to_name varchar(100), 
    flig_map_id_to varchar(100),
    flig_distance float,
    flig_price float
);

ALTER TABLE flight
ADD CONSTRAINT xfk1_flight
FOREIGN KEY (sear_id) REFERENCES search_param;

create table flight_airlines(
	flil_id bigserial not null primary key,
	flig_id integer,
	airl_id varchar(20)
);

ALTER TABLE flight_airlines
ADD CONSTRAINT xfk1_flight_airlines
FOREIGN KEY (flig_id) REFERENCES flight;

ALTER TABLE flight_airlines
ADD CONSTRAINT xfk2_flight_airlines
FOREIGN KEY (airl_id) REFERENCES airlines;


create table flight_bags_price (
	flbp_id bigserial not null primary key,
	flig_id integer,
	flbp_hand smallint,
	flbp_price float
);

ALTER TABLE flight_bags_price
ADD CONSTRAINT xfk1_flight_bags_price
FOREIGN KEY (flig_id) REFERENCES flight;

create table flight_conversion (
	flcv_id bigserial not null primary key,
	flig_id integer,
	flcv_currency varchar(4),
	flcv_price float
);

ALTER TABLE flight_conversion
ADD CONSTRAINT xfk1_flight_conversion
FOREIGN KEY (flig_id) REFERENCES flight;


insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('FAO',
'LPFR',
null,
'Faro',
'Faro',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('FNC',
'LPMA',
null,
'Funchal',
'Funchal Madeira',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('HOR',
'LPHR',
null,
'Horta',
'Horta',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('LIS',
'LPPT',
null,
'Lisbon',
'Lisbon',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('PDL',
'LPPD',
null,
'Ponta Delgada',
'Ponta Delgada (Azores)',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('OPO',
'LPPR',
null,
'Porto',
'Porto',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('PXO',
'LPPS',
null,
'Porto Santo',
'Porto Santo',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('SMA',
'LPAZ',
null,
'Santa Maria',
'Santa Maria',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('TER',
'LPLA',
null,
'Lajes',
'Terceira',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('BGC',
'LPBG',
null,
'Bragança',
'Braganca',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('SIE',
'LPSI',
null,
'Sines',
'Sines',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('BGZ',
'LPBR',
null,
'Braga',
'Braga',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('CBP',
'LPCO',
null,
'Coimbra',
'Coimbra',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('CHV',
'LPCH',
null,
'Chaves',
'Chaves',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('COV',
'LPCV',
null,
'Covilha',
'Covilha',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('CVU',
'LPCR',
null,
'Corvo',
'Corvo Island',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('FLW',
'LPFL',
null,
'Santa Cruz das Flores',
'Flores Island',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('GRW',
'LPGR',
null,
'Santa Cruz da Graciosa',
'Graciosa Island',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('PIX',
'LPPI',
null,
'Laje',
'Pico Island',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('PRM',
'LPPM',
null,
'Portimão',
'Portimao Penina',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('SJZ',
'LPSJ',
null,
'Velas',
'Sao Jorge Island',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('VRL',
'LPVR',
null,
'Vila Real',
'Vila Real',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('VSE',
'LPVZ',
null,
'Viseu',
'Viseu G. Lobato',
'Portugal');

insert
	into
	airport_code (airp_iata_code,
	airp_icao_code,
	airp_faa_code,
	airp_location,
	airp_airport,
	airp_country)
values ('CAT',
'LPCS',
null,
'Cascais',
'Cascais',
'Portugal');

