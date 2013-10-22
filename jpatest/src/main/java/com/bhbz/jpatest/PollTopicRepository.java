/**
 * 
 */
package com.bhbz.jpatest;

import org.springframework.data.repository.CrudRepository;

/**
 * @author egecqiu
 * 
 */
public interface PollTopicRepository extends CrudRepository<PollTopic, Integer> {

    //there is a rule to define the name to inject the logic
    Iterable<PollTopic> findAllByIdGreaterThan(Integer i);
}
