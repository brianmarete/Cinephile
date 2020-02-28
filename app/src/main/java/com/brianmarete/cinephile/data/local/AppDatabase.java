package com.brianmarete.cinephile.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.brianmarete.cinephile.data.local.converter.CastListTypeConverter;
import com.brianmarete.cinephile.data.local.converter.CreditResponseTypeConverter;
import com.brianmarete.cinephile.data.local.converter.CrewListTypeConverter;
import com.brianmarete.cinephile.data.local.converter.GenreListTypeConverter;
import com.brianmarete.cinephile.data.local.converter.MovieListTypeConverter;
import com.brianmarete.cinephile.data.local.converter.StringListConverter;
import com.brianmarete.cinephile.data.local.converter.TvListTypeConverter;
import com.brianmarete.cinephile.data.local.converter.VideoListTypeConverter;
import com.brianmarete.cinephile.data.local.dao.MovieDao;
import com.brianmarete.cinephile.data.local.dao.TvDao;
import com.brianmarete.cinephile.data.local.entity.MovieEntity;
import com.brianmarete.cinephile.data.local.entity.TvEntity;

@Database(entities = {MovieEntity.class, TvEntity.class}, version = 1,  exportSchema = false)
@TypeConverters({GenreListTypeConverter.class, VideoListTypeConverter.class,
        CreditResponseTypeConverter.class, MovieListTypeConverter.class,
        CastListTypeConverter.class, CrewListTypeConverter.class,
        StringListConverter.class, TvListTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    public abstract TvDao tvDao();


    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "Entertainment.db")
                .allowMainThreadQueries().build();
    }
}
