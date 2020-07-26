package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BacktrackingTest {
    Backtracking backtracking = new Backtracking();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void permute() {
        backtracking.permute(new int[]{1,2,3,4})
                .stream()
                .forEach(c->{
                     System.out.println(c);
                });
    }

    @Test
    public void generateParenthesis() {
        backtracking.generateParenthesis(3)
                .stream()
                .forEach(c -> {
                    System.out.println(c);
                });
    }
}