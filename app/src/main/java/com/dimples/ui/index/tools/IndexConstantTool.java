package com.dimples.ui.index.tools;

import android.support.annotation.IntDef;

import static com.dimples.ui.index.tools.IndexConstantTool.BOOK;
import static com.dimples.ui.index.tools.IndexConstantTool.DISCOVER;
import static com.dimples.ui.index.tools.IndexConstantTool.MINE;

@IntDef({BOOK, DISCOVER, MINE})
public @interface IndexConstantTool {
    int BOOK = 0;
    int DISCOVER = 1;
    int MINE = 2;
}
