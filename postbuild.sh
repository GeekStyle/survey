#!/bin/bash
# build image, upload image, update service image

docker build -t geekstylecn/survey:1.0.0 .
docker push geekstylecn/survey:1.0.0
docker service update survey --image geekstylecn/survey:1.0.0
echo "---done---"