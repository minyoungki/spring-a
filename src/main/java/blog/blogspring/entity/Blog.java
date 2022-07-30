package blog.blogspring.entity;

import blog.blogspring.dto.ContentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor // 기본 생성자
@ToString   //toString 생성
@NoArgsConstructor // 디폴트 생성자
@Getter
@Entity
public class Blog extends Timestamped {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String contents;

}
