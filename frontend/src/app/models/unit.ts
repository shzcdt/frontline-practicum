import { UnitType } from './unit-type';

export interface Unit{
  id: number;
  name: string;
  hp: number;
  attack: number;
  defense: number;
  type: UnitType;
  q: number;
  r: number;
}
