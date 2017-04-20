#!/bin/sh
echo "OK"
sudo service tomcat7 stop
rm -rf TestYamanashi
git clone http://github.com/freewill-gd/TestYamanashi
sudo service tomcat7 start

 

