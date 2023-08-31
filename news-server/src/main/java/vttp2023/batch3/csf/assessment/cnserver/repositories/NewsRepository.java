package vttp2023.batch3.csf.assessment.cnserver.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {

	public static final String A_OBJECTID = "_id";
	public static final String A_POSTDATE = "postDate";
	public static final String A_TITLE = "title";
	public static final String A_DESCRIPTION = "description";

	public static final String A_IMAGE = "image";
	public static final String A_TAGS = "tags";

	public static final String C_NEWS = "news";


	@Autowired
	private MongoTemplate template;

	// TODO: Task 1
	// Write the native Mongo query in the comment above the method
	public List<String> getAllIDTypes() {
		return template.findDistinct(new Query(), A_OBJECTID, C_NEWS, String.class);
	}


	public List<String> showTags() {
		return template.findDistinct(new Query(), A_TAGS, C_NEWS, String.class);
	}

	public List<String> getAllTags() {
		UnwindOperation unwindTags = Aggregation.unwind("tags");

		GroupOperation groupTags = Aggregation.group("tags");

		SortOperation sortTags = Aggregation.sort(Sort.by(Direction.ASC, "_id"));

		Aggregation pipeline = Aggregation.newAggregation(unwindTags, groupTags, sortTags);

		return template.aggregate(pipeline, "mons", Document.class)
		.getMappedResults().stream()
		.map(d -> d.getString("_id"))
		.toList();
	}

	// TODO: Task 2
	// Write the native Mongo query in the comment above the method

	// TODO: Task 3
	// Write the native Mongo query in the comment above the method

}
