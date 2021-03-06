/*
 * Copyright 2017 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.stage.demo.scene;

/*
 * Created by Hippo on 5/3/2017.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hippo.android.dialog.base.DialogView;
import com.hippo.stage.Curtain;
import com.hippo.stage.SceneInfo;
import com.hippo.stage.curtain.FadeCurtain;
import com.hippo.stage.demo.R;
import java.util.List;

public abstract class DialogScene extends com.hippo.stage.dialog.DialogScene {

  @Override
  protected void onCreate(@Nullable Bundle args) {
    super.onCreate(args);

    TypedValue outValue = new TypedValue();
    getActivity().getTheme().resolveAttribute(R.attr.alertDialogTheme, outValue, true);
    setTheme(outValue.resourceId);
  }

  @Nullable
  @Override
  protected final View onCreateContentView(@NonNull LayoutInflater inflater,
      @NonNull ViewGroup container) {
    DialogView view = onCreateDialogView(inflater, container);
    view.setDialog(this);
    return view;
  }

  /**
   * Create a {@link DialogView} for this dialog.
   */
  @NonNull
  protected abstract DialogView onCreateDialogView(@NonNull LayoutInflater inflater,
      @NonNull ViewGroup container);

  @Nullable
  @Override
  protected Curtain onCreateCurtain(@NonNull SceneInfo upper, @NonNull List<SceneInfo> lower) {
    FadeCurtain curtain = new FadeCurtain();
    curtain.setDuration(150L);
    return curtain;
  }
}
