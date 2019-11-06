package Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperty {
    private String dialect;
    private String defaultSchema;
    private Boolean showSql;
    private Boolean enableLazyLoad;
    private Connection connection = new Connection();

    @Data
    public static class Connection {
        private String driverClass;
        private String url;
        private String username;
        private String password;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getDefaultSchema() {
        return defaultSchema;
    }

    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }

    public Boolean getShowSql() {
        return showSql;
    }

    public void setShowSql(Boolean showSql) {
        this.showSql = showSql;
    }

    public Boolean getEnableLazyLoad() {
        return enableLazyLoad;
    }

    public void setEnableLazyLoad(Boolean enableLazyLoad) {
        this.enableLazyLoad = enableLazyLoad;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
