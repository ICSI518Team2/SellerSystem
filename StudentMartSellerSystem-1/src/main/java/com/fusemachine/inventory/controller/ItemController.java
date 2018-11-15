package com.fusemachine.inventory.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fusemachine.inventory.domain.Item;
import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ItemRepository;
import com.fusemachine.inventory.repository.ProductRepository;
@Controller
public class ItemController {
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://image//";

	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(value="/item")
    public String item(Model model) {
    	model.addAttribute("item", new Item());
        return "item";
    }
	
	@RequestMapping(value="/item",method = RequestMethod.POST)
    public String itemSubmit(@ModelAttribute Item item) {
		
		item.setImage_path(UPLOADED_FOLDER+item.getImage_path());
		item = this.itemRepository.save(item);
    	return "item";
    }
	
	
	@GetMapping("/uploadPicture")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
	
	
}
