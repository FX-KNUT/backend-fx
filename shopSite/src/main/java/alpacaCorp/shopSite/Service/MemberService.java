package alpacaCorp.shopSite.Service;

import alpacaCorp.shopSite.DTO.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    /*
     * 회원 가입
     */
    boolean memberJoin(Member member);

    /*
     * 검색: ID 값으로 회원 조회
     */
    Optional<Member> findById(String id);

    /*
     * 검색: Name 값으로 회원 리스트 조회
     */
    List<Member> findByName(String name);

    /*
     * 전체 회원 조회
     */
    List<Member> findAll();

    /*
     * 로그인: ID 값과 Password 값으로 회원 반환.
     */
    Member findMember(Member member);
}
