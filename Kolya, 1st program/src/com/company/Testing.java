package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class Testing {



        private Persist conversion = new Persist();

        @Test
        public void canIConvert() {
            assertEquals("1", 1, conversion.wordConversion("privet prikol"));
            assertEquals("2", 1, conversion.wordConversion("aabbdd ddbbaa"));
            assertEquals("3", 0, conversion.wordConversion("abab aaah"));
            

        }
    }
