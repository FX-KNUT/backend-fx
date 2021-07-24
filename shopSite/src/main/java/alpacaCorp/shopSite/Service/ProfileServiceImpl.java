package alpacaCorp.shopSite.Service;

import alpacaCorp.shopSite.DTO.Profile;
import alpacaCorp.shopSite.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Long addProfile(Profile profile) {
        validateDuplicateProfile(profile);
        profileRepository.save(profile);
        return profile.getId();
    }

    /*
     * 중복 프로필 검증
     */
    public void validateDuplicateProfile(Profile profile) {
        profileRepository.findById(profile.getId())
                .ifPresent(p -> {
                    throw new IllegalStateException("Already existed.");
                });
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }
}
