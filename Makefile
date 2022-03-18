# Makefile
# bucktoothsir, 2022-03-17 16:41
#
# DOCKER TASKS
# Build the container
docker-build:
	docker build -t special_char_bot:latest .

docker-tag:
	docker image tag special_char_bot:latest ghcr.io/bucktoothsir/special_char_bot:latest

docker-publish:
	docker image push ghcr.io/bucktoothsir/special_char_bot:latest
	
# push the container
docker-push: docker-tag docker-publish
