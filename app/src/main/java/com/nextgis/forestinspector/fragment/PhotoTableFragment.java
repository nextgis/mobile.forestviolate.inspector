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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nextgis.forestinspector.R;
import com.nextgis.forestinspector.activity.PhotoTableActivity;
import com.nextgis.forestinspector.adapter.PhotoTableAdapter;
import com.nextgis.forestinspector.util.Constants;
import com.nextgis.maplib.map.MapBase;

import java.io.File;


public class PhotoTableFragment
        extends Fragment
        implements PhotoTableActivity.OnPhotoTakedListener
{
    protected static final int MIN_IMAGE_SIZE_DP   = 130;
    protected static final int CARD_VIEW_MARGIN_DP = 8;
    protected static final int CARD_ELEVATION_DP   = 2;
    protected static final int CONTENT_PADDING_DP  = 2;
    protected static final int MAX_ITEM_COUNT      = 4;

    protected int mRealPhotoCount;
    protected int mPhotoRealWidthPX;

    protected RecyclerView      mPhotoTable;
    protected PhotoTableAdapter mPhotoTableAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        float density = getResources().getDisplayMetrics().density;
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int widthDP = (int) (widthPixels / density);
        int widthRestDP = widthDP - CARD_VIEW_MARGIN_DP;

        int photoSpaces = CONTENT_PADDING_DP * 2 + CARD_ELEVATION_DP * 2 + CARD_VIEW_MARGIN_DP;

        int cardViewMinWidthDP = MIN_IMAGE_SIZE_DP + photoSpaces;
        int minItemCount = widthRestDP / cardViewMinWidthDP;

        mRealPhotoCount = minItemCount > MAX_ITEM_COUNT ? MAX_ITEM_COUNT : minItemCount;
        int cardViewRealWidthDP = (widthRestDP + CARD_VIEW_MARGIN_DP) / mRealPhotoCount;
        int photoRealWidthDp = cardViewRealWidthDP - photoSpaces;
        mPhotoRealWidthPX = (int) (photoRealWidthDp * density);
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState)
    {
        // TODO: calculate mRealPhotoCount hear for screen rotation

        View view = inflater.inflate(R.layout.fragment_photo_table, null);
        mPhotoTable = (RecyclerView) view.findViewById(R.id.photo_table_rv);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(
                getActivity(), mRealPhotoCount, GridLayoutManager.VERTICAL, false);

        mPhotoTable.setLayoutManager(layoutManager);
        mPhotoTable.setHasFixedSize(true);

        setPhotoTableAdapter();

        return view;
    }


    protected void setPhotoTableAdapter()
    {
        File photoDir =
                new File(MapBase.getInstance().getPath(), Constants.TEMP_DOCUMENT_FEATURE_FOLDER);
        mPhotoTableAdapter = new PhotoTableAdapter(getActivity(), photoDir, mPhotoRealWidthPX);
        mPhotoTable.setAdapter(mPhotoTableAdapter);
    }


    @Override
    public void OnPhotoTaked()
    {
        setPhotoTableAdapter();
    }
}
