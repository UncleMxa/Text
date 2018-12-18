package cn.mxa.ssm.controller;

import cn.mxa.ssm.po.ItemsCustom;
import cn.mxa.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    /**
     * 根据ID查询商品
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryitems")
    public ModelAndView queryItems() throws Exception {
        List<ItemsCustom> itemsCustoms = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustoms",itemsCustoms);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    @RequestMapping(value = "/editItems",method = {RequestMethod.GET,RequestMethod.POST})
    public String editItems(Model model, @RequestParam(value = "id",required = true) Integer item_id)throws Exception{
        ItemsCustom itemsCustom = itemsService.findAllByid(item_id);
        model.addAttribute("itemsCustom",itemsCustom);
        return "editItems";
    }

    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom, MultipartFile multipartFile) throws Exception {

        String originalFilename = multipartFile.getOriginalFilename();

        if (originalFilename != null && originalFilename.length()>0){
            String pipPath="E:\\JavaSelfstudyFile\\temp\\";

            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            File newFile = new File(pipPath+newFileName);

            multipartFile.transferTo(newFile);

            itemsCustom.setPic(newFileName);

        }
        itemsService.updateItems(id,itemsCustom);
        return "success";
    }

}
