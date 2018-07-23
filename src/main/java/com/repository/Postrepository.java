/**
 * 
 */
package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.domain.*;

/**
 * @author vishal
 *
 */
@Repository
public interface Postrepository extends CrudRepository<Post, Long> {

}
