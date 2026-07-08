package shzcdt.service;

import shzcdt.model.Hex;
import shzcdt.model.Unit;


public interface MovementService {

    boolean moveUnit(Unit unit, Hex target);
}
