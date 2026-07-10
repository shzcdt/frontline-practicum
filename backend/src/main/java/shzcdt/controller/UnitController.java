package shzcdt.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shzcdt.model.Hex;
import shzcdt.model.Unit;
import shzcdt.service.MovementService;
import shzcdt.type.TerrainType;
import shzcdt.type.UnitType;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final MovementService groundMovementService;
    private final MovementService airMovementService;


    public UnitController(
            @Qualifier("groundMovementService") MovementService groundMovementService,
            @Qualifier("airMovementService") MovementService airMovementService) {
        this.groundMovementService = groundMovementService;
        this.airMovementService = airMovementService;
    }


    @PostMapping("/{unitId}/move")
    public ResponseEntity<String> moveGroundUnit(
            @PathVariable("unitId") Long unitId,
            @RequestParam("q") int q,
            @RequestParam("r") int r) {

        Unit unit = new Unit(unitId, "TestUnit", 100, 10, 5, UnitType.INFANTRY);

        Hex targetHex = new Hex(q, r, TerrainType.FIELD);

        boolean success = groundMovementService.moveUnit(unit, targetHex);
        if (success) {
            return ResponseEntity.ok("Юнит успешно перемещён");
        } else {
            return ResponseEntity.badRequest().body("Не удалось переместить юнит");
        }
    }

    @PostMapping("/{unitId}/fly")
    public ResponseEntity<String> moveAirUnit(
            @PathVariable("unitId") Long unitId,
            @RequestParam("q") int q,
            @RequestParam("r") int r) {

        Unit unit = new Unit(unitId, "TestUnit", 100, 10, 5, UnitType.AIR);

        Hex targetHex = new Hex(q, r, TerrainType.FIELD);

        boolean success = airMovementService.moveUnit(unit, targetHex);
        if (success) {
            return ResponseEntity.ok("Юнит успешно перелетел");
        } else {
            return ResponseEntity.badRequest().body("Юниту не удалось перелететь");
        }
    }
}
