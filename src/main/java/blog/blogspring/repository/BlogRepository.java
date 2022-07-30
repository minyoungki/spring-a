package blog.blogspring.repository;

import blog.blogspring.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Override
    List<Blog> findAll();
    List<BlogMapping> findByPassword(String password);
}
