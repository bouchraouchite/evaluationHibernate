package org.example.dao;


import org.example.entities.Departement;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartementDao {
    public static void ajouterDepartement(Departement departement) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(departement);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void supprimerDepartement(Long departementId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Departement departement = session.get(Departement.class, departementId);
            if (departement != null) {
                session.delete(departement);
                System.out.println("Département est supprimé");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Departement trouverDepartementParEmploye(Long employeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Departement) session.createQuery("select e.departement from Employe e where e.id = :employeId")
                    .setParameter("employeId", employeId)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
