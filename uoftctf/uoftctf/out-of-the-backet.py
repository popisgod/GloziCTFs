from google.cloud import storage
import os

def download_all_blobs(bucket_name, destination_folder):
    """Downloads all the blobs in the bucket to the destination folder."""

    # Ensure the destination folder exists
    if not os.path.exists(destination_folder):
        os.makedirs(destination_folder)

    # Initialize a client using the service account JSON file
    storage_client = storage.Client.from_service_account_json('./funny.json')
    bucket = storage_client.bucket(bucket_name)

    # List all objects in the bucket and download them
    blobs = bucket.list_blobs()
    for blob in blobs:
        # Define the destination file path
        destination_file_name = os.path.join(destination_folder, blob.name)
        # Create necessary sub-folders if any
        os.makedirs(os.path.dirname(destination_file_name), exist_ok=True)
        # Download the blob to the destination file
        blob.download_to_filename(destination_file_name)
        print(f"Downloaded {blob.name} to {destination_file_name}.")

if __name__ == "__main__":
    # Replace with your bucket name and destination folder path
    my_bucket_name = 'flag-images'
    my_destination_folder = 'download'
    download_all_blobs(my_bucket_name, my_destination_folder)