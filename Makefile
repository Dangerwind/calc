.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.13

build:
	./gradlew clean build

run:
	./gradlew run

test:
	./gradlew test


build-run: build run


.PHONY: build
