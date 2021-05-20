import org.apache.commons.lang3.RandomStringUtils;

public class Main {

    public static void main(String[] args) {
        String random = RandomStringUtils.randomAlphanumeric(10)+"@gmail.com";
        System.out.println(random);
    }
}
