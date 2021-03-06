package com.tfApp.android.newstv.adaptors;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ottapp.android.basemodule.models.GenreModel;
import com.tfApp.android.newstv.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

    private List<GenreModel> detailsModel;
    private OnGentreSelectionListener onItemSelectionListener;


    public GenreAdapter(List<GenreModel> detailsModl, OnGentreSelectionListener onItemSelectionListener) {
        this.detailsModel = detailsModl;
        this.onItemSelectionListener = onItemSelectionListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.genre_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.ViewHolder holder, int position) {

        if (detailsModel != null && detailsModel.size() > position) {

            GenreModel media = detailsModel.get(position);
            String title = media.getName();

            holder.nameTextView.setText(title);

        }

    }
   public List<GenreModel> getSelectedLanguages(){
        return detailsModel;
   }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return detailsModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.lanuage_text);


            nameTextView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position > -1 && detailsModel != null && detailsModel.size() > position) {
                if (v == nameTextView) {
                    if (onItemSelectionListener != null) {
                        onItemSelectionListener.onItemSelect(detailsModel,position);
                    }
                }else {
                    if (onItemSelectionListener != null)
                        onItemSelectionListener.onItemSelect(detailsModel,position);
                }
            }
        }
    }
}

