import { Component, Input } from '@angular/core';
import { Unit } from '../models/unit';
@Component({
  selector: 'app-unit-panel',
  imports: [],
  templateUrl: './unit-panel.html',
  styleUrl: './unit-panel.css',
})
export class UnitPanel {
  @Input() unit: Unit | null = null;
}
