#!/bin/bash
# from: https://stackoverflow.com/a/32423570/4764279
# requires: sudo apt install mdbtools
# sample usage:
#   ./convert-sample-database-to-mysql.sh some.mdb > some.sql
#   ./convert-sample-database-to-mysql.sh some.mdb | mysql destination-db -u user -p

# warnings:
#  MariaDB seems to be unable to hold tables with many colums; therefore this does not seem to work.
#  for PostgreSQL, converting seems to has some issue regarding (at least) with boolean.
#
# a current version of mdbtools is included in debian:bullseye
#  docker run -ti -v ${PWD}:/MOUNTPOINT debian:bullseye
#  apt update && apt install p7zip-full mdbtools

MDB=$1
TABLES=$(mdb-tables -1 $MDB | sort)
BACKEND=$2

echoerr() { echo "$@" 1>&2; }

echo "-- == DROP"
for t in $TABLES
do
  if [ "$BACKEND" == "mysql" ]; then
    echo "DROP TABLE IF EXISTS \`$t\`;"
  elif [ "$BACKEND" == "postgres" ]; then
    echo "DROP TABLE IF EXISTS \"$t\";"
  fi
done

echo "-- == SCHEMA"
mdb-schema $MDB $BACKEND | grep -v "MSys"

echo "-- == EXPORT"
for t in $TABLES; do
  if [[ ! "$t" =~ ^MSys ]]; then
    echo "-- == EXPORT $t"
    echoerr "Writing SQL for $t ..."

    if [ "$BACKEND" == "mysql" ]; then
      mdb-export -D '%Y-%m-%d %H:%M:%S' -I $BACKEND $MDB $t
    elif [ "$BACKEND" == "postgres" ]; then
      mdb-export -B -D '%Y-%m-%d %H:%M:%S' -I $BACKEND -q "'" -X "'" $MDB $t
    fi
  else
    echoerr "NOT Writing SQL for $t ..."
  fi
done