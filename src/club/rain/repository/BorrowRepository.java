package club.rain.repository;

/**
 * @author zyyy
 */
public interface BorrowRepository {
    /**
     * 添加借阅信息
     *
     * @param bookId     被借书籍 id
     * @param readerId   借阅者 id
     * @param borrowTime 借阅时间
     * @param returnTime 应当归还时间
     * @param adminId    处理借阅信息管理者 id
     * @param statement  当前图书状态
     */
    void insert(Integer bookId, Integer readerId, String borrowTime, String returnTime, Integer adminId, Integer statement);
}
