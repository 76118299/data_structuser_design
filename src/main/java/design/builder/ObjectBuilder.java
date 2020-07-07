package design.builder;

/**
 * 对象构造器
 */
public interface ObjectBuilder {
    public ObjectBuilder builder1();
    public ObjectBuilder builder2();
    public ObjectBuilder builder3();
    public User build();
}
