package android.example.roomwordsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }


    LiveData<List<Word>> getFilter(String query) {
        mAllWords = mRepository.mySearch(query);
        return mAllWords;
    }
}
