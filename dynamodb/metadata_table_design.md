# DynamoDB Metadata Table Design

Table Name: dwh_metadata

Partition Key:
- batch_id (String)

Attributes:
- batch_id
- status (STARTED, SUCCESS, FAILED)
- source_system
- table_name
- retry_flag
- created_at
- updated_at