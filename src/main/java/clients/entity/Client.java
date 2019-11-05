package clients.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column()
    private long inn;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public Client() {}

    public Client(long inn) {
        this.inn = inn;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}