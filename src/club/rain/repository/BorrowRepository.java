package club.rain.repository;

public interface BorrowRepository {
    public void insert(Integer bookId, Integer readerId, String borrowTime, String returnTime, Integer adminId, Integer statement);
}
