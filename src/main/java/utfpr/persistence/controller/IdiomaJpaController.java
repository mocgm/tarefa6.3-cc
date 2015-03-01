/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Idioma;
import inscricao.persistence.entity.Idioma_;
//import inscricao.persistence.entity.Idioma_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Wilson
 */
public class IdiomaJpaController extends JpaController {

    public IdiomaJpaController() {
    }

    public List<Idioma> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Idioma> cq = cb.createQuery(Idioma.class);
            Root<Idioma> rt = cq.from(Idioma.class);
            //cq.where(cb.equal(rt.get(Idioma_.codigo), 1));
            TypedQuery<Idioma> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
