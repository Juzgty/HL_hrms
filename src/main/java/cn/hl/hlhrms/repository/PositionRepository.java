package cn.hl.hlhrms.repository;

import cn.hl.hlhrms.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 职位持久层接口
 */

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    /**
     * 根据职位名称查询职位
     * @param posName 职位名称
     * @return 职位实体
     */
    Position findByPosName(String posName);

    List<Position> findByNameContaining(String name);
}
