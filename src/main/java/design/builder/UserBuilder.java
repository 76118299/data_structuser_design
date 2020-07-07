package design.builder;

public class UserBuilder implements ObjectBuilder {
    private User user = new User();
    public ObjectBuilder builder1() {
        user.setAge(1);
        return this;
    }

    public ObjectBuilder builder2() {
        user.setMobile("111");
        return this;
    }

    public ObjectBuilder builder3() {
        user.setName("adadf");
        return this;
    }

    public User build() {
        return user;
    }

    public static void main(String[] args) {
        UserBuilder userBuilder = new UserBuilder();
        User user1 = userBuilder.builder1().builder2().builder3().build();

    }


}
