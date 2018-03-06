docker stop config
docker rm config
docker run --name config -d -p 8888:8888 config
