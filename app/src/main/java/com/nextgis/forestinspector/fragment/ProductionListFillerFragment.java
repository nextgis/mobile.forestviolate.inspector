/*
 * Project: Forest violations
 * Purpose: Mobile application for registering facts of the forest violations.
 * Author:  Dmitry Baryshnikov (aka Bishop), bishop.dev@gmail.com
 * Author:  NikitaFeodonit, nfeodonit@yandex.com
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

import com.nextgis.forestinspector.adapter.ListFillerAdapter;
import com.nextgis.forestinspector.adapter.ProductionListFillerAdapter;
import com.nextgis.forestinspector.datasource.DocumentFeature;
import com.nextgis.forestinspector.dialog.ListFillerDialog;
import com.nextgis.forestinspector.dialog.ProductionListFillerDialog;


public class ProductionListFillerFragment
        extends ListFillerFragment
{
    @Override
    protected ListFillerAdapter getFillerAdapter(DocumentFeature feature)
    {
        return new ProductionListFillerAdapter(feature);
    }


    @Override
    protected ListFillerDialog getFillerDialog()
    {
        return new ProductionListFillerDialog();
    }
}
