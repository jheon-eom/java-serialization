package serialization.test;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private String email;
    private int age;

    public Member(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Member member = new Member("엄종헌", "e4033jh@daum.net", 29);
        String myInfo = member.toString();
        System.out.println(myInfo);
    }
}
