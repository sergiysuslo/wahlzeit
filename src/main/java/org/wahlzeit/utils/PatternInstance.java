package org.wahlzeit.utils;

import java.lang.annotation.*;

public @interface PatternInstance {
    String patternName();
    String[] participants();
}
