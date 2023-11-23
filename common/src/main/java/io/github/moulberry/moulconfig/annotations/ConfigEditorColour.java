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

package io.github.moulberry.moulconfig.annotations;

import io.github.moulberry.moulconfig.ChromaColour;
import io.github.moulberry.moulconfig.observer.Property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used for colours. The field associated with this option may only be of type {@link String}.
 * <p>
 * To interpret the String value see {@link ChromaColour#forLegacyString}. You can use a
 * {@link Property Property<String>} and {@link Property#map} for more ergonomic use.
 * To create a default value use {@link ChromaColour#special(int, int, int, int, int)}.
 * <p>
 * In the future, {@link ChromaColour} may also be used as a field type.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigEditorColour {
}
