package c0321g1_pawnshop_backend.dto.news;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Long newsId;

    @NotBlank(message = "Nội dung không được để trống!")
    @Size(max = 2007, message = "Nội dung không được lớn hơn 2000 kí tự!")
    private String content;

    @NotBlank(message = "Hình ảnh không được để trống!")
    private String image;

    @NotBlank(message = "Tiêu đề không được để trống!")
    @Size(max = 500, message = "Tiêu đề không được lớn hơn 500 kí tự!")
    private String title;
}
