#!/bin/bash
# build image, upload image, update service image

#docker build -t geekstylecn/survey:1.0.0 .
#docker push geekstylecn/survey:1.0.0
#docker service update survey --image geekstylecn/survey:1.0.0
#echo "---done---"


process_id_array=`ps -ef | grep survey | grep java | awk ' { print $2 } '`
echo $process_id_array
echo "---------------"
for process_id in $process_id_array
do
  kill -9 $process_id
  echo "killed $process_id"
done
echo "---survey process killed---"

mv ./build/libs/*.jar /server/survey/survey.jar
nohup java -jar /server/survey/survey.jar > /server/survey/survey.log &
echo "---survey process started---"
echo "---done---"