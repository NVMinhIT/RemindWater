package multiaccounts.parallel.tarallel.com.remindwater.screen.main.changeglass;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import multiaccounts.parallel.tarallel.com.remindwater.R;
import multiaccounts.parallel.tarallel.com.remindwater.listener.IOnClickListeners;
import multiaccounts.parallel.tarallel.com.remindwater.model.Glass;

/**
 * Created by oanhnov .
 * On 7/15/2019.
 */
public class AdapterGlass extends RecyclerView.Adapter<AdapterGlass.MyViewHolder> {
    private Context context;
    private List<Glass> mGlassList;

    private IOnClickListeners<Glass> mListeners;


    public AdapterGlass(Context context, List<Glass> mGlassList) {
        this.context = context;
        this.mGlassList = mGlassList;
    }

    public void setListeners(IOnClickListeners<Glass> listeners) {
        mListeners = listeners;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycleview_glass, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Glass glass = mGlassList.get(i);
        myViewHolder.imageViewGlass.setImageResource(glass.getIdImage());
        myViewHolder.tvAmount.setText(glass.getAmount());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListeners.onClick(glass);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mGlassList == null ? 0 : mGlassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewGlass;
        TextView tvAmount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewGlass = itemView.findViewById(R.id.img_cup);
            tvAmount = itemView.findViewById(R.id.txt_soluong);
        }
    }
}
