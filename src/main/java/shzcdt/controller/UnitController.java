package controller;


import model.Hex;
import model.Unit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.MovementService;
import type.TerrainType;
import type.UnitType;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final MovementService movementService;

    public UnitController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/{unitId}/move")
    public ResponseEntity<String> moveUnit(
            @PathVariable Long unitId,
            @RequestParam int q,
            @RequestParam int r) {

        Unit unit = new Unit(unitId, "TestUnit", 100, 10, 5, UnitType.INFANTRY);

        Hex targetHex = new Hex(q, r, TerrainType.FIELD);

        boolean success = movementService.moveUnit(unit, targetHex);
        if (success) {
            return ResponseEntity.ok("Юнит успешно перемещён");
        } else {
            return ResponseEntity.badRequest().body("Не удалось переместить юнит");
        }
    }
}
