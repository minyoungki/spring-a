package blog.blogspring.dto;

import blog.blogspring.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class ContentDto {

    private Long id;
    private String title;
    private String username;
    private String password;
    private String contents;

    public Blog toEntity() {
        return new Blog(id,title,username,password,contents);
    }


}
