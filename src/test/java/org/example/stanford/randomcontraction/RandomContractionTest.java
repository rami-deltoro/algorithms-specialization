package org.example.stanford.randomcontraction;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;


class RandomContractionTest {

    final RandomContraction randomContraction = new RandomContraction();

    @Test
    public void test() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("SimpleInput.txt").getFile());
        Graph g = new Graph(file);
        g.printGraph();
        //System.out.println(randomContraction.findMinCut(g));
    }
}