package ca.tetervak.flowerdata.controller;

import ca.tetervak.flowerdata.data.FlowerDataRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Controller
public class FlowerPageController {

    private final FlowerDataRepository repository;

    public FlowerPageController(FlowerDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"/", "/flowers"})
    ModelAndView flowerList(){
        return new ModelAndView("FlowerList",
                "flowers", repository.findAll());
    }

    @GetMapping("/flowers/{id}")
    ModelAndView flowerDetails(@PathVariable String id){
        return new ModelAndView("FlowerDetails",
                "flower",
                repository.findById(id).orElseThrow());
    }

    @ModelAttribute("localDate")
    LocalDate getlLocalDate(){
        return LocalDate.now();
    }

    @ExceptionHandler(NoSuchElementException.class)
    ModelAndView dataNotFound(NoSuchElementException e){
        ModelAndView mv = new ModelAndView("DataNotFound", "message", e.getMessage());
        mv.addObject("localDate", getlLocalDate());
        return mv;
    }
}
