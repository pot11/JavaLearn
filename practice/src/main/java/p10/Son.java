package p10;

public class Son extends Person{
    private String age = "zi";
    int num = 8;



    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }
}
