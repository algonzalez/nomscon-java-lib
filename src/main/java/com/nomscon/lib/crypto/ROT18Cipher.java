/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

// ROT18 combines ROT5 and ROT13
public final class ROT18Cipher extends AbstractRotationCipher {
    private final static int ROT5_ROTATION_FACTOR = 5;
    private final static int ROT13_ROTATION_FACTOR = 13;

    private final static String DIGITS = "0123456789";
    private final static String UCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String LCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";

    public ROT18Cipher() {
        addConfig(ROT5_ROTATION_FACTOR, DIGITS);
        addConfig(ROT13_ROTATION_FACTOR, UCASE_CHARS);
        addConfig(ROT13_ROTATION_FACTOR, LCASE_CHARS);
    }
}
