/*
 * This code is licensed under "The MIT License"
 * Copyright (c) 2015 by Alberto Gonzalez
 *
 * Please see the included 'LICENSE.txt' file for the full text of the license.
 */
package com.nomscon.lib.crypto;

import java.util.ArrayList;
import java.util.List;

public class AbstractRotationCipher implements Cipher {
    protected final List<RotationCipherConfig> configs = new ArrayList<>();

    @Override
    public String encode(String unencodedText) {
        if (unencodedText == null || unencodedText.isEmpty()) {
            return unencodedText;
        }
        return rotateChars(unencodedText);
    }

    @Override
    public String decode(String encodedText) {
        if (encodedText == null || encodedText.isEmpty()) {
            return encodedText;
        }
        return rotateChars(encodedText);
    }        

    protected void addConfig(int rotationFactor, String charLookup) {
        configs.add(new RotationCipherConfig(rotationFactor, charLookup));
    }

    protected String rotateChars(String text) {
        if (configs.isEmpty())
            return text;

        final int textLen = text.length();
        final StringBuilder result = new StringBuilder(textLen);

        for (int i = 0; i < textLen; i++) {
            char c = text.charAt(i);
            for (RotationCipherConfig config : configs) {
                String charLookup = config.getCharLookup();
                int charIndex = charLookup.indexOf(c);
                if (charIndex >= 0) {
                    charIndex = (charIndex + config.getRotationFactor()) % charLookup.length();
                    c = charLookup.charAt(charIndex);
                    break;
                }
            }
            result.append(c);
        }
        return result.toString();
    }
}
