/**
 * 
 */
package com.bhbz.jpatest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author egecqiu
 * 
 */
public interface PollTopicRepository extends CrudRepository<PollTopic, Integer> {

    //there is a rule to define the name to inject the logic
    Iterable<PollTopic> findAllByIdGreaterThanOrderByTitleAsc(Integer i);

    @Query("from PollTopic t where t.id > :id order by LOWER(t.title) desc")
    Iterable<PollTopic> findAllByIdGeaterThanOrderByTitleLowerDesc(
	    @Param("id") Integer i);

}
