package c0321g1_pawnshop_backend.service_impl.news;

import c0321g1_pawnshop_backend.entity.news.News;
import c0321g1_pawnshop_backend.repository.news.NewsRepository;
import c0321g1_pawnshop_backend.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getNewsLimit10() {
        return newsRepository.getNewsLimit10();
    }

    @Override
    public List<News> getNewsMore() {
        return newsRepository.getNewsMore();
    }

    @Override
    public List<News> getNewsLimit5() {
        return newsRepository.getNewsLimit5();
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }
}
