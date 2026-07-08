package shzcdt.model;


import shzcdt.type.TerrainType;

public class Hex {
    private Long id;
    private int q;
    private int r;
    private TerrainType terrain;
    private String ownerFaction;

    public Hex(int q, int r, TerrainType terrain) {
        this.q = q;
        this.r = r;
        this.terrain = terrain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
    }

    public String getOwnerFaction() {
        return ownerFaction;
    }

    public void setOwnerFaction(String ownerFaction) {
        this.ownerFaction = ownerFaction;
    }
}
