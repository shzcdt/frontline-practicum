package service;

import model.Hex;
import model.Unit;


public interface MovementService {

    boolean moveUnit(Unit unit, Hex target);
}
