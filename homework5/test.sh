#!/bin/bash

set -x
TAGID=$((docker build . | tee /dev/tty) | awk 'END {print $NF}')
docker tag $TAGID cowthinker
docker run cowthinker
docker run cowthinker Alessandra Fais - ASE 2017/18 - homework 5
