package c0321g1_pawnshop_backend.service.news;

import c0321g1_pawnshop_backend.entity.news.News;

import java.util.List;

public interface NewsService {

    List<News> getNewsLimit10();

    List<News> getNewsMore();

    List<News> getNewsLimit5();

    void save(News news);
}
