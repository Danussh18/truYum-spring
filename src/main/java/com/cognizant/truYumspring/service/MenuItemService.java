package com.cognizant.truYumspring.service;

import com.cognizant.truYumspring.model.MenuItem;
import com.cognizant.truYumspring.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItemListAdmin() {
        return menuItemRepository.findAll();
    }

    public List<MenuItem> getMenuItemListCustomer() {
        return menuItemRepository.getMenuItemListCustomer();
    }

    public MenuItem getMenuItem(int id) throws Exception {
        Optional<MenuItem> result = menuItemRepository.findById(id);
        if (!result.isPresent()) {
            throw new Exception("Menu Item not found");
        }
        return result.get();
    }

    public MenuItem modifyMenuItem(int id, String isActive) throws Exception {
        MenuItem menuItem = getMenuItem(id);
        menuItem.setActive(isActive);
        menuItemRepository.save(menuItem);
        return menuItem;
    }
}
