package c0321g1_pawnshop_backend.repository.news;

import c0321g1_pawnshop_backend.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {
    @Query(value = "SELECT * FROM news limit 10", nativeQuery = true)
    List<News> getNewsLimit10();

    @Query(value = "SELECT * FROM news limit 10 OFFSET 10", nativeQuery = true)
    List<News> getNewsMore();

    @Query(value = "SELECT * FROM news limit 5", nativeQuery = true)
    List<News> getNewsLimit5();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO news(title,image,content) VALUES (?1,?2,?3);", nativeQuery = true)
    void save(String title, String image, String content);
}
