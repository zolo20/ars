package repository;

import clients.entity.Client;

import java.util.List;

public interface ClientsServices {

        default List<Client> findAll() {
            return  null;
        }
        default Client findByInn(long id){
            return null;
        }
        default double getAmountSumByInn(long id) {
            return 0;
        }
}
