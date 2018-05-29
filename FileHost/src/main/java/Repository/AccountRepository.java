package Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DTO.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
	Account findByUsername(@Param("Username") String Username);
}
