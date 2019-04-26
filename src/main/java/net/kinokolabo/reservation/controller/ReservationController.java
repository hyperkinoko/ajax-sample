package net.kinokolabo.reservation.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import net.kinokolabo.reservation.domain.Open;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.domain.Reservation;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.mapper.OpenMapper;
import net.kinokolabo.reservation.mapper.ReservationMapper;

@RestController
public class ReservationController {

    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    OpenMapper openMapper;


    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public ArrayList<Open> getOpen(@RequestParam(defaultValue = "0") Integer year,
                                   @RequestParam(defaultValue = "0") Integer month,
                                   @RequestParam(defaultValue = "junior") String course) {
        LocalDate from = LocalDate.of(year, month, 1);
        LocalDate to = LocalDate.of(year, month + 1, 1);

        ArrayList<Open> list = openMapper.selectAllWithDateRange(Date.valueOf(from), Date.valueOf(to));
        return list;
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.GET)
    public ArrayList<Reservation> getReserve(@RequestParam(defaultValue = "") String user,
                                          @RequestParam(defaultValue = "") String from,
                                          @RequestParam(defaultValue = "") String to) {
        ArrayList<Reservation> list = new ArrayList<>();
        if(user.equals("")) {
            list = reservationMapper.selectAll();
        } else {
            list = reservationMapper.selectByUser(user);
        }
        return list;
    }

    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ArrayList<Reservation> postReserve(@RequestParam(defaultValue = "") String user,
                                          @RequestParam(defaultValue = "") String from,
                                          @RequestParam(defaultValue = "") String to) {
        ArrayList<Reservation> list = new ArrayList<>();
        if(from.equals("")) {
        } else {
            try {
                LocalDate.parse(from, DateTimeFormatter.ofPattern("YYMMDD"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(user.equals("")) {
            list = reservationMapper.selectAll();
        } else {
            list = reservationMapper.selectByUser(user);
        }
        return list;
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String commitUser(@RequestParam(defaultValue = "0") String id, Model model) {
        Member member = memberMapper.selectById(Integer.parseInt(id));
        if(member == null) {
            member = new Member();
        }
        System.out.println(member.getId());
        model.addAttribute("member", member);
        return "member_commit";
    }

    @RequestMapping(value = "/member/commit", method = RequestMethod.POST)
    public String commitUser(@ModelAttribute("user") Member member, Model model) {
        if (member.getId() == 0) {
            boolean result = memberMapper.insert(member);
        } else {
            boolean result = memberMapper.update(member);
        }
        return "member_commit";
    }
}
