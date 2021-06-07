package com.cognizant.truYumspring.repository;

import com.cognizant.truYumspring.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {

    @Query(value = "SELECT * FROM menu_item mi WHERE me_date_of_launch <= NOW() AND me_active LIKE 'YES'",nativeQuery = true)
    List<MenuItem> getMenuItemListCustomer();
}
