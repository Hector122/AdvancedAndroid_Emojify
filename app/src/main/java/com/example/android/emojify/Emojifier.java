package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    static void detectFaces(Context context, Bitmap bitmap){
        // instance a face detector
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();


        //crating a frame instance
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();


        //Calling the detector synchronously
        SparseArray<Face> faces = detector.detect(frame);

        Log.i("Emojifier", "--------- detectFaces() Number of faces = " + faces.size());

        // If there are no faces detected, show a Toast message
        if(faces.size() == 0){
            Toast.makeText(context, "no_faces_message found", Toast.LENGTH_SHORT).show();
        }


        detector.release();
    }
}
