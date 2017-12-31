#!/bin/sh

#http GET request to the application before the deployment [FAILED]
(set -x; curl -i -X GET http://localhost:8080/doodles)
printf "\n"

#application deployment
(set -x; toskerise doodle.yaml --policy size)
printf "\n"
(set -x; tosker doodle.completed.yaml create start)
printf "\n"
(set -x; tosker ls)
printf "\nWaiting for complete activation...\n\n"
sleep 10

#http requests to the application after the deployment [SUCCESSFUL]
(set -x; curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/doodles/ -d '{"title": "friday", "options": ["dinner", "lunch"]}')
printf "\n\n"
sleep 3
(set -x; curl -i -X GET http://localhost:8080/doodles)
printf "\n\n"
sleep 2

#application undeployment
(set -x; tosker doodle.completed.yaml stop delete)
printf "\n"
(set -x; tosker ls)
