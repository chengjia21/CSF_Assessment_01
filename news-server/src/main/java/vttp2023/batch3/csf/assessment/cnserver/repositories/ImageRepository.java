package vttp2023.batch3.csf.assessment.cnserver.repositories;

import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Repository
public class ImageRepository {
	
	// TODO: Task 1

@Autowired
	private AmazonS3 s3;

	public String upload(String contentType, InputStream is) {
		
		String key = "image/%s".formatted();

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(contentType);

		PutObjectRequest putReq = new PutObjectRequest("newsPostImages", key, is, metadata);
		putReq = putReq.withCannedAcl(CannedAccessControlList.PublicRead);

		s3.putObject(putReq);

		return key;
	}

	public String getURL(String id) {
		String key = "image/%s".formatted(id);
		return s3.getUrl("newsPostImages", key).toExternalForm();
	}
}
