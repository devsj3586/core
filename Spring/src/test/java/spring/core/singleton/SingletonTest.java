package spring.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.AppConfig;
import spring.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        /*
          클라이언트가 요청할때마다 객체를 생성해 메모리 낭비가 심하다
          해결방안은 객체를 딱 1개만 생성되고, 공유하도록 설계하면 된다. -> 싱글톤 패턴
         */
        AppConfig appConfig = new AppConfig();
        //1. 조회  : 호출 할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회  : 호출 할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);

    }

}