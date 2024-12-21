package cn.hl.hlhrms.service.impl;

import cn.hl.hlhrms.entity.Position;
import cn.hl.hlhrms.repository.PositionRepository;
import cn.hl.hlhrms.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 职位服务层实现类
 */

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position findPositionById(Integer id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.orElse(null); // 如果找不到职位，返回 null
    }

    @Override
    public Position addPosition(Position position) {
        // 可以添加额外的逻辑，比如检查职位名称是否重复
        return positionRepository.save(position);
    }

    @Override
    public Position updatePosition(Position position) {
        // 检查职位是否存在并更新
        return positionRepository.save(position);
    }

    @Override
    public List<Position> searchPositionByName(String name) {
        return positionRepository.findByNameContaining(name);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
