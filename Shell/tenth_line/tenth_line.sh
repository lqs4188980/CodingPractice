#!/bin/bash
COUNTER=0
cat file.txt | \
while read -r line || [[ -n "$line" ]]
do
	let COUNTER++
	if [ $COUNTER = 10 ]
		then
		echo "text read from file: $line"
	fi
done