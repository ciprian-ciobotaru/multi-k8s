docker build -t ciprianciobotaru/multi-client:latest -t ciprianciobotaru/multi-client:$SHA -f ./client/Dockerfile ./client
docker build -t ciprianciobotaru/multi-server:latest -t ciprianciobotaru/multi-server:$SHA -f ./server/Dockerfile ./server
docker build -t ciprianciobotaru/multi-worker:latest -t ciprianciobotaru/multi-worker:$SHA -f ./worker/Dockerfile ./worker

docker push ciprianciobotaru/multi-client:latest
docker push ciprianciobotaru/multi-server:latest
docker push ciprianciobotaru/multi-worker:latest

docker push ciprianciobotaru/multi-client:$SHA
docker push ciprianciobotaru/multi-server:$SHA
docker push ciprianciobotaru/multi-worker:$SHA

kubectl apply -f k8s
kubectl set image deployments/server-deployment server=ciprianciobotaru/multi-server:$SHA
kubectl set image deployments/client-deployment client=ciprianciobotaru/multi-client:$SHA
kubectl set image deployments/worker-deployment worker=ciprianciobotaru/multi-worker:$SHA