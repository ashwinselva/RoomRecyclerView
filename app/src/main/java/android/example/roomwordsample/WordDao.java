package android.example.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY name ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    @Query("SELECT * FROM word_table where name LIKE  '%'||:query||'%'" +
            "OR number LIKE  '%'||:query||'%' ")
    LiveData<List<Word>> mSearch(String query);
}

