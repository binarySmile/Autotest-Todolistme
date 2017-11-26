package com.github.binarySmile.todolistmeautotest.core.utils;

import java.util.ArrayList;

public abstract class Util {
    public static boolean firstSort(ArrayList <String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
