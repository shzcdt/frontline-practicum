import { Component, signal } from '@angular/core';
import { HexMap } from './hex-map/hex-map';

@Component({
  selector: 'app-root',
  imports: [HexMap],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
