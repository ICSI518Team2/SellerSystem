package com.fusemachine.inventory.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fusemachine.inventory.domain.Item;
import com.fusemachine.inventory.domain.User;
//import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ItemRepository;
//import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ItemService;
import com.fusemachine.inventory.service.UserService;
@Controller
public class SellerLoginController {	
	@Autowired
	 private UserService userService;
	 
	 
	 
}
