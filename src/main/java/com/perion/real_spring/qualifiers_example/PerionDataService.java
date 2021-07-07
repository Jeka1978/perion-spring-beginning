package com.perion.real_spring.qualifiers_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class PerionDataService {

    @PerionRepo(DBType.MONGO)
    private PerionDao primaryDao;

    @PerionRepo(DBType.POSTGRES)
    private PerionDao backupDao;



    @Scheduled(fixedDelay = 1000)
    public void work(){
        primaryDao.save();
    }


    @Scheduled(fixedDelay = 3000)
    public void backup(){
        backupDao.save();
    }
















}
