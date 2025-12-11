package com.example.adminpanel.service;

import com.example.adminpanel.repository.ArticleRepository;
import com.example.adminpanel.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final FileStorageService fileStorageService;

    public ArticleService(ArticleRepository articleRepository, FileStorageService fileStorageService) {
        this.articleRepository = articleRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<Article> getAll(){
        return articleRepository.findAll();
    }

    public Article addArticle(String title, String description, MultipartFile image) throws IOException {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);

        if(image != null && !image.isEmpty()){
            String fileName = fileStorageService.storeFile(image);
            article.setImagePath("/uploads/" + fileName); // Salvăm calea relativă
        }

        return articleRepository.save(article);
    }

    public void deleteArticle(Long id){
        Article article = articleRepository.findById(id).orElse(null);
        if(article != null && article.getImagePath() != null){
            // Extragem numele fișierului din cale
            String fileName = article.getImagePath().replace("/uploads/", "");
            fileStorageService.deleteFile(fileName);
        }
        articleRepository.deleteById(id);
    }
}