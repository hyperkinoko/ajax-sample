package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

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
}
