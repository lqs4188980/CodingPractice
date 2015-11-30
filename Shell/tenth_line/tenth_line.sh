#!/bin/bash

# extremely slow
#COUNTER=0
#cat file.txt | \
#while read line
#do
#	COUNTER=$((COUNTER+1))
#	if [ $COUNTER = 10 ]
#		then
#		echo "$line"
#	fi
#done

sed -n "10p" file.txt
#sed '10q;d' file.txt

#how to?
#head -n 10 file.txt | tail -n 1