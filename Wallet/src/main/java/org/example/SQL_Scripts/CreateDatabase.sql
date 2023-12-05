CREATE ROLE if not exists prog_admin WITH LOGIN PASSWORD '123456' SUPERUSER CREATEDB;
ALTER ROLE prog_admin CREATEDB;
CREATE DATABASE if not exists wallet;
psql -h localhost -U prog_admin -d wallet


