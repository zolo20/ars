package clients.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "user_id")
    private long userId;

    @Column()
    private long inn;

    public Client() {}

    public Client(long userId, long inn) {
        this.userId = userId;
        this.inn = inn;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }
}