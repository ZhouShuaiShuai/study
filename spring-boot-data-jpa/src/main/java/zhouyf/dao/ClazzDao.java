
package zhouyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhouyf.pojo.Clazz;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:04
 */

@Repository
public interface ClazzDao extends JpaRepository<Clazz, String> {
}
