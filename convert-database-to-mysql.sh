#!/bin/bash
# from: https://stackoverflow.com/a/32423570/4764279
# requires: sudo apt install mdbtools
# sample usage:
#   ./convert-sample-database-to-mysql.sh some.mdb > some.sql
#   ./convert-sample-database-to-mysql.sh some.mdb | mysql destination-db -u user -p

TABLES=$(mdb-tables -1 $1)

for t in $TABLES
do
  echo "DROP TABLE IF EXISTS \`$t\`;"
done

mdb-schema $1 mysql

for t in $TABLES
do
  mdb-export -D '%Y-%m-%d %H:%M:%S' -I mysql $1 $t
done