#!/bin/bash

# 1. env variable (환경변수)
source ./var.sh
echo "1. env variable setting complete"

# 2. clone delete
touch crontab_delete
crontab crontab_delete
rm crontab_delete
echo "2. cron delete complete"

# 3. server checking
if [ -n "${PROJECT_PID}" ]; then
	# 재배포
	kill -9 $PROJECT_PID
	sleep 5s
	echo "3. project kill complete"
else
	# 최초 배포

	# 3-1 apt update
	sudo apt-get -y update 1>/dev/null	
		# bash에서는 apt-get 이라고 입력해야 정상적으로 실행된다. (쉘 스크립트)
		# 또 -y를 해야 모든 질문에 y로 응답한다.
	echo "3-1. apt-get update complete"

	# 3-2 jdk install
	sudo apt-get -y install openjdk-11-jdk 1>/dev/null
	echo "3-2. jdk install complete"

	# 3-3 timezone set
	sudo timedatectl set-timezone Asia/Seoul
	echo "3-3. timezone setting complete"

fi

# 4. project folder delete
rm -rf ${HOME}/${PROJECT_NAME} 		# f를 붙여야 명령어를 실행할 때, 질문하지 않는다.
echo "4. project folder delete complete"

# 5. git clone
git clone https://github.com/${GITHUB_ID}/${PROJECT_NAME}.git
sleep 3s	# sleep으로 clone 시간을 기다려줘야 문제가 발생하지 않는다.
echo "5. git clone complete"

# 6. gradlew u+x
chmod u+x ${HOME}/${PROJECT_NAME}/shopping-mall/gradlew
echo "6. gradlew u+x complete"

# 7. project build
cd ${HOME}/${PROJECT_NAME}/shopping-mall
./gradlew build		# 프로젝트는 절대 경로에서 빌드할 수 없으니 해당 경로로 이동 후 빌드해야한다.
echo "7. project build complete"

# 8. start jar
nohup java -jar -Dspring.profiles.active=prod ${JAR_PATH} 1>${HOME}/log.out 2>${HOME}/err.out &
echo "8. start server complete"

# 9. cron registration
touch crontab_new
echo "* * * * * ${HOME}/check-and-restart.sh" 1>crontab_new
# register the others.. you use >> (append)
crontab crontab_new
rm crontab_new
echo "9. cron registration complete"