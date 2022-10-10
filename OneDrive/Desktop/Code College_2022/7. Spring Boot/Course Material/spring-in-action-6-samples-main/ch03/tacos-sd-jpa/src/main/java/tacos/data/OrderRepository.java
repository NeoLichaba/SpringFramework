package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.util.List;




import tacos.TacoOrder;
import tacos.User;

public interface OrderRepository 
         extends CrudRepository<TacoOrder, Long> {
	List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
