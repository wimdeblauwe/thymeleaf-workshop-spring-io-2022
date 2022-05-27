package net.springio.workshops.thymeleafworkshop.bike.web;

import net.springio.workshops.thymeleafworkshop.bike.Bike;
import net.springio.workshops.thymeleafworkshop.bike.BikeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService service;

    public BikeController(BikeService service) {
        this.service = service;
    }

    @GetMapping
    public String listBikes(Model model) {
        List<Bike> bikes = service.getBikes();
        model.addAttribute("bikes", bikes);
        return "bikes/list";
    }

    @GetMapping("/create")
    public String showCreateBikeForm(Model model) {
        model.addAttribute("formData", new CreateBikeFormData());
        return "bikes/create";
    }

    @PostMapping
    public String doCreateBike(@Valid @ModelAttribute("formData") CreateBikeFormData formData,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bikes/create";
        }

        service.createBike(formData.toParameters());

        return "redirect:/bikes";
    }

}
