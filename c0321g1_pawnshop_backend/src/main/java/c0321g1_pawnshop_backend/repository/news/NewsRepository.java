package c0321g1_pawnshop_backend.repository.news;

import c0321g1_pawnshop_backend.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {
}
