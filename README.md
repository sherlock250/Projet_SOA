# 📊 TP4 : Services Web REST avec JPA/Hibernate

## 📋 Description du projet

Ce projet implémente un système de gestion de personnes (CRUD) utilisant **JPA (Java Persistence API)** avec **Hibernate** comme implémentation. L'application permet de persister des données dans une base de données MySQL tout en respectant les principes de l'ORM (Object-Relational Mapping).

## 🎯 Objectifs pédagogiques

- Comprendre et utiliser les annotations JPA pour le mapping objet-relationnel
- Maîtriser l'EntityManager de Hibernate pour les opérations CRUD
- Configurer un projet Maven avec les dépendances JPA/Hibernate
- Implémenter la persistance des données dans une base de données relationnelle

## 🛠️ Technologies utilisées

### Backend
- **Java 8+**
- **JPA (Java Persistence API) 2.2**
- **Hibernate 5.6.15.Final** (implémentation JPA)
- **Maven** (gestion des dépendances)

### Base de données
- **MySQL 8.0+**
- **JDBC Driver** pour la connexion

### Outils de développement
- **IDE** : Eclipse, IntelliJ IDEA ou VS Code
- **SGBD** : MySQL Workbench ou phpMyAdmin
- **Postman** (pour tester les futurs endpoints REST)

📊 Fonctionnalités implémentées
CRUD complet
✅ Create : Ajout d'une nouvelle personne

✅ Read : Consultation par ID, par nom ou liste complète

✅ Update : Modification des informations d'une personne

✅ Delete : Suppression d'une personne par ID

Interface console
Menu interactif avec Scanner

Gestion des erreurs et transactions

Affichage formaté des résultats

Persistance JPA
Mapping objet-relationnel avec annotations

Gestion automatique des transactions

Génération automatique du schéma (DDL)

📊 Entité Person
package tp4.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
📖 Utilisation de l'application

=== GESTION DES PERSONNES (JPA/Hibernate) ===

=== MENU PRINCIPAL ===
1. Ajouter une personne
2. Afficher toutes les personnes
3. Rechercher une personne par ID
4. Modifier une personne
5. Supprimer une personne
6. Rechercher par nom
7. Quitter
Votre choix :

# Ajouter une personne
Nom : John Doe
Âge : 30
✅ Personne ajoutée avec succès !

# Afficher la liste
=== LISTE DES PERSONNES ===
Person [id=1, name=John Doe, age=30]
Person [id=2, name=Jane Smith, age=25]
Total : 2 personne(s)


👥 Auteurs
Hamza Hammami 
ESSTHS
