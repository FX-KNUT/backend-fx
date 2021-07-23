package alpacaCorp.shopSite.Controller;

import alpacaCorp.shopSite.DTO.Member;
import alpacaCorp.shopSite.DTO.Profile;
import alpacaCorp.shopSite.Service.MemberService;
import alpacaCorp.shopSite.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileManageController {
    ProfileService profileService;

    @Autowired
    public ProfileManageController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /*
     * 새로운 프로필 추가 (쓰이지 않는다면 삭제 예정)

    @PostMapping("profiles/add")
    public String addProfile(@ModelAttribute("profile") Profile profile) {
        profileService.addProfile(profile);
        return "redirect:/";
    }
    */

    /*
     * 프로필 리스트 매핑

    @PostMapping("/profiles")
    public List<Profile> ProfileList(Model model) {
        List<Profile> profiles = profileService.findAll();
        model.addAttribute("profiles", profiles);
        return profiles;
    }
    */
}
