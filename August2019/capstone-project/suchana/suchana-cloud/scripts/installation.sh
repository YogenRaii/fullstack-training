#!/usr/bin/env bash

apt update
apt install openjdk-8-jdk -y

apt install mysql-server -y
mysql_secure_installation -y