package android.example.roomwordsample;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }
    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(()->{
            mWordDao.insert(word);
        });
    }

    LiveData<List<Word>> mySearch(String query){
        mAllWords= mWordDao.mSearch(query);
        return mAllWords;
    }
}
