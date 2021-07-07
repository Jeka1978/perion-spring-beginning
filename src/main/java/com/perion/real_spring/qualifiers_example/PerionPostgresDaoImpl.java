package com.perion.real_spring.qualifiers_example;

import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@PerionRepo(DBType.POSTGRES)
public class PerionPostgresDaoImpl implements PerionDao {
    @Override
    public void save() {
        System.out.println("saving to POSTGRES");
    }
}
