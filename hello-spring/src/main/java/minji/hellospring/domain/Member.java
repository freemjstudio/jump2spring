package minji.hellospring.domain;

public class Member {

    private Long id; // system 에서 데이터를 구분하기 위해 정하는 아이디
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
