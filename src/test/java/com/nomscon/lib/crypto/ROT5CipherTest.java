/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

import org.junit.Test;
import static org.junit.Assert.*;

public class ROT5CipherTest {
    
    public ROT5CipherTest() {
    }

    @Test
    public void testSomeMethod() {
        // TODO:
                Cipher rot5 = new ROT5Cipher();
        Cipher rot13 = new ROT13Cipher();
        Cipher rot18 = new ROT18Cipher();
        Cipher rot47 = new ROT47Cipher();
        
        Cipher[] cyphers = new Cipher[] {
            new ROT5Cipher(),
            new ROT13Cipher(),
            new ROT18Cipher(),
            new ROT47Cipher(),
        };
        
        String text = "Text to encode: ABC @123# Hello World!";
        String encodedText;
        
//        println(text);
//        println("=====");
//
//        for (Cipher cypher : cyphers) {
//            String name = cypher.getClass().getSimpleName();
//            encodedText = cypher.encode(text);
//            println("%s.encode: %s", name, encodedText);
//            println("%s.decode: %s", name, cypher.decode(encodedText));
//            println("-----");
//        }
    }
    
}
