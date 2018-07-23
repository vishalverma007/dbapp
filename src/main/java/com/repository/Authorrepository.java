package com.repository;
import com.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Authorrepository extends CrudRepository<Author, Long> {

}
