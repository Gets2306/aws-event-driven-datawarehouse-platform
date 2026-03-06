import json
import boto3
from datetime import datetime

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('dwh_metadata')

def lambda_handler(event, context):

    batch_id = datetime.utcnow().strftime('%Y%m%d%H%M%S')

    response = table.put_item(
        Item={
            'batch_id': batch_id,
            'status': 'STARTED',
            'created_at': batch_id
        }
    )

    return {
        "batch_id": batch_id,
        "status": "STARTED"
    }