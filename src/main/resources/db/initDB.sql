DROP TABLE IF EXISTS cities;

CREATE TABLE cities
(
    id          INTEGER PRIMARY KEY NOT NULL,
    name        VARCHAR NOT NULL,
    description VARCHAR NOT NULL
);
CREATE UNIQUE INDEX cities_unique_name_idx ON cities (name);
