package android.example.roomwordsample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder {
    private final TextView wordItemView;
    private final TextView numItemView;
    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        wordItemView = itemView.findViewById(R.id.textName);
        numItemView = itemView.findViewById(R.id.textNumber);
    }

    public void bind(String text1, String text2){
        wordItemView.setText(text1);
        numItemView.setText(text2);
    }

    static WordViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item,parent,false);
        return new WordViewHolder(view);
    }
}
