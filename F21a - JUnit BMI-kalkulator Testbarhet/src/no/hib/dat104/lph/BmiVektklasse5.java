package no.hib.dat104.lph;

public enum BmiVektklasse5 {
    UNDERVEKT, NORMALVEKT, OVERVEKT, HELSESKADELIG_OVERVEKT;

    @Override 
    public String toString() {
        return name().toLowerCase();
      }
}
