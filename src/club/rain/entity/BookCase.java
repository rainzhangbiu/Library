package club.rain.entity;

import java.util.List;

/**
 * @author zyyy
 *
 * 实体类，保存书籍分类信息
 * 对应 bookcase 数据表，id（int），name（String）
 */
public class BookCase {
    private Integer id;
    private String name;
    private List<Book> books;

    public BookCase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
