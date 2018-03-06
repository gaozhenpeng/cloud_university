docker stop obs
docker rm obs
docker run --name obs -d -p 603:603 obs
