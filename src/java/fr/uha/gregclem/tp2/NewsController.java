/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.uha.gregclem.tp2;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author greg
 */
@ManagedBean
@SessionScoped
public class NewsController {
    
    @EJB
    private NewsBeanLocal newsBean;
    private News editedNews = new News();

    /**
     * Creates a new instance of NewsController
     */
    public NewsController() {
    }
    
    public List<News> getNews()
    {
        return newsBean.listAllNews();
    }

    public News getEditedNews() {
        return editedNews;
    }
    
    public String doCreateNews()
    {
        editedNews = new News();
        return "createNews.xhtml";
    }
    
    public String doAddNews() {
        editedNews.setDate(new Date());
        newsBean.createNews(editedNews);
        return "index.xhtml";
    }
    
    public String doShowNews(Long id) {
        //FacesContext cts = FacesContext.getCurrentInstance();
        //Long id = Long.parseLong(cts.getExternalContext().getRequestParameterMap().get("news"));
        editedNews = newsBean.getNews(id);
        return "DetailsNews.xhtml";
    }
    
}
