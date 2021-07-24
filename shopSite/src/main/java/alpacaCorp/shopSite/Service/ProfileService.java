package alpacaCorp.shopSite.Service;

import alpacaCorp.shopSite.DTO.Profile;

import java.util.List;

public interface ProfileService {
    /*
     * 프로필 추가
     */
    public Long addProfile(Profile profile);

    /*
     * 전체 프로필 조회
     */
    public List<Profile> findAll();
}
