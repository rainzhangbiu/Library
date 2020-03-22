package club.rain.repository;

import club.rain.entity.BorrowInfo;
import com.sun.jdi.IntegerType;

import java.util.List;

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

    /**
     * 根据用户 id 查询用户的借阅信息
     *
     * @param readerId 用户 id
     * @param index    当前页面
     * @param limit    每个页面数据量
     * @return 返回一个 BorrowInfo 集合
     */
    List<BorrowInfo> findBorrowInfo(Integer readerId, Integer index, int limit);

    /**
     * 根据 id 获取用户借阅书籍总数
     *
     * @param readerId 用户 id
     * @return 书籍总数
     */
    int getCount(Integer readerId);

    /**
     * 查询未审核的借阅信息
     *
     * @param state 审核状态
     * @param index 页码
     * @param limit 每页数据量
     * @return 返回一个借阅信息集合
     */
    List<BorrowInfo> findBorrowByState(Integer state, Integer index, int limit);

    /**
     * 查询指定审核状态的借阅信息数量
     *
     * @param state 审核状态
     * @return 借阅信息数量
     */
    int getBorrowCountByState(Integer state);

    /**
     * 处理订阅信息
     *
     * @param borrowId 借阅信息 id
     * @param state    借阅状态
     * @param adminId  处理者 id
     */
    void handle(Integer borrowId, Integer state, Integer adminId);
}
