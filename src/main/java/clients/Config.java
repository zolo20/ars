package clients;

import javax.persistence.*;

public class Config {

    @Basic
    @Column(name = "accountNo", nullable = false, unique = true)
    private long accountNumber;

    @Basic
    @Column(nullable = false)
    private double balance;

    @Basic
    @Column(name = "user_id", nullable = false)
    private long userId;

}
