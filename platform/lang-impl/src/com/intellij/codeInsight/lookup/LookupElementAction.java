/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.codeInsight.lookup;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static com.intellij.openapi.util.NlsUI.ListItem;

/**
 * @author peter
 */
public abstract class LookupElementAction {
  private final Icon myIcon;
  private final String myText;

  protected LookupElementAction(@Nullable Icon icon, @NotNull @ListItem String text) {
    myIcon = icon;
    myText = text;
  }

  @Nullable
  public Icon getIcon() {
    return myIcon;
  }

  public String getText() {
    return myText;
  }

  public abstract Result performLookupAction();

  public static class Result {
    public static final Result HIDE_LOOKUP = new Result();
    public static final Result REFRESH_ITEM = new Result();

    public static class ChooseItem extends Result {
      public final LookupElement item;

      public ChooseItem(LookupElement item) {
        this.item = item;
      }
    }
  }
}
