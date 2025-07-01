package mys.numerosaleatorios;

import mys.utilidades.Randomizer;

public class RandomMath implements Randomizer {

    @Override
    public double tirarRandom() {
        return Math.random(); 
    }

    
}
