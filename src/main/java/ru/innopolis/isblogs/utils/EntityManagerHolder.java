package ru.innopolis.isblogs.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Nikolay on 05.12.2016.
 */
public class EntityManagerHolder {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("postgres");

    private static final EntityManager ENITTY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();

    public static EntityManager getEntityManager(){
        return ENITTY_MANAGER;
    }

}