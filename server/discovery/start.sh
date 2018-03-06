docker stop discovery
docker rm discovery
docker run --name discovery -d -p 8761:8761 discovery
