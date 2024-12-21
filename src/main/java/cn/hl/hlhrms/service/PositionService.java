package cn.hl.hlhrms.service;

import cn.hl.hlhrms.entity.Position;

import java.util.List;

public interface PositionService {
    Position updatePosition(Position position);

    Position findPositionById(Integer positionId);

    Position addPosition(Position position);

    List<Position> getAllPositions();
}
