# Load Balancer Demo - Multi-Stack

A load balancer demonstration with three separate backend servers built with different tech stacks:
- **Node.js Server** (JavaScript/Express)
- **Python Server** (Flask)
- **Spring Boot Server** (Java)

All three servers are load balanced using NGINX and orchestrated with Docker Compose.

## Quick Start

### Prerequisites
- Docker
- Docker Compose

### Run the Project

```bash
docker-compose up --build
```

### Access the Application

Open your browser and navigate to:
```
http://localhost:7070
```

Refresh the page multiple times to see requests being routed to different backend servers.

## Architecture

```
┌─────────────────────┐
│   NGINX LoadBalancer│
│    (Port 7070)      │
└──────────┬──────────┘
           │
     ┌─────┼─────┐
     │     │     │
  ┌──▼──┐ ┌──▼──┐ ┌──▼──┐
  │Node │ │Python│ │Spring│
  │ JS  │ │Flask │ │ Boot │
  │7071 │ │7072  │ │7073  │
  └─────┘ └─────┘ └──────┘
```

## Services

### Node.js Server
- **Port**: 7071 (internal), 7070 (load balancer)
- **Framework**: Express.js
- **Endpoint**: GET `/` - Returns Hello from Node Server

### Python Server
- **Port**: 7072 (internal), 7070 (load balancer)
- **Framework**: Flask
- **Endpoint**: GET `/` - Returns Hello from Python Server

### Spring Boot Server
- **Port**: 7073 (internal), 7070 (load balancer)
- **Framework**: Spring Boot
- **Endpoint**: GET `/` - Returns Hello from Spring Boot Server

## Docker Compose

The `docker-compose.yaml` file defines:
- **backend1**: Node.js server
- **backend2**: Python server
- **backend3**: Spring Boot server
- **loadbalancer**: NGINX reverse proxy

All services are configured to restart automatically.

## Load Balancer Configuration

The NGINX configuration (`nginx.conf`) uses round-robin load balancing to distribute requests across all three backend servers.

## Stopping the Services

```bash
docker-compose down
```

## Logs

View logs for all services:
```bash
docker-compose logs -f
```

View logs for a specific service:
```bash
docker-compose logs -f backend1  # Node
docker-compose logs -f backend2  # Python
docker-compose logs -f backend3  # Spring Boot
```
