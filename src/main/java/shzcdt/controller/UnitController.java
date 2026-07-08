package shzcdt.controller;


import shzcdt.model.Hex;
import shzcdt.model.Unit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shzcdt.service.MovementService;
import shzcdt.type.TerrainType;
import shzcdt.type.UnitType;

@RestController
@RequestMapping("/api/units")
public class UnitController {
    private final MovementService movementService;

    public UnitController(MovementService movementService) {
        this.movementService = movementService;
    }

    @PostMapping("/{unitId}/move")
    public ResponseEntity<String> moveUnit(
            @PathVariable("unitId") Long unitId,
            @RequestParam("q") int q,
            @RequestParam("r") int r) {

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
