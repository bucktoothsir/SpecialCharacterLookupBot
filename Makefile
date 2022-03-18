# Makefile
# bucktoothsir, 2022-03-17 16:41
#
# DOCKER TASKS
# Build the container
build:
	docker build -t speical_char_bot .

tag:
	docker image tag speical_char_bot:latest ghcr.io/bucktoothsir/speical_char_bot:latest

publish:
	docker image push ghcr.io/bucktoothsir/speical_char_bot:latest
# push the container
push: tag publish

run: 
	docker run -it --rm --pull always ghcr.io/bucktoothsir/speical_char_bot:latest bash
