package uni.projects.javafxcrud;

import uni.projects.javafxcrud.models.dbService.DBServiceImpl;

/**
 * Created by qwe on 23.02.2016.
 */
public class DBServiceTesting {
    public static void main(String args[]){
        DBServiceImpl dbService = new DBServiceImpl();
        dbService.testing();
    }
}
