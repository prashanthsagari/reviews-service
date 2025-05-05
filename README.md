# Reviews Service

This project involves deploying the `reviews-service` with a MySQL database on Minikube.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Minikube**: For local Kubernetes clusters.
- **Docker**: To build and manage container images.
- **Maven**: To build the Java project.
- **kubectl**: To interact with the Kubernetes cluster.
- **MySQL Docker Image**: Used to create the MySQL database.

## Setup Instructions

### 1. Start Minikube

Run the following command to start Minikube with Docker as the driver: <br />

Run below commands using Powershell if  you are using Windows OS <br />
# start minikube in docker
Otherwise the image will be in your local PC, not inside Minikube’s Docker engine.  <br />
 minikube start --driver=docker
### 2. Connect to Minikube's Docker Engine
In PowerShell, run the following to switch to Minikube's Docker environment:

& minikube docker-env | Invoke-Expression


docker pull mysql:8.0

# (Name: minikube)
docker info  

# run below command 
mvn clean install  

# Build image 
docker build -t reviews-service:latest .  <br />
docker tag reviews-service:latest sagariprashanth/reviews-service:latest <br />
docker push sagariprashanth/reviews-service:latest <br />


# verify image is creation
docker images <br />


-- kubectl scale deployment mysql --replicas=0  <br />
kubectl apply -f k8s/mysql-pv.yaml <br />
kubectl apply -f k8s/mysql-pvc.yaml <br />
kubectl apply -f k8s/mysql-deployment.yaml <br />
kubectl apply -f k8s/mysql-service.yaml <br />
kubectl apply -f k8s/reviews-deployment.yaml <br />
kubectl apply -f k8s/reviews-service.yaml <br />


kubectl port-forward svc/reviews-service 9001:9001 <br />
kubectl port-forward svc/mysql 3307:3306 <br />

# stop mysql 
kubectl scale deployment mysql --replicas=0 <br />

# start mysql 
kubectl scale deployment mysql --replicas=1 <br />

# Delete old deployments 
kubectl delete deployment reviews-service <br />
kubectl delete service reviews-service <br />

kubectl delete -f k8s/mysql-pv.yaml <br />
kubectl delete -f k8s/mysql-pvc.yaml <br />

kubectl delete -f k8s/mysql-deployment.yaml <br />
kubectl delete -f k8s/mysql-service.yaml <br />

# Stop minikube
minikube stop <br />
