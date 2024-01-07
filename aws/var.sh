#!/bin/bash

#적용할 깃허브 아이디
GITHUB_ID="bakisung"
PROJECT_NAME="han-park-steak"
PROJECT_VERSION="0.0.1"
PROJECT_PID=$(pgrep -f "shopping-mall-0.0.1-SNAPSHOT.war") 
# 아래 코드로 하는게 정석이지만 나는 프로젝트 상위에 한박 스테이크 폴더가 있으므로 위와 같이 설정했다.
#PROJECT_PID="$(pgrep -f ${PROJECT_NAME}-${PROJECT_VERSION}.war)"
	# 위 프로젝트 PID에 ( ) 소괄호를 붙이지 않으면 문자 그대로를 반환한다.
	# 즉, 실행 결과를 넣을때 ( ) 소괄호를 사용한다.
JAR_PATH="${HOME}/${PROJECT_NAME}/shopping-mall/build/libs/shopping-mall-${PROJECT_VERSION}-SNAPSHOT.war"
	# HOME의 경로는 이미 /home/ubuntu로 잡혀 있으므로 별도로 ubuntu를 입력하면 안된다.

export GITHUB_ID
export PROJECT_NAME
export PROJECT_VERSION
export PROJECT_PID
export JAR_PATH