package com.repost.insta.model.database;

import java.util.List;

/**
 * Created by Niyati on 2/9/2017.
 */

public class DatabaseListPOJO {

    private List<DatabasePOJO> databasePOJOList;

   /* public DatabaseListPOJO(List<DatabasePOJO> databasePOJOList){
        this.databasePOJOList = databasePOJOList;
    }*/
    public List<DatabasePOJO> getDatabasePOJOList() {
        return databasePOJOList;
    }

    public void setDatabasePOJOList(List<DatabasePOJO> databasePOJOList) {
        this.databasePOJOList = databasePOJOList;
    }
}
