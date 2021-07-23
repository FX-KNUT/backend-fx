package alpacaCorp.shopSite.Controller;

import alpacaCorp.shopSite.DTO.Member;
import alpacaCorp.shopSite.Repository.MemberRepository;
import alpacaCorp.shopSite.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class MemberMangeController {

    MemberService memberService;
    MemberRepository memberRepository;

    @Autowired
    public MemberMangeController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    /*
     * @RequestParam("id") String id,
     * @RequestParam("password") String password
     */
    @RequestMapping("/alpaca/mainPage")
    public String View(Model model,
                       HttpServletRequest request,
                       @ModelAttribute Member member){
        log.info("userid = {}, password = {}",member.getId(),member.getPassword());
//        MemberService bean = ac.getBean(MemberService.class);

        Member userInfo = memberService.findMember(member);

        if(userInfo == null){
            return "loginFail";
        }

        String name = userInfo.getName();
        log.info("hello {}",name);
        //model.addAttribute("findUser",findUser);
        HttpSession session = request.getSession();
        session.setAttribute("findUser", userInfo);
        model.addAttribute("findUser",userInfo);

        return "login";
    }

    @RequestMapping("/alpaca/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/alpaca/join")
    public String Join(){
        return "join";
    }

    @RequestMapping("/alpaca/join/process")
    public String JoinProcess(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("password") String password,
                              @RequestParam("repassword") String repassword){
//        MemberService bean = ac.getBean(MemberService.class);
        log.info("{}=={}========={}==================================",password,repassword,password.equals(repassword));
        if (password.equals(repassword)){
            Member member = new Member(id, password, name);
            boolean join = memberService.memberJoin(member);
            if(join==true){
                return "login";
            }else{
                return "redirect:/";
            }
        }else{
            return "redirect:/";
        }

    }
    @RequestMapping("/alpaca/logout")
    public String Logout(HttpSession session){
        session.removeAttribute("findUser");
        return "login";
    }
}
