package net.kinokolabo.reservation.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.domain.Open;
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

//    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @CrossOrigin
    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public ArrayList<Open> getOpen(@RequestParam(defaultValue = "0") Integer year,
                                   @RequestParam(defaultValue = "0") Integer month,
                                   @RequestParam(defaultValue = "junior") String course) {
        //LocalDate from = LocalDate.of(year, month, 1);
        //LocalDate to = LocalDate.of(year, month + 1, 1);

        ArrayList<Open> list = openMapper.selectAll();
        return list;
    }

    @RequestMapping(value = "/open/set", method = RequestMethod.POST)
    @ResponseBody
    public String setOpen(@RequestBody ArrayList<Open> list) {
        openMapper.deleteAll();
        int inserted = openMapper.insert(list);
        return inserted + "件insertしました";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ArrayList<Reservation> getReserve(@RequestParam(defaultValue = "0") Integer studentId,
                                          @RequestParam(defaultValue = "") String from,
                                          @RequestParam(defaultValue = "") String to) {
        ArrayList<Reservation> list = new ArrayList<>();
        if(studentId == 0) {
            list = reservationMapper.selectAll();
        } else {
            list = reservationMapper.selectByStudent(studentId);
        }
        return list;
    }

//    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
//    public ArrayList<Reservation> postReserve(@RequestParam(defaultValue = "") String user,
//                                          @RequestParam(defaultValue = "") String from,
//                                          @RequestParam(defaultValue = "") String to) {
//        ArrayList<Reservation> list = new ArrayList<>();
//        if(from.equals("")) {
//        } else {
//            try {
//                LocalDate.parse(from, DateTimeFormatter.ofPattern("YYMMDD"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//        if(user.equals("")) {
//            list = reservationMapper.selectAll();
//        } else {
//            list = reservationMapper.selectByUser(user);
//        }
//        return list;
//    }


}
