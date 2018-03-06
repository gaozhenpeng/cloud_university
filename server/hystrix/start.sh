docker stop hystrix
docker rm hystrix
docker run --name hystrix -d -p 7979:7979 hystrix
