/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.uha.gregclem.tp2;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author greg
 */
@Stateless
public class NewsBean implements NewsBeanLocal {

    @PersistenceContext
    EntityManager em;
            
    @Override
    public List<News> listAllNews() {
        Query query = em.createQuery("SELECT n FROM News n ORDER BY n.date ASC");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public News createNews(News news) {
        em.persist(news);
        return news;
    }

    @Override
    public News getNews(Long id) {
        return em.find(News.class, id);
    }
    
    
}
