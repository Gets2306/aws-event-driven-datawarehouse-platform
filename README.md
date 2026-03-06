# AWS Event-Driven Data Warehouse Architecture

## Overview

Enterprise-grade event-driven Data Warehouse built on AWS.

### Key Highlights

- 8 Source Systems
- 5–10 tables per source
- Event-driven batch processing
- Metadata-driven orchestration
- Automatic failed batch reruns
- Cleanser → Conformed → DWH architecture
- Redshift Stored Procedure trigger post-load

---

## Architecture Flow

1. S3 Event triggers Step Function
2. Lambda identifies new batch & previous batch
3. Glue Cleanser Layer executes
4. Glue Conformed Layer executes
5. Data loaded to Redshift
6. Stored Procedures triggered

---

## AWS Services Used

- S3
- Lambda
- Step Functions
- DynamoDB
- Glue (Scala Spark)
- Redshift

---

## Design Patterns

- Idempotent processing
- Metadata-driven batch control
- Incremental loads
- Event-based orchestration
- Failure recovery logic
