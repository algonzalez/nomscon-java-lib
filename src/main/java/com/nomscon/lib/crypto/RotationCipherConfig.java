/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

import com.nomscon.lib.Arg;

public class RotationCipherConfig {
    private final int rotationFactor;
    private final String charLookup;

    public RotationCipherConfig(int rotationFactor, String charLookup) {
        Arg.checkIsPositiveOrZero(rotationFactor);
        Arg.checkIsNotNullOrEmpty(charLookup);

        this.rotationFactor = rotationFactor;
        this.charLookup = charLookup;
    }

    public int getRotationFactor() { return rotationFactor; }
    public String getCharLookup() { return charLookup; }
}
