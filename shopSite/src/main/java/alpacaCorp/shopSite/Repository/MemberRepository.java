package alpacaCorp.shopSite.Repository;


import alpacaCorp.shopSite.DTO.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /*
     * 회원 추가.
     */
    boolean userJoin(Member member);

    /*
     * 검색: ID 값으로 특정 회원 반환.
     */
    Optional<Member> findById(Long id);

    /*
     * 검색: Name 값으로 회원 리스트 반환.
     */
    List<Member> findByName(String name);

    /*
     * 검색: 모든 회원 리스트 반환.
     */
    List<Member> findAll();

    /*
     * 로그인: ID 값과 Pasword 값으로 회원 반환.
     */
    Member findMember(Member member);

}

