package com.example.myapp;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Myadapter extends FirebaseRecyclerAdapter<model,Myadapter.Myviewholder> {
    Context context;
    Context c = context;
    public Myadapter(@NonNull FirebaseRecyclerOptions<model> options, Context context) {

        super(options);
        this.context = context;


    }
    class Myviewholder extends RecyclerView.ViewHolder {

        TextView name,faculty,Count;
        ImageView Download,Likes;



        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            faculty = (TextView) itemView.findViewById(R.id.Faculty);
            Download = (ImageView) itemView.findViewById(R.id.download);
            name = (TextView) itemView.findViewById(R.id.question);
            Likes = (ImageView) itemView.findViewById(R.id.likes);
            Count = (TextView) itemView.findViewById(R.id.count);


        }

    }


    @Override
    protected void onBindViewHolder(@NonNull final Myviewholder myviewholder, int i, @NonNull final model Model) {
        myviewholder.name.setText(Model.getName());
        final String course = Model.getCourse();
        myviewholder.faculty.setText(Model.getFaculty());
        final String url = Model.getUrl();
        ImageView load = myviewholder.Download;
        final Uri uri = Uri.parse(url);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFile(uri,course);

            }
        });


    }
    public void downloadFile(Uri uri,String title) {


        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("title"+"DA");
        request.setDescription("Assignment");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);


        Long reference = downloadmanager.enqueue(request);
    }



    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview, null, false);

        return new Myadapter.Myviewholder(view);
    }
    public void View_click(View v){
        Intent i = new Intent();
        i.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);

    }





}









