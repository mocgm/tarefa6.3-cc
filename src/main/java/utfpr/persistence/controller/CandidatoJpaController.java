/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.persistence.controller;

import inscricao.persistence.entity.Candidato;
import inscricao.persistence.entity.Idioma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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
            TypedQuery<Candidato> q = em.createQuery(
                "select c from Candidato c where c.idioma = :idioma order by c.nome",
                Candidato.class);
            q.setParameter("idioma", idioma);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Candidato> findByIdioma(Integer idioma) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Candidato> q = em.createQuery(
                "select Candidato c from Candidato where c.idioma.codigo = :idioma",
                Candidato.class);
            q.setParameter("idioma", idioma);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }
}
