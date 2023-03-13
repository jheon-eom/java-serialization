package serialization.test;

import java.io.*;
import java.util.Base64;

public class SerializableTest {

    /**
     * Member 객체에 Serializable 인터페이스를 구현하지 않을 경우
     * NotSerializableException 익셉션 발생
     */
    public static void main(String[] args) throws Exception {
        Member member = new Member("엄종헌", "e4033jh@daum.net", 29);
        byte[] serializedMember;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(member);
                serializedMember = baos.toByteArray();
                System.out.println("직렬화된 객체 : " + serializedMember);
            }
        }
        String base64Member = Base64.getEncoder().encodeToString(serializedMember);
        System.out.println("인코딩 객체 : " + base64Member);
        byte[] deserializedMember = Base64.getDecoder().decode(base64Member);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(deserializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                Object objectMember = ois.readObject();
                Member readMember = (Member) objectMember;
                System.out.println("deserializedMember 객체 : " + readMember);
            }
        }
    }
}
