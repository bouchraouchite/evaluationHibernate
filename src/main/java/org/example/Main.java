package org.example;


import org.example.dao.DepartementDao;
import org.example.dao.EmployeDao;
import org.example.entities.Departement;
import org.example.entities.Employe;

public class Main {
    public static void main(String[] args) {
        EmployeDao employeDAO = new EmployeDao();
        DepartementDao departementDAO = new DepartementDao();

        Departement departement = new Departement();
        departement.setNom("R&D");
        DepartementDao.ajouterDepartement(departement);

        Employe employe = new Employe();
        employe.setNom("Bouchra");
        employe.setPrenom("Ouchite");
        employe.setEmail("bouchra.ouchite@e-polytechnique.ma");
        employe.setDepartement(departement);
        employeDAO.ajouterEmploye(employe);

    }
}
