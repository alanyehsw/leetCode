package exercise.leetCode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetCodeApplicationTests {

	@Test
	void contextLoads() {
		int sub = 121;
        int reversed = 0;
        while(sub != 0){
            reversed = reversed * 10 + sub % 10 ;
			System.out.println("reversed : " + reversed);
            sub /= 10;
			System.out.println("sub : " + sub);
        }
		System.out.println(121 == reversed);
	}

}
