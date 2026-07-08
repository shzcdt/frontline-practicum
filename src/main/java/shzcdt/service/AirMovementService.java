package shzcdt.service;

import shzcdt.model.Hex;
import shzcdt.model.Unit;
import org.springframework.stereotype.Service;
import shzcdt.type.UnitType;


@Service
public class AirMovementService implements MovementService {

    @Override
    public boolean moveUnit(Unit unit, Hex target) {
        if (unit.getType() != UnitType.AIR) {
            System.out.println("Наземный юнит не может летать");
            return false;
        }

        unit.setQ(target.getQ());
        unit.setR(target.getR());

        System.out.println(unit.getName() + " летит на гекс (" +
                target.getQ() + ", " + target.getR() + ")");
        return true;
    }
}
