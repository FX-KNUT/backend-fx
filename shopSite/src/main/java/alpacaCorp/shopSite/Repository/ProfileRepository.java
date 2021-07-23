package alpacaCorp.shopSite.Repository;

import alpacaCorp.shopSite.DTO.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    /*
     * 프로필 추가
     */
    Profile save(Profile profile);

    /*
     * 프로필 리스트 반환
     */
    List<Profile> findAll();

    /*
     * 특정 프로필 찾기
     */
    Optional<Profile> findById(String id);
}
