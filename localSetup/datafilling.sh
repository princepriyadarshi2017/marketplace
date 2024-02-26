#!/bin/bash

# MySQL Docker container settings
DOCKER_CONTAINER_NAME="my-mysql"
MYSQL_USER="root"
MYSQL_PASSWORD="admin"

# Create database and table
docker exec $DOCKER_CONTAINER_NAME mysql -u $MYSQL_USER -p$MYSQL_PASSWORD << EOF
CREATE DATABASE IF NOT EXISTS products;
USE products;
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service VARCHAR(255) NOT NULL,
    netprice INT NOT NULL,
    mrp INT NOT NULL,
    created DATETIME
);
EOF

# Insert 100 dummy rows
for i in {1..100}
do
    SERVICE="Service$i"
    NETPRICE=$((RANDOM % 100 + 1))
    MRP=$((NETPRICE + (RANDOM % 50)))
    docker exec $DOCKER_CONTAINER_NAME mysql -u $MYSQL_USER -p$MYSQL_PASSWORD -D products -e "INSERT INTO product (service, netprice, mrp, created) VALUES ('$SERVICE', $NETPRICE, $MRP, NOW());"
done

echo "Database 'product' created with table 'product' and 100 dummy rows inserted."
