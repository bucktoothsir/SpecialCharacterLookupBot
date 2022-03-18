# Makefile
# bucktoothsir, 2022-03-17 16:41
#
# DOCKER TASKS
# Build the container
build:
	docker build -t special_char_bot:latest .

tag:
	docker image tag special_char_bot:latest ghcr.io/bucktoothsir/special_char_bot:latest

publish:
	docker image push ghcr.io/bucktoothsir/special_char_bot:latest
# push the container
push: tag publish
