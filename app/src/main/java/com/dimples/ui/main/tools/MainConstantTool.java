package com.dimples.ui.main.tools;

import android.support.annotation.IntDef;

import static com.dimples.ui.main.tools.MainConstantTool.BOOK;
import static com.dimples.ui.main.tools.MainConstantTool.DISCOVER;
import static com.dimples.ui.main.tools.MainConstantTool.MINE;

@IntDef({BOOK, DISCOVER, MINE})
public @interface MainConstantTool {
    int BOOK = 0;
    int DISCOVER = 1;
    int MINE = 2;
}
