package comingsoon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComingSoonService {
   
   private ComingSoonDAO comingSoonDao;
   
   @Autowired
   public ComingSoonService(ComingSoonDAO comingSoonDao) {
      this.comingSoonDao = comingSoonDao;
   }
}




















