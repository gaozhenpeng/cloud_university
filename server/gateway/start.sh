docker stop gateway
docker rm gateway
docker run --name gateway -d -p 9000:9000 gateway
