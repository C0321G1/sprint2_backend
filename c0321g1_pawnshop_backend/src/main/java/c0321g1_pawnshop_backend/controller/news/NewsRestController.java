package c0321g1_pawnshop_backend.controller.news;

import c0321g1_pawnshop_backend.dto.news.NewsDto;
import c0321g1_pawnshop_backend.entity.news.News;
import c0321g1_pawnshop_backend.service.news.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("news")
public class NewsRestController {
    @Autowired
    private NewsService newsService;

    @GetMapping("limit10")
    public ResponseEntity<List<News>> listNewsLimit10() {
        List<News> newsList = newsService.getNewsLimit10();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("more")
    public ResponseEntity<List<News>> listNewsMore() {
        List<News> newsList = newsService.getNewsMore();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("limit5")
    public ResponseEntity<List<News>> listNewsLimit5() {
        List<News> newsList = newsService.getNewsLimit5();
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

//        public static String encrytePassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
//
//    public static void main(String[] args) {
//        String password = "123456";
//        String encrytedPassword = encrytePassword(password);
//        System.out.println("Encryted Password: " + encrytedPassword);
//    }
}
