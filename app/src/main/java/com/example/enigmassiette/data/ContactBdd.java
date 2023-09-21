package com.example.enigmassiette.data;

import android.provider.BaseColumns;

public class ContactBdd {

        public static final class bddStat implements BaseColumns {
            public static final String TABLE_NAME = "NoteRestau";
            public static final String COLUMN_NAME = "Nom";
            public static final String COLUMN_Time = "HeureDate";
            public static final String COLUMN_NOTE_DECO = "Deco";
            public static final String COLUMN_NOTE_NOURRITURE = "Nourriture";
            public static final String COLUMN_NOTE_SERVICE = "Service";
            public static final String COLUMN_Desc = "Description";

        }

}

