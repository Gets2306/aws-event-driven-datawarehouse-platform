import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('dwh_metadata')

def lambda_handler(event, context):

    failed_batches = table.scan(
        FilterExpression="status = :s",
        ExpressionAttributeValues={":s": "FAILED"}
    )

    return failed_batches.get('Items', [])