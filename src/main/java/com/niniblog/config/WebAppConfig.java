package com.niniblog.config;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Yang on 2016/5/12.
 * Web配置类
 */
@Configuration
@ComponentScan("com.niniblog")
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter
{
    private static final String PROPERTY_NAME_DATABASE_DRIVE="db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD="db.password";
    private static final String PROPERTY_NAME_DATABASE_URL="db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME="db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT="hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL="hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN="entitymanager.packages.to.scan";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVE));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        return dataSource;
    }

    private Properties hibProperties()
    {
        Properties properties=new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }



    @Bean
    public ViewResolver setupViewResolver()
    {
        FreeMarkerViewResolver freemarkerResolver=new FreeMarkerViewResolver();
        //freemarkerResolver.setPrefix("/WEB-INF/views/");
        freemarkerResolver.setSuffix(".ftl");
       // freemarkerResolver.setContentType("utf-8");
        freemarkerResolver.setViewClass(FreeMarkerView.class);
        return freemarkerResolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;
    }

    /**
     * 设置静态资源访问
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/css/**").addResourceLocations("/static-resource/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/static-resource/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/static-resource/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/static-resource/js/");
        registry.addResourceHandler("/sass/**").addResourceLocations("/static-resource/sass/");
    }
}
