import { Component, OnInit } from '@angular/core';
import { HexCell } from './hex-cell/hex-cell';
import { UnitService } from '../services/unit.service';
import { Hex } from '../models/hex';
import { Unit } from '../models/unit';
import { TerrainType } from '../models/terrain-type';
import { UnitType } from '../models/unit-type';
import { UnitPanel } from '../unit-panel/unit-panel';

@Component({
  selector: 'app-hex-map',
  imports: [HexCell, UnitPanel],
  templateUrl: './hex-map.html',
  styleUrl: './hex-map.css',
})
export class HexMap implements OnInit {
  hexes: Hex[] = [];
  units: Unit[] = [];
  selectedUnit: Unit | null = null;
  constructor(private unitService: UnitService) {}
  ngOnInit() {
    this.generateMap();
    this.placeTestUnits();
  }
  generateMap() {
    for (let q = -2; q <= 2; q++) {
      for (let r = -2; r <= 2; r++) {
        this.hexes.push({ q, r, terrain: TerrainType.FIELD });
      }
    }
  }
  placeTestUnits() {
    this.units = [
      { id: 1, name: 'Пехота 1', hp: 100, attack: 10, defense: 5, type: UnitType.INFANTRY, q: -1, r: 0 },
      { id: 2, name: 'Кавалерия 1', hp: 80, attack: 15, defense: 3, type: UnitType.CAVALRY, q: 1, r: 0 },
    ];
  }
  onHexClick(hex: Hex) {
    if (this.selectedUnit) {
      this.moveUnit(hex);
    }
  }
  onUnitClick(unit: Unit) {
    this.selectedUnit = unit;
  }
  moveUnit(targetHex: Hex) {
    if (!this.selectedUnit) return;

    this.unitService.moveUnit(this.selectedUnit.id, targetHex.q, targetHex.r)
      .subscribe({
        next: (response) => {
          this.selectedUnit!.q = targetHex.q;
          this.selectedUnit!.r = targetHex.r;
          this.selectedUnit = null;
        },
        error: (err) => {
          alert('Не удалось переместить юнит: ' + err.error);
        }
      });
  }
  getUnitAtHex(hex: Hex): Unit | undefined {
    return this.units.find(unit => unit.q === hex.q && unit.r === hex.r);
  }
  isUnitSelected(hex: Hex): boolean {
    return this.selectedUnit !== null &&
           this.selectedUnit.q === hex.q &&
           this.selectedUnit.r === hex.r;
  }
}
