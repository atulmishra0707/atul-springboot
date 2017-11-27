package com.boot.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.java.dto.Topic;
import com.boot.java.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopic(){
		
		return topicService.getAllTopic();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id){
		
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String postTopics(@RequestBody Topic topic){
		topicService.addTopic(topic);
		return "Topic Added sucessfully";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public List<Topic> putTopic(@RequestBody Topic topic, @PathVariable String id){
		return topicService.putTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public Topic deleteTopic(@PathVariable String id){
		return topicService.deleteTopic(id);
	}
}
