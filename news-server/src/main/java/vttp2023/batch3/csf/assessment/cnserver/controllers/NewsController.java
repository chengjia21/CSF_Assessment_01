package vttp2023.batch3.csf.assessment.cnserver.controllers;

import java.io.StringReader;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
public class NewsController {

	// TODO: Task 1

	@RestController
	@RequestMapping(path = "/view0/post")
	@CrossOrigin
	public class View2PostController {

		@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> postNews(@RequestBody String payload) {
			JsonReader reader = Json.createReader(new StringReader(payload));
			JsonObject newsJsonObject = reader.readObject();

			return ResponseEntity.ok(
					Json.createObjectBuilder()
							.add("NewsPostID", "News Post Successful".formatted(newsJsonObject.getString("title")))
							.build().toString());
		}

	@PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<String> postUpload(@RequestPartMultipart image, @RequestPartString imageName, 
@RequestPartString title) {
Map<String, String> imageData= new HashMap<>();
imageData.put("imageName", imageName);
imageData.put("title", title);

ObjectMetadata metadata= new ObjectMetadata();
metadata.setContentType(image.getContentType());
metadata.setContentLength(image.getSize());
metadata.setUserMetadata(imageData);

}
	// TODO: Task 2

	// TODO: Task 3

}
}