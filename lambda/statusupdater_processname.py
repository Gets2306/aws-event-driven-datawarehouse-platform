import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('dwh_metadata')

def lambda_handler(event, context):

    batch_id = event['batch_id']
    status = event['status']

    table.update_item(
        Key={'batch_id': batch_id},
        UpdateExpression="SET #s = :val",
        ExpressionAttributeNames={"#s": "status"},
        ExpressionAttributeValues={":val": status}
    )

    return {"batch_id": batch_id, "updated_status": status}