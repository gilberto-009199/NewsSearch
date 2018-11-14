package br.com.sp.senaijandira.newssearch.services.model;

import java.util.List;

/**
 * Created by 16254850 on 12/11/2018.
 */

public class ApiResponse {
    private String status;
    private String totalResult;
    List<Artigo> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public List<Artigo> getArticles() {
        return articles;
    }

    public void setArticles(List<Artigo> articles) {
        this.articles = articles;
    }
}
