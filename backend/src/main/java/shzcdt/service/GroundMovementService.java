package shzcdt.service;

import org.springframework.stereotype.Component;
import shzcdt.model.Hex;
import shzcdt.model.Unit;
import shzcdt.type.TerrainType;
import shzcdt.type.UnitType;

@Component("groundMovementService")
public class GroundMovementService implements MovementService {

    @Override
    public boolean moveUnit(Unit unit, Hex target) {
        if (unit.getType() == UnitType.AIR) {
            System.out.println("Воздушный юнит не может использовать наземное перемещение");
            return false;
        }

        if (target.getTerrain() == TerrainType.RIVER) {
            System.out.println("Наземный юнит не может пересечь реку без инженера");
            return false;
        }

        unit.setQ(target.getQ());
        unit.setR(target.getR());

        System.out.println(unit.getName() + " перемещён на гекс (" +
                target.getQ() + ", " + target.getR() + ")");
        return true;
    }
}
