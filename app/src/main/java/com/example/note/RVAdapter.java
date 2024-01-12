package com.example.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.databinding.EachRvBinding;

public class RVAdapter extends ListAdapter<Note,RVAdapter.ViewHolder>
{

    public RVAdapter(){
        super(CALLBACK);

    }
    public static  final DiffUtil.ItemCallback<Note> CALLBACK=new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitel().equals(newItem.getTitel())
                    && oldItem.getDisv().equals(newItem.getDisv());
        }
    };
 @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note= getItem(position);
        holder.binding.titleRV.setText(note.getTitel());
        holder.binding.dipsRv.setText(note.getDisv());

    }
    public Note getNote(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    EachRvBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = EachRvBinding.bind(itemView);

        }
    }
}
