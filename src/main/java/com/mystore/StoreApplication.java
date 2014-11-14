package com.mystore;

import com.mystore.core.Template;
import com.mystore.core.Visit;
import com.mystore.db.VisitDAO;
import com.mystore.health.TemplateHealthCheck;
import com.mystore.resources.VisitResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class StoreApplication extends Application<StoreConfiguration>{
	
    public static void main(String[] args) throws Exception {
        new StoreApplication().run(args);
    }


    private final HibernateBundle<StoreConfiguration> hibernateBundle =
            new HibernateBundle<StoreConfiguration>(Visit.class) {
                public DataSourceFactory getDataSourceFactory(StoreConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public String getName() {
        return "store-app";
    }

    @Override
    public void initialize(Bootstrap<StoreConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<StoreConfiguration>() {
            public DataSourceFactory getDataSourceFactory(StoreConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(StoreConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final VisitDAO dao = new VisitDAO(hibernateBundle.getSessionFactory());
        final Template template = configuration.buildTemplate();

        environment.healthChecks().register("template", new TemplateHealthCheck(template));

        environment.jersey().register(new VisitResource(dao));
    }

}
