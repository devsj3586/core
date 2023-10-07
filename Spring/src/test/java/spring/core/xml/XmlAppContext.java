package spring.core.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    /**
     * Xml로 스프링컨테니어 Test
     */
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
