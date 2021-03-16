#!/bin/bash
echo "== Extracting database..."
./extract-sample-database.sh

echo "== Converting Access database to PostgreSQL SQL script..."
mkdir -p postgres
./convert-database.sh OT-Templates.mdb postgres > postgres/OT-Templates.sql

#echo "== Converting Access database to MariaDB SQL script..."
#mkdir -p mariadb
#./convert-database.sh OT-Templates.mdb mysql > mariadb/OT-Templates.sql

echo "== Done. Have fun."