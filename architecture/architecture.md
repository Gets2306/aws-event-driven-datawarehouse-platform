# Architecture Explanation

This system processes 8 source systems using event-driven orchestration.

Workflow:

S3 Event → Step Function → Lambda Batch Control →
Glue Cleanser → Glue Conformed → Glue DWH Load →
Redshift Stored Procedures

Design ensures:

- Idempotent batch control
- Metadata-driven execution
- Failure rerun support
- Incremental loading
- Enterprise scalability