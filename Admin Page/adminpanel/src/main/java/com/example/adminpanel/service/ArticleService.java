package com.example.adminpanel.service;
import com.example.adminpanel.repository.ArticleRepository;
import com.example.adminpanel.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    private final String uploadDir = "uploads";

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

        File dir = new File(uploadDir);
        if(!dir.exists()){
            dir.mkdir();
        }
    }

    public List<Article> getAll(){
        return articleRepository.findAll();
    }

    public Article addArticle(String title, String description, MultipartFile image) throws IOException {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);

        if(image!=null && !image.isEmpty()){
            String fileName = System.currentTimeMillis()+ "_" + image.getOriginalFilename();
            File dest = new File(uploadDir + "/" + fileName);
            image.transferTo(dest);
            article.setImagePath("/uploads/"+fileName);
        }
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }
}
