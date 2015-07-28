/*
 * Project: Forest violations
 * Purpose: Mobile application for registering facts of the forest violations.
 * Author:  Dmitry Baryshnikov (aka Bishop), bishop.dev@gmail.com
 * *****************************************************************************
 * Copyright (c) 2015-2015. NextGIS, info@nextgis.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.nextgis.forestinspector.fragment;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;

import java.util.Locale;

/**
 * Tab
 */
public class TabFragment extends Fragment {
    protected String mFragmentName;

    public TabFragment() {
    }

    @SuppressLint("ValidFragment")
    public TabFragment(String fragmentName) {
        Locale l = Locale.getDefault();
        mFragmentName = fragmentName.toUpperCase(l);
    }

    public String getName(){
        return mFragmentName;
    }
}
