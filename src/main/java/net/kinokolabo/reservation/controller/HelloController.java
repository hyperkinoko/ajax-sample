package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Fruit;
import net.kinokolabo.reservation.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    FruitMapper fruitMapper;

    @RequestMapping("/")
    public String getHello(Model model) {
        List<Fruit> list = fruitMapper.selectAll();
        model.addAttribute("fruits", list);
        return "hello";
    }
}
