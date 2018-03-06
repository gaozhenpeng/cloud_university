docker stop zipkin
docker rm zipkin
docker run --name zipkin -d -p 9411:9411 zipkin
