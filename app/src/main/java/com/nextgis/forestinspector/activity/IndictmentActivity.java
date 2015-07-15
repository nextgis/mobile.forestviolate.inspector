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

package com.nextgis.forestinspector.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;

import com.nextgis.forestinspector.R;
import com.nextgis.forestinspector.util.SettingsConstants;
import com.nextgis.maplibui.activity.NGActivity;
import com.nextgis.maplibui.controlui.DateTimeControl;

import java.util.Calendar;

/**
 * Form of indictment
 */
public class IndictmentActivity extends NGActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_indictment);

        setToolbar(R.id.main_toolbar);
        setTitle(getText(R.string.indictment));

        EditText indictmentNumber = (EditText) findViewById(R.id.indictment_num);
        indictmentNumber.setText(getNewNumber());

        EditText author = (EditText) findViewById(R.id.author);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        author.setText(prefs.getString(SettingsConstants.KEY_PREF_USERDESC, ""));

        DateTimeControl datetime = (DateTimeControl)findViewById(R.id.create_datetime);
        datetime.setCurrentDate();

    }

    protected String getNewNumber(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        return day + "/" + month + "-" + year;
    }
}
