/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.uha.gregclem.tp2;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author greg
 */
@Local
public interface NewsBeanLocal {
    List<News> listAllNews();
    News createNews(News news);
    News getNews(Long id);
}
