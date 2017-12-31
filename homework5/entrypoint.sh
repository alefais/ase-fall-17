#!/bin/bash

mypath="/usr/games"

if [ "$#" -eq 0 ]; then
	$mypath/fortune | $mypath/cowthink
else
	$mypath/cowthink "$@"
fi

