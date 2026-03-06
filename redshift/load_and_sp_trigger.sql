BEGIN;

COPY public.fact_table
FROM 's3://conformed-layer/output/'
IAM_ROLE 'arn:aws:iam::account:role/redshift-role'
FORMAT AS PARQUET;

CALL sp_refresh_aggregations();

END;