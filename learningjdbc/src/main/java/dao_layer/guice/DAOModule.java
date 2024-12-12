package dao_layer.guice;

import com.google.inject.AbstractModule;
import dao_layer.MyDataSource;

import javax.sql.DataSource;

public class DAOModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DataSource.class).to(MyDataSource.class);
    }
}
