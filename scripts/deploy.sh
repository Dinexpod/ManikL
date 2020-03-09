#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
  target/manikL-1.0-SNAPSHOT.jar \
  anatolii@192.168.1.103:/home/anatolii/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa anatolii@192.168.1.103 << EOF

pgrep -f manikL-1.0-SNAPSHOT.jar | xargs kill -9
nohup java -jar manikL-1.0-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'
