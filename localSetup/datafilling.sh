#!/bin/bash

# MySQL Docker container settings
DOCKER_CONTAINER_NAME="my-mysql"
MYSQL_USER="root"
MYSQL_PASSWORD="admin"

# Create database
docker exec $DOCKER_CONTAINER_NAME mysql -u $MYSQL_USER -p$MYSQL_PASSWORD -e "CREATE DATABASE IF NOT EXISTS products;"

# Create table
docker exec $DOCKER_CONTAINER_NAME mysql -u $MYSQL_USER -p$MYSQL_PASSWORD -e "USE products; CREATE TABLE IF NOT EXISTS product (id BIGINT AUTO_INCREMENT PRIMARY KEY, service VARCHAR(255) NOT NULL, netprice INT NOT NULL, mrp INT NOT NULL, created DATETIME);"

# Insert 100 dummy rows
for i in {1..100}
do
    SERVICE="Service$i"
    NETPRICE=$((RANDOM % 100 + 1))
    MRP=$((NETPRICE + (RANDOM % 50)))
    docker exec $DOCKER_CONTAINER_NAME mysql -u $MYSQL_USER -p$MYSQL_PASSWORD -e "USE products; INSERT INTO product (service, netprice, mrp, created) VALUES ('$SERVICE', $NETPRICE, $MRP, NOW());"
done

echo "Database 'products' created with table 'product' and 100 dummy rows inserted."
