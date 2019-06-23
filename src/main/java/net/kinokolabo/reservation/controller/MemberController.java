package net.kinokolabo.reservation.controller;

import net.kinokolabo.reservation.domain.Member;
import net.kinokolabo.reservation.domain.Student;
import net.kinokolabo.reservation.mapper.MemberMapper;
import net.kinokolabo.reservation.mapper.StudentMapper;
import net.kinokolabo.reservation.model.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    StudentMapper studentMapper;

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @GetMapping("/member")
    public Member getMember(@RequestParam(defaultValue = "0") String id) {
        Member member;
        try{
            int idInt = Integer.parseInt(id);
            if(idInt == 0) {
                member = new Member();
            } else {
                member = memberMapper.selectById(idInt);
            }
        } catch (NumberFormatException e) {
            return null;
        }
        if(member == null) {
            return null;
        }
        System.out.println("member: " + member.getName());
        return member;
    }

    @CrossOrigin(origins = {"https://kinokodata.net", "http://localhost:8080"})
    @PostMapping("/member/regist")
    public int setMember(@RequestBody MemberForm form) {
        Member m = new Member();
        m.setId(form.getId());
        m.setName(form.getName());
        m.setNameKana(form.getNameKana());
        m.setZip(form.getZip());
        m.setPref(form.getPref());
        m.setAddr(form.getAddr());
        m.setTel1(form.getTel1());
        m.setTel2(form.getTel2());
        m.setMail(form.getMail());
//        m.setPasswd(form.getPasswd());

        int inserted = memberMapper.insert(m);

        return m.getId();
    }
}
