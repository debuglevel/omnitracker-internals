#!/bin/bash
echo "== Extracting database..."
./extract-sample-database.sh
mkdir -p mariadb
echo "== Converting Access database to MariaDB SQL script..."
./convert-database-to-mysql.sh OT-Templates.mdb > mariadb/OT-Templates.sql
echo "== Done. Have fun."