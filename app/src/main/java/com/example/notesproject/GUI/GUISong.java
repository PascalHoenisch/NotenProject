package com.example.notesproject.GUI;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.notesproject.R;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GUISong extends AppCompatActivity {
    private static String songName = "";
    private static String songPath;
    private PdfRenderer renderer;
    private PdfRenderer.Page page;
    private int curPage = 0;
    private int pageCount;

    public static void setSongPath(String songPath) {
        GUISong.songPath = songPath;
    }

    public static void setSongName(String songName) {
        GUISong.songName = songName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song);

        TextView songTitle = findViewById(R.id.song_name);
        songTitle.setText(songName);


        //Code for PDF-Renderer (https://stackoverflow.com/questions/2456344/how-to-render-a-pdf-file-in-android)
        try {
            Uri uri = Uri.parse(songPath);


            renderer = new PdfRenderer(this.getContentResolver().openFileDescriptor(uri, "r"));
            pageCount = renderer.getPageCount();
            page = renderer.openPage(curPage);

            Bitmap bmp = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
            page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

            ImageView pdfView = findViewById(R.id.image_view_pdf);
            pdfView.setImageBitmap(bmp);



        } catch (FileNotFoundException e) {
            Log.e("Exception", "File not found");
        } catch (IOException e) {
            Log.e("Exception", "An IOException occured");
        }
        /*
        final int pageCount = renderer.getPageCount();
        Bitmap bmp = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < pageCount; i++) {
            PdfRenderer.Page page = renderer.openPage(i);
            page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

            page.close();
        }

        renderer.close();
         */
        //-------------------------------------------------------------------------------------------

        if (renderer != null) {
            Button prev = findViewById(R.id.prevPage);
            prev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (curPage > 0) {
                        page.close();
                        curPage--;

                        page = renderer.openPage(curPage);

                        Bitmap bmp = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
                        page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                        ImageView pdfView = findViewById(R.id.image_view_pdf);
                        pdfView.setImageBitmap(bmp);
                    }
                }
            });

            Button next = findViewById(R.id.nextPage);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (curPage < pageCount-1) {
                        page.close();
                        curPage++;

                        page = renderer.openPage(curPage);

                        Bitmap bmp = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);
                        page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                        ImageView pdfView = findViewById(R.id.image_view_pdf);
                        pdfView.setImageBitmap(bmp);
                    }
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        page.close();
        renderer.close();
    }
}
