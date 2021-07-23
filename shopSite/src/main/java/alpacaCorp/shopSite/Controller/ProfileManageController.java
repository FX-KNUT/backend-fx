package alpacaCorp.shopSite.Controller;

import alpacaCorp.shopSite.DTO.Profile;
import alpacaCorp.shopSite.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /**
     * 새로운 프로필 추가
     */
    @PostMapping("profiles/add")
    public String addProfile(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("color") String color,
                             @RequestParam("img") String img,
                             @RequestParam("start_date") String start_date,
                             @RequestParam("end_date") String end_date) {
        Profile profile = new Profile();
        profile.setId(id);
        profile.setName(name);
        profile.setColor(color);
        profile.setImg(img);
        profile.setStart_date(start_date);
        profile.setEnd_date(end_date);

        profileService.addProfile(profile);

        return "redirect:/";
    }

    /**
     * 프로필 리스트 매핑
     */
    @PostMapping("/profiles")
    public List<Profile> ProfileList(Model model) {
        List<Profile> profiles = profileService.findAll();
        model.addAttribute("profiles", profiles);
        return profiles;
    }
}
