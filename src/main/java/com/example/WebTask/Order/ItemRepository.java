package com.example.WebTask.Order;

import java.util.List;

//import java.util.List;
//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("SELECT s from Item s WHERE s.name in :names")
	List<Item> findByNames(@Param("names") List<String> names);
	
}
