package alpacaCorp.shopSite.Service;

import alpacaCorp.shopSite.DTO.Profile;
import alpacaCorp.shopSite.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {
    ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public String addProfile(Profile profile) {
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }
}
