package sberBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Client", schema = "public")
public class ClientEntity {

    @Id
    @Column(name = "inn", nullable = false, unique = true)
    private long inn;

    @OneToMany(mappedBy = "clientEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountEntity> accountEntities;
}