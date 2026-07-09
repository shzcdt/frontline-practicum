import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Hex } from '../../models/hex';
import { Unit } from '../../models/unit';
@Component({
  selector: 'app-hex-cell',
  imports: [],
  templateUrl: './hex-cell.html',
  styleUrl: './hex-cell.css',
})
export class HexCell {
  @Input() hex!: Hex;
  @Input() unit?: Unit;
  @Input() isSelected: boolean = false;
  @Output() hexClick = new EventEmitter<Hex>();
  @Output() unitClick = new EventEmitter<Unit>();
  get hexStyle() {
    const size = 40;
    const x = size * (3/2 * this.hex.q);
    const y = size * (Math.sqrt(3)/2 * this.hex.q + Math.sqrt(3) * this.hex.r);
    return {
      left: `${x + 250}px`,
      top: `${y + 250}px`,
      backgroundColor: this.getTerrainColor()
    };
  }
  getTerrainColor(): string {
    switch (this.hex.terrain) {
      case 'FIELD': return '#90EE90';
      case 'FOREST': return '#228B22';
      case 'MOUNTAIN': return '#808080';
      case 'RIVER': return '#4169E1';
      case 'CITY': return '#FFD700';
      case 'FACTORY': return '#FF4500';
      default: return '#90EE90';
    }
  }
  onHexClick() {
    this.hexClick.emit(this.hex);
  }
  onUnitClick() {
    if (this.unit) {
      this.unitClick.emit(this.unit);
    }
  }
}
