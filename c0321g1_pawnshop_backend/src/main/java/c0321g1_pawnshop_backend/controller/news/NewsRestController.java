package c0321g1_pawnshop_backend.controller.news;

import c0321g1_pawnshop_backend.dto.news.NewsDto;
import c0321g1_pawnshop_backend.entity.news.News;
import c0321g1_pawnshop_backend.service.news.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class NewsRestController {
    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> list() {
        List<News> newsList = newsService.findAll();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody NewsDto newsDto) {
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        newsService.save(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
