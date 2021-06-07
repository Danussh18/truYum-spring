package com.cognizant.truYumspring;

import com.cognizant.truYumspring.model.MenuItem;
import com.cognizant.truYumspring.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TruYumSpringApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumSpringApplication.class);

	@Autowired
	private MenuItemService menuItemService;

	public static void main(String[] args)  {
		SpringApplication.run(TruYumSpringApplication.class, args);
	}

	private void testGetMenuItemListAdmin() {
		LOGGER.info("Running testGetMenuItemListAdmin");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		LOGGER.info("Fetch all items list");
		for (MenuItem menuItem : menuItemList) {
			LOGGER.debug("   {}", menuItem);
		}
		LOGGER.info("All menu items fetched");
	}

	private void testGetMenuItemListCustomer() {
		LOGGER.info("Running testGetMenuItemListCustomer");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		LOGGER.info("Items list that are active.");
		for (MenuItem menuItem : menuItemList) {
			LOGGER.debug("   {}", menuItem);
		}
		LOGGER.info("List published");
	}

	private void testGetMenuById() {
		LOGGER.info("Menu item by ID");
		MenuItem menuItem = null;
		try {
			menuItem = menuItemService.getMenuItem(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.debug("Menu Item: {}", menuItem);
		LOGGER.info("Menu item published");
	}

	private void testModifyMenuActive() {
		LOGGER.info("Inactive -> Active");

		MenuItem menuItem = null;

		try {
			menuItem = menuItemService.getMenuItem(4);
			LOGGER.debug("Item before update : {}", menuItem);
			menuItem = menuItemService.modifyMenuItem(4, "YES");
			LOGGER.debug("Item after update : {}", menuItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("Status Changed");
	}

	@Override
	public void run(String... args) throws Exception {
//		testGetMenuItemListAdmin();
//		testGetMenuItemListCustomer();
		testGetMenuById();
//		testModifyMenuActive();
	}
}
