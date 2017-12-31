#!/bin/sh

CURJAVA=$(pidof java)

kill -9 $CURJAVA
