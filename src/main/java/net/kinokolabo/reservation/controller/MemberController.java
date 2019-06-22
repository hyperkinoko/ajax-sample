package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.model.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @GetMapping("/member")
    public String getMember(@RequestParam(defaultValue = "0") String id, Model model) {
        Member member;
        try{
            int idInt = Integer.parseInt(id);
            if(idInt == 0) {
                member = new Member();
            } else {
                member = memberMapper.selectById(idInt);
            }
        } catch (NumberFormatException e) {
            return "error";
        }
        if(member == null) {
            return "error";
        }
        System.out.println("member: " + member.getName());
        model.addAttribute("member", member);
        return "member";
    }

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @PostMapping("/member/regist")
    public String setMember(@RequestBody MemberForm form) {
//        System.out.println("id:" + form.getId());
        System.out.println("name:" + form.getName());
        System.out.println("addr:" + form.getAddress());
        System.out.println("zip:" + form.getZip());
        System.out.println("tel:" + form.getTelNo());
        System.out.println("pref:" + form.getPref());

        return form.getName();
    }
}
