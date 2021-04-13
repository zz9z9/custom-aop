package springbasic.customaop;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Override
    public void save() {
        System.out.println("save!");
    }

    @Override
    public void find() {
        System.out.println("find!");
    }
}
