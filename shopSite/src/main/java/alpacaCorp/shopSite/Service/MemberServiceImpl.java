package alpacaCorp.shopSite.Service;

import alpacaCorp.shopSite.DTO.Member;
import alpacaCorp.shopSite.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean memberJoin(Member member) {
        return memberRepository.userJoin(member);
    }

    @Override
    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findMember(Member member) {
        return memberRepository.findMember(member);
    }
}
