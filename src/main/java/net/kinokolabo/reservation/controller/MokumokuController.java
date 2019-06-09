package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.domain.Mokumoku;
import net.kinokolabo.reservation.domain.Open;
import net.kinokolabo.reservation.domain.Reservation;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.mapper.MokumokuMapper;
import net.kinokolabo.reservation.mapper.OpenMapper;
import net.kinokolabo.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

@RestController
public class MokumokuController {

    @Autowired
    MokumokuMapper mapper;

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @RequestMapping(value = "/mokumoku/is-vacant", method = RequestMethod.GET)
    public String isVacant() {
        Mokumoku mokumoku = mapper.select();
        return "{\"vacant\":" + mokumoku.getIsVacant();
    }

    @RequestMapping(value = "/mokumoku/set-vacant", method = RequestMethod.GET)
    @ResponseBody
    public String setOpen(@RequestBody Boolean value) {
        Mokumoku mokumoku = new Mokumoku();
        mokumoku.setIsVacant(value);
        mapper.update(mokumoku);
        return "成功した";
    }
}
