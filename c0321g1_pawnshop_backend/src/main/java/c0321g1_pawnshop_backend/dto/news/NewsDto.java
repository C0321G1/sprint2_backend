package c0321g1_pawnshop_backend.dto.news;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Long newsId;
    private String content;
    private String image;
    private String title;
}
