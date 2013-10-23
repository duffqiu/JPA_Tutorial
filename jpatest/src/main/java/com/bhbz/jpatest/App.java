/**
 * 
 */
package com.bhbz.jpatest;

import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author macbook
 * 
 *         2013年10月21日
 */
public class App {

	/**
	 * @param args
	 *            macbook 2013年10月21日
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"bean.xml");

		/*
		 * CustomerRepository customerRepository = context
		 * .getBean(CustomerRepository.class);
		 * 
		 * customerRepository.save(new Customer("Duff-Romanty-Xiyue", 36,
		 * "Guangzhou linhai Street 15-2-402"));
		 * 
		 * Iterable<Customer> customers = customerRepository
		 * .findByUserNameLike("romanty"); for (Customer customer : customers) {
		 * System.out.println(customer); }
		 * 
		 * Customer customer = customerRepository.findBySpecificId(9);
		 * System.out.println(customer);
		 * 
		 * PollTopic pollTopic = new PollTopic("Poll topic3", new Date(
		 * System.currentTimeMillis()), 1, 1, 1);
		 * 
		 * PollOptions pollOptions1 = new PollOptions("Item 3", 0); PollOptions
		 * pollOptions2 = new PollOptions("Item 4", 0);
		 * 
		 * pollOptions1.setPollTopic(pollTopic);
		 * pollOptions2.setPollTopic(pollTopic);
		 * 
		 * Set<PollOptions> pollOptionSet = new HashSet<>();
		 * pollOptionSet.add(pollOptions1); pollOptionSet.add(pollOptions2);
		 * 
		 * pollTopic.setOptions(pollOptionSet);
		 

		PollTopicRepository pollTopicRepository = context
				.getBean(PollTopicRepository.class);
		// pollTopic = pollTopicRepository.save(pollTopic);

		Iterable<PollTopic> pollTopics = pollTopicRepository.findAll();

		for (PollTopic pTopic : pollTopics) {
			System.out.println(pTopic);
		}

		PollOptionsRepository pollOptionsRepository = context
				.getBean(PollOptionsRepository.class);
		PollOptions pollOptions = pollOptionsRepository.findOne(65);

		if (pollOptions != null) {
			PollTopic pollTopic = pollOptions.getPollTopic();
			Set<PollOptions> pollOptionSet = pollTopic.getOptions();

			Iterator<PollOptions> iterator = pollOptionSet.iterator();

			while (iterator.hasNext()) {
				PollOptions item = iterator.next();
				System.out.println(item);
			}
		}

		pollOptions.setOption_item("new item description");

		pollOptionsRepository.save(pollOptions);

		Iterable<PollTopic> topicIterator = pollTopicRepository
				.findAllByIdGeaterThanOrderByTitleLowerDesc(0);

		for (PollTopic pTopic : topicIterator) {
			System.out.println(pTopic);
		}
		*/

		CustomerRepository customerRepository = context
				.getBean(CustomerRepository.class);

		customerRepository.save(new Customer(1, "Duff-Romanty-Xiyue", 36,
				"Guangzhou linhai Street 15-2-402", 1));
		
		customerRepository.save(new Customer(1, "Duff", 36,
				"Guangzhou linhai Street 15-2-402", 2));

		Iterable<Customer> customers = customerRepository
				.findAllByIdAndType(1, 2);
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}
