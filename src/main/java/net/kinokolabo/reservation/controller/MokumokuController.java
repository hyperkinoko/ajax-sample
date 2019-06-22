package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Mokumoku;
import net.kinokolabo.reservation.mapper.MokumokuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

@RestController
public class MokumokuController {

    @Autowired
    MokumokuMapper mapper;

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @RequestMapping(value = "/mokumoku/is-vacant", method = RequestMethod.GET)
    public Mokumoku isVacant() {
        Mokumoku mokumoku = mapper.select();
        return mokumoku;
    }

    @RequestMapping(value = "/mokumoku/set-vacant", method = RequestMethod.GET)
    @ResponseBody
    public String setOpen(@RequestParam("value") String value) {
        Mokumoku mokumoku = new Mokumoku();
        mokumoku.setIsVacant(Boolean.parseBoolean(value));
        System.out.println(mokumoku.getIsVacant());
        mapper.update(mokumoku);
        return "成功した";
    }
}
