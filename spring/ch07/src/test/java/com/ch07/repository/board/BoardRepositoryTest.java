package com.ch07.repository.board;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.File;
import com.ch07.entity.board.User;
import org.hibernate.query.SelectionQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
public class BoardRepositoryTest {

    @Autowired private AriticleRepository ariticleRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private UserRepository userRepository;

    // 테스트 1 - 사용자 등록
    @Test
    void insertUserTest(){
        User user = User.builder()
                .uid("A102")
                .name("황수빈")
                .nick("빈")
                .email("subin@naver.com")
                .build();

        userRepository.save(user);

    }
    // 테스트 2 - 글 목록
    @Test
    void insertArticleTest(){

        User user = User.builder()
                .uid("A101")
                .name("황준언")
                .nick("언")
                .email("junun@naver.com")
                .build();
        userRepository.save(user);

        Article article = Article.builder()
                .title("제목1입니다")
                .content("내용입니다")
                .user(user)
                .build();

        ariticleRepository.save(article);
    }

    // 테스트 3 - 댓글 등록
    @Test
    void insertCommentTest() {
    User user = User.builder()
            .uid("A102")
            .build();

        Article article = Article.builder()
                        .no(3)
                        .build();

        Comment comment = Comment.builder()
                         .user(user)
                        .content("댓글 1입니다.")
                        .article(article)
                        .build();
        commentRepository.save(comment);

    }

    // 테스트 4 - 파일 등록
    @Test
    void insertFileTest() {

        Article article = Article.builder()
                .no(3)
                .build();

        File file = File.builder()
                .oName("test1.txt")
                .sName("ABC1234.txt")
                .article(article)
                .build();
    }

    // 테스트 5 - 글 조회
    @Transactional // no Session 방지
    @Test
    void selectArticlesTest() {
        List<Article> articles = ariticleRepository.findAll();
        System.out.println(articles);


        for(Article article : articles){
            List<Comment> comments = article.getComment();
            List<File> files = article.getFile();

            System.out.println(comments);
            System.out.println(files);
        }
    }
}
