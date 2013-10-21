/**
 * 
 */
package com.bhbz.jpatest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author macbook
 * 
 *         2013年10月21日
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Iterable<Customer> findAllByUserName(String userName);

    @Query("from CUSTOMER u where LOWER(u.userName) like CONCAT(CONCAT('%',LOWER(:un)), '%')")
    Iterable<Customer> findByUserNameLike(@Param("un") String userName);

    Iterable<Customer> findByIdGreaterThan(int id);

    // must use the Entity's name not table's name
    @Query("from CUSTOMER u where u.id = :id")
    Customer findBySpecificId(@Param("id") int id);
}
