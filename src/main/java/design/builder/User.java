package design.builder;

public class User {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String Name;
    private int age;
    private String mobile;
    //构造器私有
    private User(){}

    /**
     * user 构造器
     */
    public static class UserBuilder{
        User user = new User();
        public UserBuilder name(String name){
            user.setName(name);
            return this;
        }
        public UserBuilder age(int age){
            user.setAge(age);
            return this;
        }
        public UserBuilder mobile(String mobile){
            user.setMobile(mobile);
            return this;
        }
        public User build(){
            return user;
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder().age(1).name("zz").mobile("111").build();
    }
}
