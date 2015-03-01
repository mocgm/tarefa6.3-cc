/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Candidato_;
import inscricao.persistence.entity.Idioma;
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
public class CandidatoJpaController extends JpaController {

    public CandidatoJpaController() {
    }
    
    public List<Candidato> findByIdioma(Idioma idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Candidato> cq = cb.createQuery(Candidato.class);
            Root<Candidato> rt = cq.from(Candidato.class);                                    
            cq.where(cb.equal(rt.get((Candidato_.idioma)), idioma));
            cq.orderBy(cb.asc(rt.get(Candidato_.nome)));
            TypedQuery<Candidato> q = em.createQuery(cq);
            /*TypedQuery<Candidato> q = em.createQuery(
                "select c from Candidato c where c.idioma = :idioma order by c.nome",
                Candidato.class);
            q.setParameter("idioma", idioma);*/
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Candidato> findByIdioma(Integer idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Candidato> cq = cb.createQuery(Candidato.class);
            Root<Candidato> rt = cq.from(Candidato.class);
            cq.where(cb.equal(rt.get((Candidato_.idioma)), idioma));
            TypedQuery<Candidato> q = em.createQuery(cq);            
            /*TypedQuery<Candidato> q = em.createQuery(
                "select Candidato c from Candidato where c.idioma.codigo = :idioma",
                Candidato.class);
            q.setParameter("idioma", idioma);*/
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
    
    public List<Candidato> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Candidato> cq = cb.createQuery(Candidato.class);  
            Root<Candidato> rt = cq.from(Candidato.class);
            TypedQuery<Candidato> q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
