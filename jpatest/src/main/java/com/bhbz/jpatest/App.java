/**
 * 
 */
package com.bhbz.jpatest;

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

	CustomerRepository customerRepository = context
		.getBean(CustomerRepository.class);

	customerRepository.save(new Customer("Duff-Romanty-Xiyue", 36,
		"Guangzhou linhai Street 15-2-402"));

	Iterable<Customer> customers = customerRepository
		.findByUserNameLike("romanty");
	for (Customer customer : customers) {
	    System.out.println(customer);
	}

	Customer customer = customerRepository.findBySpecificId(9);
	System.out.println(customer);
    }

}
