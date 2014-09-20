package com.s3.cloudIgrate;

import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3 {

	public static void main(String[] args) {
		
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("default").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\SMURKE\\.aws\\credentials), and is in valid format.",
                    e);
        }

        AmazonS3 s3 = new AmazonS3Client(credentials);
        Region usWest2 = Region.getRegion(Regions.US_WEST_1);
        s3.setRegion(usWest2);
        String bucketName = "my-first-s3-bucket-" + UUID.randomUUID();
       

        
        System.out.println("Creating bucket " + bucketName + "\n");
        
        /*
         * Api for creating bucket
         */
        s3.createBucket(bucketName);
        
        /*
         * uploading an object
         */
        
       // System.out.println("Uploading a new object to S3 from a file\n");
      //  s3.putObject(new PutObjectRequest(bucketName, key, C:\Users\Public\Pictures\Sample Pictures\Tulips.jpg));


        /*
         * Deleting the bucket
         */
        
      //  s3.deleteBucket(bucketName);
        
	}
	
	
	
}
