import boto3

dynamodb = boto3.resource('dynamodb')
table = dynamodb.Table('dwh_metadata')

def lambda_handler(event, context):

    batch_id = event['batch_id']

    response = table.get_item(Key={'batch_id': batch_id})

    return response.get('Item', {})