# Progressive Delivery with Automation & Observability

## Project Overview
This project is submitted as part of a Hackathon and demonstrates **progressive delivery** for Kubernetes-based applications, powered by automation and observability. The goal is to deploy software updates incrementally, validate their performance and functionality before fully rolling them out, and reduce risks during the deployment process.

## Key Components
- **Helm**: Kubernetes package manager used to automate the deployment of applications.
- **Argo Rollouts**: Manages progressive delivery strategies such as canary deployments, enabling risk-controlled rollouts.
- **k6**: A performance testing tool used for functional and performance validation of deployments.
- **Prometheus & Grafana**: Tools for real-time monitoring and visualization of system performance metrics.
- **Loki**: Log aggregation system, with Promtail for scraping, and integrated alerting for issue detection.

## Workflow
1. **Deployment Setup**:
   - Use `Helm` to manage deployments, but replace traditional Kubernetes deployments with `Argo Rollouts` for controlled rollouts.
   - Start the deployment process by launching a set of **canary pods** with the new version (v2) that initially do not serve live traffic.

2. **Functional Testing**:
   - Run **automated functional tests** on the canary pods using **k6** to ensure the new version is working as expected.
   - Results are captured using **Argo Rollouts' Analysis Template** for data-driven decision-making.

3. **Performance Testing**:
   - If functional tests pass, proceed with **performance testing** using **k6** to ensure the new version can handle expected loads.
   
4. **Progressive Traffic Shifting**:
   - Shift traffic incrementally to the canary pods, starting with 10% and increasing to 30%, 50%, and eventually 100%, while monitoring key metrics like latency, error rates, and resource usage with **Prometheus**.
   - Metrics are visualized in real-time using **Grafana Dashboards**.

5. **Rollback Mechanism**:
   - If any anomalies are detected during traffic shifting, **Argo Rollouts** will automatically trigger a **rollback** to the previous version to minimize user impact.

6. **Observability**:
   - Real-time observability is ensured through **Prometheus** and **Grafana** for metrics, while **Loki** handles log aggregation and alerting.
   - Alerts are configured to notify the team via **Slack** for fast response to any issues.

## Cost Optimizations
- Moved to **NGINX Ingress**, reducing the need for multiple load balancers and public IP addresses across environments. And is opensource.
- Migrated log storage to **Grafana Loki**, cutting log storage costs.

## Benefits
- **Risk Mitigation**: Canary deployments ensure only a small percentage of users are exposed to potential issues at any given time.
- **Automation**: Fully automated testing, monitoring, and rollback reduce the need for manual intervention during deployments.
- **Cost Savings**: Optimized load balancer usage and log storage, resulting in considerable annual savings.

## Technologies Used
- **Helm**, **Argo Rollouts**, **k6**
- **Prometheus**, **Grafana**, **Loki**, **NGINX Ingress**
- **Google Cloud Platform (GCP)**