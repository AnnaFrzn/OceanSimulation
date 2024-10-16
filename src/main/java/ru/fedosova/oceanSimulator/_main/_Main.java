package ru.fedosova.oceanSimulator._main;

import ru.fedosova.oceanSimulator.entity.Shark;
import ru.fedosova.oceanSimulator.util.EventMaker;

public class _Main {

    public static void main(String[] args) {
        Shark shark = new Shark();
        EventMaker eventMaker = new EventMaker();
        eventMaker.startSimulation(shark);

    }
}
