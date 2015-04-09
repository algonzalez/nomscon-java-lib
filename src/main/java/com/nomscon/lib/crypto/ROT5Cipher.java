/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

public final class ROT5Cipher extends AbstractRotationCipher {
    private final static int ROTATION_FACTOR = 5;
    private final static String DIGITS = "0123456789";

    public ROT5Cipher() {
        addConfig(ROTATION_FACTOR, DIGITS);
    }
}
