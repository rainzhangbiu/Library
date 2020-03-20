package club.rain.entity;

/**
 * @author zyyy
 * <p>
 * 实体类，保存读者用户信息
 * 对应 reader 数据表，id（int），username（varchar），password（varchar），name（carchar），tel（varchar），cardid（varchar），gender（varchar）
 */
public class Reader {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String tel;
    private String cardId;
    private String gender;

    public Reader(String name, String tel, String cardId) {
        this.name = name;
        this.tel = tel;
        this.cardId = cardId;
    }

    public Reader(Integer id, String username, String password, String name, String tel, String cardId, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.cardId = cardId;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
