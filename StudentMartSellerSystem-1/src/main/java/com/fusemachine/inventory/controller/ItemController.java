package com.fusemachine.inventory.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.fusemachine.inventory.service.ItemService;
import com.fusemachine.inventory.service.ProductService;
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
		
	int pageNumber=1;
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://image//";
    private static String IMAGE_RELATIVEPATH = "/image/";
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping(value="/home")
    public String homepage(){
        return "home";
    }
	
	@RequestMapping(value="/displayitem",method = RequestMethod.GET)
	public String getItems(@RequestParam (required = false, value = "page", defaultValue = "1") Integer page,
			@RequestParam (required = false, value = "size",defaultValue = "5") Integer size, Model model){				
		Page<Item> itemList = this.itemService.findAllItems(page-1, size);
		model.addAttribute("item",itemList.getContent());
		model.addAttribute("totalPage", itemList.getTotalPages());
		model.addAttribute("currentPage", itemList.getNumber());

		model.addAttribute("url", "/displayitem");
		return "itemdisplay";
	}
	
	@RequestMapping(value="/item")
    public String item(Model model) {
    	model.addAttribute("item", new Item());
        return "item";
    }
	
	@RequestMapping(value = "/displayitem/search", method = RequestMethod.GET)
	public String getSearchData(@RequestParam (required = false, value = "page", defaultValue = "1") Integer page,@RequestParam (required = false, value = "size",defaultValue = "5") Integer size,@RequestParam(required = false, value = "key", defaultValue =  "") String search, Model model){
	 Page<Item> productinfo = this.itemService.getSearchItems(search.trim(), page-1, size);
	 model.addAttribute("item", productinfo.getContent());
	 model.addAttribute("totalPage", productinfo.getTotalPages());
	 model.addAttribute("url", "/displayitem/search");
	 return "itemdisplay";
	}
	
	@RequestMapping(value="/item",method = RequestMethod.POST)
    public String itemSubmit(@ModelAttribute Item item) {
		
		item.setImage_path(IMAGE_RELATIVEPATH+item.getImage_path());
		item = this.itemRepository.save(item);
    	return "itemdisplay";
    }
	
	//trim the image path from database, only leave the image name without static directory
	public String trimItemImagePath(String imagePath)
	{
		String trimPath = imagePath.substring(imagePath.lastIndexOf("/")+1);
		
		return trimPath;
	}
	@RequestMapping("/updateitem/{id}")
    public String view(@PathVariable("id") String id, Model model) {
    	Item item = itemService.findById(Integer.parseInt(id));
    	//only leave the image name without static directory
    	//item.setImage_path(trimItemImagePath(item.getImage_path()));
        model.addAttribute("item", item);
        return "updateitem";
    }

    
    @RequestMapping(value="/updateitem",method = RequestMethod.POST)
    public String productUpdate(@ModelAttribute Item item) {
    	item.setImage_path(IMAGE_RELATIVEPATH+item.getImage_path());
    	item = this.itemRepository.save(item);
    	return "itemdisplay";
    }
    
    @RequestMapping(value="/deleteitem/{id}",method = RequestMethod.DELETE)
    public String productDelete(@PathVariable Integer id) {
    	itemService.deleteById(id);
    	
    	return "itemdisplay";
    }
	
	
	
	//Deal with the uploading picture functionality
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
        //return "item";
    }

    
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
	
	
}
