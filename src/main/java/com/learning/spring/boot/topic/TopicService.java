package com.learning.spring.boot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(
				Arrays.asList(
						new Topic(101, "Collection", "Collection Desc"),
						new Topic(102, "Swing", "Swing Desc"), 
						new Topic(103, "Threading", "Threading Desc"),
						new Topic(104, "Exception Handling", "EH Desc"), 
						new Topic(105, "Oops", "Oops Desc"),
						new Topic(106, "Reflection", "Reflection Desc")
					)
				);

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(int id) {
		Stream<Topic> stream = topics.stream();
		Topic topic = stream.filter(t -> t.getId() == id).findFirst().get();
		return topic;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic) {
		Stream<Topic> stream = topics.stream();
		Topic prevTopic = stream.filter(t -> t.getId() == topic.getId()).findFirst().get();
		prevTopic.setName(topic.getName());
		prevTopic.setDescription(topic.getDescription());
	}

	public void deleteTopic(int id) {
		for(int i=0 ; i<topics.size() ; i++) {
			Topic topic = topics.get(i);
			if(id == topic.getId()) {
				topics.remove(i);
				break;
			}
		}
	}
}
