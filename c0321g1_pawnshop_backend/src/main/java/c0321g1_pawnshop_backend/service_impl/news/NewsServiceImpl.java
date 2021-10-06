package c0321g1_pawnshop_backend.service_impl.news;

import c0321g1_pawnshop_backend.repository.news.NewsRepository;
import c0321g1_pawnshop_backend.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
}
