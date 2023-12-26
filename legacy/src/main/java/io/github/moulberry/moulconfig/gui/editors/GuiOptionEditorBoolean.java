/*
 * Copyright (C) 2023 NotEnoughUpdates contributors
 *
 * This file is part of MoulConfig.
 *
 * MoulConfig is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * MoulConfig is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MoulConfig. If not, see <https://www.gnu.org/licenses/>.
 *
 */

package io.github.moulberry.moulconfig.gui.editors;

import io.github.moulberry.moulconfig.Config;
import io.github.moulberry.moulconfig.common.IMinecraft;
import io.github.moulberry.moulconfig.gui.GuiComponent;
import io.github.moulberry.moulconfig.gui.GuiImmediateContext;
import io.github.moulberry.moulconfig.gui.component.CenterComponent;
import io.github.moulberry.moulconfig.gui.component.PanelComponent;
import io.github.moulberry.moulconfig.gui.component.SwitchComponent;
import io.github.moulberry.moulconfig.observer.GetSetter;
import io.github.moulberry.moulconfig.observer.Property;
import io.github.moulberry.moulconfig.processor.ProcessedOption;
import lombok.var;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuiOptionEditorBoolean extends ComponentEditor {

    private final GuiComponent bool;

    public GuiOptionEditorBoolean(
        ProcessedOption option,
        int runnableId,
        Config config
    ) {
        super(option);
        var prop = Property.upgrade((GetSetter<Boolean>) option.intoProperty());
        prop.whenChanged((oldValue, newValue) -> config.executeRunnable(runnableId));
        bool = wrapComponent(new CenterComponent(new SwitchComponent(prop, 200)));
    }

    @Override
    public @NotNull GuiComponent getDelegate() {
        return bool;
    }

}
