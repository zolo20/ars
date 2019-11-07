package sberBoot.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Account", schema = "public")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private long accountNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inn")
    private ClientEntity clientEntity;
}
