import { TerrainType } from './terrain-type';

export interface Hex{
  q: number;
  r: number;
  terrain: TerrainType;
  ownerFaction?: string;
}
