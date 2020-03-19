package club.rain.entity;

/**
 * @author zyyy
 * 实体类，保存书籍信息
 * 对应 book 数据表，id（int），name（varchar），author（varchar），publish（varchar），pages（int），price（double），bookcaseid（int），abled（int）
 * 其中 bookcaseid 作为外键，与 bookcase 表相关联，并使用 bookcase 域保存数据信息
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
    private BookCase bookCase;

    public Book(Integer id, String name, String author, String publish, Integer pages, Double price, BookCase bookCase) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.pages = pages;
        this.price = price;
        this.bookCase = bookCase;
    }

    private Integer abled;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public Integer getAbled() {
        return abled;
    }

    public void setAbled(Integer abled) {
        this.abled = abled;
    }
}
